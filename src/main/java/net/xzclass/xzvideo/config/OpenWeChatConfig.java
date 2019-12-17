package net.xzclass.xzvideo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 开放平台属性配置
 * 
 * @author zhao.jiahong
 *
 */
@Configuration
@PropertySource(value="classpath:wechat.properties")
public class OpenWeChatConfig {
	/**
	 * 微信开放平台二维码链接
	 */
	private final static String OPEN_QRCODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=SCOPE&state=%s#wechat_redirect";
	
	/**
	 * 开放平台获取access_token地址
	 */
	private static final String ACCESS_TOKEN_GET_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	
	/**
	 * 获取用户基本信息地址
	 */
	private static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
	
	/**
	 * 开放平台appid
	 */
	@Value("${weopen.appid}")
	private String openAppId;
	
	/**
	 * 开放平台appsecret
	 */
	@Value("${weopen.appsecret}")
	private String openAppSecret;
	
	/**
	 * 开放平台回调地址
	 */
	@Value("${weopen.redirect_url}")
	private String openRedirectUrl;

	public String getOpenAppId() {
		return openAppId;
	}

	public void setOpenAppId(String openAppId) {
		this.openAppId = openAppId;
	}

	public String getOpenAppSecret() {
		return openAppSecret;
	}

	public void setOpenAppSecret(String openAppSecret) {
		this.openAppSecret = openAppSecret;
	}

	public String getOpenRedirectUrl() {
		return openRedirectUrl;
	}

	public void setOpenRedirectUrl(String openRedirectUrl) {
		this.openRedirectUrl = openRedirectUrl;
	}
	
	public String getQrcodeUrl() {
		return OPEN_QRCODE_URL;
	}
	
	public String getAccessTokenUrl() {
		return ACCESS_TOKEN_GET_URL;
	}
	
	public String getUserInfoUrl() {
		return GET_USER_INFO_URL;
	}
}
