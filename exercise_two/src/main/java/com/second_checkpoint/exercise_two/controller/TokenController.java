package com.second_checkpoint.exercise_two.controller;

import java.util.ArrayList;
import java.util.List;

import com.second_checkpoint.exercise_two.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.second_checkpoint.exercise_two.dto.jwt.JwtUser;
import com.second_checkpoint.exercise_two.dto.jwt.Login;
import com.second_checkpoint.exercise_two.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping
	public ResponseEntity<?> generate(@RequestBody final Login login){
		JwtUser jwtUser = new JwtUser();
		jwtUser = existUser(login);
		if(jwtUser != null) {
			List<String> lista = new ArrayList<>();
			lista.add(jwtGenerator.generate(jwtUser));
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	private JwtUser existUser(Login login) {
		if(login.getUser().equals(Constants.USER) && login.getPassword().equals(Constants.PASSWORD)) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setUserName(login.getUser());
			jwtUser.setId(1);
			jwtUser.setRole(Constants.USER_ROLE);
			return jwtUser;
			
		}else {
			return null;
		}
	}
}
