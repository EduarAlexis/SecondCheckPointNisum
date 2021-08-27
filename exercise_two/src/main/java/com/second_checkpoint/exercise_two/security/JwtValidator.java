package com.second_checkpoint.exercise_two.security;

import com.second_checkpoint.exercise_two.constant.Constants;
import org.springframework.stereotype.Component;

import com.second_checkpoint.exercise_two.dto.jwt.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.logging.Logger;

@Component
public class JwtValidator {

	final Logger LOG = Logger.getLogger("JwtValidator");

	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Constants.SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get(Constants.USER_ID)));
			jwtUser.setRole((String) body.get(Constants.ROLE));
			
		}catch(Exception e) {
			LOG.info(e.getMessage());
		}
		return jwtUser;
	}
}
