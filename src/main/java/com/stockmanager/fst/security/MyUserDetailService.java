package com.stockmanager.fst.security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.security.dao.UserDao;
import com.stockmanager.fst.security.dao.UserRolesDao;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.entity.UserRole;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao uD;
	@Autowired
	private UserRolesDao uRD;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		MyUser user=uD.findByName(userName);
		if(user==null) {
			new UsernameNotFoundException("Not Found:" +userName);
		}
		return new MyUserDetails(user, getUserRoles(userName));
	} 
	
	
    List<GrantedAuthority> getUserRoles(String name){
		return uRD.findByUserName(name).stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getLibelle()))
                .collect(Collectors.toList());
	}

}
