package net.xzclass.xzvideo.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;

import io.jsonwebtoken.Claims;
import net.xzclass.xzvideo.model.JsonData;
import net.xzclass.xzvideo.utils.JwtUtils;

public class LoginInterceptor implements HandlerInterceptor{

	private static Gson gson = new Gson();
	
	/**
	 * 	进入controller之前进行拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("token");
		if (token == null) {
			token = request.getParameter("token");
		}
		
		if (token != null) {
			Claims claims = JwtUtils.checkJWT(token);
			if (claims != null) {
				Integer userId = (Integer)claims.get("id");
				String name = (String)claims.get("username");
				String img = (String)claims.get("img");
				
				request.setAttribute("user_id", userId);
				request.setAttribute("username", name);
				request.setAttribute("img", img);
				
				return true;
			}
		}
		
		sendJsonMessage(response, JsonData.buildError("请登录"));
		return false;
	}

	/**
	 * 	响应数据给前端
	 * 
	 * @param response
	 * @param obj
	 * @throws IOException 
	 */
	public static void sendJsonMessage(HttpServletResponse response, Object obj) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(obj));
		out.close();
		response.flushBuffer();
	}
}
