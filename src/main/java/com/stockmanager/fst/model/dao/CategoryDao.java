package com.stockmanager.fst.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

	public Category findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

}
