package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class AuthantificationRest {
	
	@GetMapping("/")
	public List<GrantedAuthority> login(){
		return   (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}
}
