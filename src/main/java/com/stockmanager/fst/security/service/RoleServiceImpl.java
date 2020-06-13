package com.stockmanager.fst.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.security.dao.RoleDao;
import com.stockmanager.fst.security.entity.MyRole;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao rD;

	@Override
	public MyRole findByLibelle(String lib) {
		return rD.findByLibelle(lib);
	}

	@Override
	public List<MyRole> findAll() {
		return rD.findAll();
	}

}
