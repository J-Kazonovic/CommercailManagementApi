package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Achat;

@Repository
public interface AchatDao extends JpaRepository<Achat, Long> {
	public Achat findByRef(String ref);
	public List<Achat> findByFournisseurNom(String nom);
}
