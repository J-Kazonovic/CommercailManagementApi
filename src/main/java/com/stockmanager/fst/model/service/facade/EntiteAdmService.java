package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.Dept;

public interface EntiteAdmService {

	public Dept findByLibelle(String libelle);

	public List<Dept> findAll();

	public int save(Dept entite);

	public int deleteByLibelle(String libelle);
}
