package net.xzclass.xzvideo.service;

import net.xzclass.xzvideo.daoobj.UserDaoObjBase;

/**
 * 	用户业务接口类
 * @author zhao.jiahong
 *
 */
public interface UserService {
	public UserDaoObjBase saveWechatUser(String code);
}
