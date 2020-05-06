package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.Devis;

public interface DevisService {
	public Devis findByNumero(Long numero);

	public int deleteByNumero(Long numero);

	public int save(Devis devis);

	public List<Devis> findByComptableLibelle(String libelle);
	public List<Devis> findByFournisseurNom(String nom);
}
