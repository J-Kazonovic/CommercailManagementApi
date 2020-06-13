package com.stockmanager.fst.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.security.entity.MyRole;

@Repository
public interface RoleDao extends JpaRepository<MyRole, Long>{
	MyRole findByLibelle(String lib);
}
