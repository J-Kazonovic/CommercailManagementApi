package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.Unite;

public interface UniteService {

	public Unite findByLibelle(String libelle);

	public List<Unite> findAll();

	public int save(Unite category);

	public int deleteByLibelle(String libelle);
}
