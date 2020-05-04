package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.Category;

public interface CategoryService {

	public Category findByLibelle(String libelle);

	public List<Category> findAll();

	public int save(Category category);

	public int deleteByLibelle(String libelle);
}
