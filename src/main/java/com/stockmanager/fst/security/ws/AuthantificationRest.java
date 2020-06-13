package com.stockmanager.fst.security.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.security.entity.AuthenticationRequest;
import com.stockmanager.fst.security.entity.AuthenticationResponse;
import com.stockmanager.fst.security.jwt.JwtUtil;

@RestController
@CrossOrigin(value = "*")
public class AuthantificationRest {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;

	private AuthenticationResponse response;

	@PostMapping("/authenticate")
	public AuthenticationResponse generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {

			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			response = new AuthenticationResponse();
			response.setJwtKey(jwtUtil.generateToken(authRequest.getUserName()));
			response.setUser_roles(auth.getAuthorities());
			response.setUser_name(authRequest.getUserName());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response = null;
		}

		return response;
	}

}
