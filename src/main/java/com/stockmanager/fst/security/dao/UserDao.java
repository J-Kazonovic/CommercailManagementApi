package com.stockmanager.fst.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.security.entity.MyUser;

@Repository
public interface UserDao extends JpaRepository<MyUser, Long>{
	
	MyUser findByName(String name);

}
