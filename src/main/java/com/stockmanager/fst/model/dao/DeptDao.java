package com.stockmanager.fst.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Dept;

@Repository
public interface DeptDao extends JpaRepository<Dept, Long> {

	public Dept findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

}
