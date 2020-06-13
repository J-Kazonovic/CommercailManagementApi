package com.stockmanager.fst.security.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.security.dao.UserRolesDao;
import com.stockmanager.fst.security.entity.MyRole;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.entity.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private RoleService rS;
	
	@Autowired
	private UserRolesDao usDao;

	@Override
	public int addRolesToUser(MyUser user, List<UserRole> roles) {
		Iterator<UserRole> itr = roles.iterator();
		while (itr.hasNext()) {
			UserRole ur = itr.next();
			MyRole role=rS.findByLibelle(ur.getRole().getLibelle());
			// Product Exist
			ur.setRole(role);
			ur.setUser(user);
			usDao.save(ur);
		}
		
		return 1;
	}

}
