package net.xzclass.xzvideo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 微信配置类
 * @author zhao.jiahong
 *
 */
@Configuration
@ConfigurationProperties(prefix="wxpay")
@PropertySource(value="classpath:wechat.properties")
public class WeChatConfig {

	/**
	 * 	公众号ID
	 */
	private String appid;
	
	/**
	 *  公众号秘钥
	 */
	private String appsecret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
}
