package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Personnel;

@Repository
public interface PersonnelDao extends JpaRepository<Personnel, Long> {

	Personnel findByCin(String cin);
	List<Personnel> findByDeptLibelle(String libelle);


}
