package com.stockmanager.fst.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.security.dao.UserDao;
import com.stockmanager.fst.security.entity.MyUser;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private DeptService dS;
	
	@Autowired
	private UserRoleService urS;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public int save(MyUser user) {
		MyUser userDB=uDao.findByName(user.getName());
		Dept dept=dS.findByLibelle(user.getDept().getLibelle());
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		if(userDB!=null) {
			return -1;
		}else {
			user.setDept(dept);
			user.setPassword(hashedPassword);
			uDao.save(user);
			return urS.addRolesToUser(user, user.getRoles());
			
		}
	}

	@Override
	public int update(MyUser user) {
		MyUser userDB=uDao.findById(user.getId()).get();
		Dept dept=dS.findByLibelle(user.getDept().getLibelle());

		if(userDB==null) {
			return -1;
		}else {
			user.setDept(dept);
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
	public MyUser findByName(String name) {
		return uDao.findByName(name);
	}

	@Override
	public List<MyUser> findAll() {
		return uDao.findAll();
	}

}
