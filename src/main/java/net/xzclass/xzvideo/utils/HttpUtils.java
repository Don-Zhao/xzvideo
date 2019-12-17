package net.xzclass.xzvideo.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * 	封装HTTP GET以及POST方法
 * 
 * @author zhao.jiahong
 *
 */
public class HttpUtils {

	private static final Gson gson = new Gson();
	
	/**
	 * 	HTTP实现GET请求
	 * 
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> doGet(String url) {
		Map<String, Object> map = new HashMap<>();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5000)  // 连接超时
			.setConnectionRequestTimeout(5000)  // 请求超时
			.setSocketTimeout(5000)
			.setRedirectsEnabled(true)    // 允许重定向
			.build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(config);
		
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				String jsonResult = EntityUtils.toString(response.getEntity());
				map = gson.fromJson(jsonResult, map.getClass());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	/**
	 *  HTTP执行POST方法
	 * @param url
	 * @param data
	 * @return
	 */
	public static String doPost(String url, String data) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5000)  // 连接超时
				.setConnectionRequestTimeout(5000)  // 请求超时
				.setSocketTimeout(5000)
				.setRedirectsEnabled(true)    // 允许重定向
				.build();
		httpPost.addHeader("Content-Type", "text/html; charset=UTF-8");
		if (data != null &&  data instanceof String) {
			StringEntity stringEntity = new StringEntity(data, "UTF-8");
			httpPost.setEntity(stringEntity);
		}
		httpPost.setConfig(config);
		
		
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(httpEntity);
				
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
