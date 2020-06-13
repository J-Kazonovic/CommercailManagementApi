package com.stockmanager.fst.security.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.entity.UserRole;

@Repository
public interface UserRolesDao extends JpaRepository<UserRole, Long>{
	
	List<UserRole> findByUserName(String name);

}
