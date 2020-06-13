package com.stockmanager.fst.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmanager.fst.security.entity.MyRole;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.entity.UserRole;


public interface UserRoleService {
	int addRolesToUser(MyUser user, List<UserRole> roles);

}
