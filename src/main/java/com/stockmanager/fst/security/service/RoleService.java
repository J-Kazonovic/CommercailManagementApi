package com.stockmanager.fst.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmanager.fst.security.entity.MyRole;


public interface RoleService {
	MyRole findByLibelle(String lib);
	List<MyRole> findAll();

}
