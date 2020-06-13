package com.stockmanager.fst.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmanager.fst.security.entity.MyUser;


public interface UserService {
	int save(MyUser user);

	int update(MyUser user);

	int delete(Long id);

	MyUser findByNom(String nom);

	List<MyUser> findAll();

}
