package com.stockmanager.fst.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.security.dao.UserDao;
import com.stockmanager.fst.security.entity.MyUser;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private UserRoleService urS;

	@Override
	public int save(MyUser user) {
		MyUser userDB=uDao.findByName(user.getName());
		if(userDB!=null) {
			return -1;
		}else {
			System.out.println(user.getRoles());
			uDao.save(user);
			return urS.addRolesToUser(user, user.getRoles());
			
		}
	}

	@Override
	public int update(MyUser user) {
		MyUser userDB=findByNom(user.getName());
		if(userDB==null) {
			return -1;
		}else {
			uDao.save(user);
			return urS.addRolesToUser(user, user.getRoles());
		}
	}

	@Override
	public int delete(Long id) {
		uDao.deleteById(id);
		return 1;
	}

	@Override
	public MyUser findByNom(String name) {
		return uDao.findByName(name);
	}

	@Override
	public List<MyUser> findAll() {
		return uDao.findAll();
	}

}
