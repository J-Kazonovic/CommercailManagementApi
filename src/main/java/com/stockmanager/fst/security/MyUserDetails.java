package com.stockmanager.fst.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stockmanager.fst.security.dao.UserRolesDao;
import com.stockmanager.fst.security.entity.MyRole;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.entity.UserRole;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MyUserDetails extends MyUser implements UserDetails {
	

	
	List<MyRole> roles;
	List<UserRole> userRoles;

	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(MyUser user,List<GrantedAuthority> authorities) {
		this.name=user.getName();
		this.password=user.getPassword();
		this.active=user.isActive();
		this.authorities=authorities;
    }
	
	

    public MyUserDetails() {
	}



    

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
