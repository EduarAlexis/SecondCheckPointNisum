package com.second_checkpoint.exercise_one.security;

import com.second_checkpoint.exercise_one.constant.Constants;
import org.springframework.stereotype.Component;

import com.second_checkpoint.exercise_one.dto.jwt.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtGenerator {
	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		return Jwts.builder()
				.setClaims(claims)
				//.setIssuedAt(new Date())
				//.setExpiration(new Date(createdDate.getTime() + Constants.EXPIRATION * 1000))
				.signWith(SignatureAlgorithm.HS512, Constants.SECRET)
				.compact();
	}
}
