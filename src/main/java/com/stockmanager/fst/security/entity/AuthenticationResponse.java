package com.stockmanager.fst.security.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationResponse {
	
	private String jwtKey;
	private Collection<? extends GrantedAuthority> user_roles;
	private String user_name;
	

	public AuthenticationResponse() {
	}
	
	public String getJwtKey() {
		return jwtKey;
	}
	public void setJwtKey(String jwtKey) {
		this.jwtKey = jwtKey;
	}

	public Collection<? extends GrantedAuthority> getUser_roles() {
		return user_roles;
	}

	public void setUser_roles(Collection<? extends GrantedAuthority> user_roles) {
		this.user_roles = user_roles;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	

}
