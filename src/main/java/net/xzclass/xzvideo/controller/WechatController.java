package net.xzclass.xzvideo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.xzclass.xzvideo.config.OpenWeChatConfig;
import net.xzclass.xzvideo.daoobj.UserDaoObjBase;
import net.xzclass.xzvideo.model.JsonData;
import net.xzclass.xzvideo.service.UserService;
import net.xzclass.xzvideo.utils.JwtUtils;

@RestController
@RequestMapping("/wechat")
public class WechatController {
	
	@Autowired
	private OpenWeChatConfig openWeChatConfig;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 拼装扫一扫登录URL
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/login_url")
	public JsonData loginUrl(@RequestParam(value="access_page", required=true) String accessPage) throws UnsupportedEncodingException {
		
		String redirectUrl = openWeChatConfig.getOpenRedirectUrl(); // 获取开放平台重定向地址
		String callback = URLEncoder.encode(redirectUrl, "GBK"); //对重定向url进行编码
		
		String qrcodeUrl = String.format(openWeChatConfig.getQrcodeUrl(), openWeChatConfig.getOpenAppId(), callback, accessPage);
		
		return JsonData.buildSuccess(qrcodeUrl);
	}
	
	/**
	 *	 微信扫码登陆地址
	 * 
	 * @param code
	 * @param state
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/user/callback")
	public void wechatUserCallback(@RequestParam(value="code", required=true) String code, String state, HttpServletResponse response) throws IOException {
		System.out.println("code = " + code);
		System.out.println("state = " + state);
		UserDaoObjBase user = userService.saveWechatUser(code);
		if (user != null) {
			String token = JwtUtils.generatorJsonWebToken(user);
			response.sendRedirect(state + "?token=" + token + "&head_img=" + user.getHeadImg() + "&name=" + URLEncoder.encode(user.getName(), "UTF-8"));
		}
	}
}
