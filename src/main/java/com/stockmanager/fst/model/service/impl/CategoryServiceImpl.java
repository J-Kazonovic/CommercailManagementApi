package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Category;
import com.stockmanager.fst.model.dao.CategoryDao;
import com.stockmanager.fst.model.service.facade.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category findByLibelle(String libelle) {
		return categoryDao.findByLibelle(libelle);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public int save(Category category) {
		Category categoryFaound=findByLibelle(category.getLibelle());
		if(categoryFaound!=null) {
			return -1;
		}else {
			categoryDao.save(category);
			return 1;
		}
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return categoryDao.deleteByLibelle(libelle);
	}


}
