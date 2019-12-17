package net.xzclass.xzvideo.utils;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Claims;
import net.xzclass.xzvideo.daoobj.UserDaoObjBase;

public class JwtUtilsTest {

	@Test
	public void testGeneratorJsonWebToken() {
		UserDaoObjBase user = new UserDaoObjBase();
		user.setId(1);
		user.setName("Zhao.jiahong");
		user.setHeadImg("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1576503845&di=6de2b2650dfc9d2fb44406f9e9430227&src=http://pic1.win4000.com/pic/4/a8/93f8304732.jpg");
		
		String token = JwtUtils.generatorJsonWebToken(user);
		System.out.println(token);
	}
	
	@Test
	public void testCheckJWT() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4emNsYXNzIiwiaWQiOjEsInVzZXJuYW1lIjoiWmhhby5qaWFob25nIiwiaW1nIjoiaHR0cHM6Ly9zczAuYmRzdGF0aWMuY29tLzk0b0pmRF9iQUFjVDh0N21tOUdVS1QteGhfL3RpbWc_aW1hZ2UmcXVhbGl0eT0xMDAmc2l6ZT1iNDAwMF80MDAwJnNlYz0xNTc2NTAzODQ1JmRpPTZkZTJiMjY1MGRmYzlkMmZiNDQ0MDZmOWU5NDMwMjI3JnNyYz1odHRwOi8vcGljMS53aW40MDAwLmNvbS9waWMvNC9hOC85M2Y4MzA0NzMyLmpwZyIsImlhdCI6MTU3NjUwMzg5OCwiZXhwIjoxNTc3MTA4Njk4fQ.Y_OlpilIwNBb8Hr-xs_BZ30aUzUI0oR0alUn118N1K0";
		
		Claims claims = JwtUtils.checkJWT(token);
		if (claims != null) {
			String username = (String)claims.get("username");
			int id = (Integer)claims.get("id");
			String headImg = (String)claims.get("img");
			
			System.out.println(username);
			System.out.println(id);
			System.out.println(headImg);
		}
	}
}
