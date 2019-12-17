package net.xzclass.xzvideo.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.xzclass.xzvideo.config.OpenWeChatConfig;
import net.xzclass.xzvideo.daoobj.UserDaoObjBase;
import net.xzclass.xzvideo.mapper.UserMapper;
import net.xzclass.xzvideo.service.UserService;
import net.xzclass.xzvideo.utils.HttpUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OpenWeChatConfig config;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDaoObjBase saveWechatUser(String code) {
		
		// 获取access_token
		String accessTokenUrl = String.format(config.getAccessTokenUrl(), config.getOpenAppId(), config.getOpenAppSecret(), code);
		Map<String, Object> baseMap = HttpUtils.doGet(accessTokenUrl);
		if (baseMap == null || baseMap.isEmpty()) {
			return null;
		}
		
		String accessToken = (String)baseMap.get("access_token");
		String openId = (String)baseMap.get("openid");
		
		// 获取用户基本信息
		String userInfoUrl = String.format(config.getUserInfoUrl(), accessToken, openId);
		Map<String, Object> userInfoMap = HttpUtils.doGet(userInfoUrl);
		if (userInfoMap == null || userInfoMap.isEmpty()) {
			return null;
		}
		
		// 如果用户在数据库中存在，则返回
		String openid = (String)userInfoMap.get("openid");
		UserDaoObjBase dbUser = userMapper.findByOpenid(openid);
		if (null != dbUser) {
			return dbUser;
		}
		
		// 用户为第一次登陆，则插入数据库
		UserDaoObjBase user = new UserDaoObjBase();
		String nickname = (String)userInfoMap.get("nickname");
		String country = (String)userInfoMap.get("country");
		String province = (String)userInfoMap.get("province");
		String city = (String)userInfoMap.get("city");
		try {
			// 解决中文乱码问题
			nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");
			country = new String(country.getBytes("ISO-8859-1"), "UTF-8");
			province = new String(province.getBytes("ISO-8859-1"), "UTF-8");
			city = new String(city.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		user.setName(nickname);
		Double sexTemp = (Double)userInfoMap.get("sex");
		user.setSex(sexTemp.intValue());
		user.setCity(country + " " + province + " " + city);
		user.setHeadImg((String)userInfoMap.get("headimgurl"));
		user.setOpenid(openid);
		user.setSex((Integer)userInfoMap.get("sex"));
		user.setCreateTime(new Date());
		
		userMapper.saveUser(user);
		
		return user;
	}

}
