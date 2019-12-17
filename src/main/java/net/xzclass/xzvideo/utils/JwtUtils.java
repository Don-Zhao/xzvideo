package net.xzclass.xzvideo.utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xzclass.xzvideo.daoobj.UserDaoObjBase;

public class JwtUtils {

	private static final String SUBJECT = "xzclass";
	
	private static final Long EXPIRE = 1000 * 60 * 60 * 24 * 7L;
	
	private static final String APPSECRET = "xzclass186";
	
	public static String generatorJsonWebToken(UserDaoObjBase user) {
		
		if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
			return null;
		}
		
		String token = Jwts.builder().setSubject(SUBJECT)
			.claim("id", user.getId())
			.claim("username", user.getName())
			.claim("img", user.getHeadImg())
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
			.signWith(SignatureAlgorithm.HS256, APPSECRET)
			.compact();
		
		return token;
	}
	
	public static Claims checkJWT(String token) {
		try {
			final Claims claims = Jwts.parser().setSigningKey(APPSECRET)
				.parseClaimsJws(token).getBody();
			
			return claims;
		} catch (Exception e) {
			return null;
		}
	}
}
