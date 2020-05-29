package com.stockmanager.fst.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Unite;

@Repository
public interface UniteDao extends JpaRepository<Unite, Long> {

	public Unite findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);

}
