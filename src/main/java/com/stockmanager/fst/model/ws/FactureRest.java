package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.FactureService;

@RestController
@RequestMapping("/facture")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class FactureRest {

	@Autowired
	private FactureService factureService;

	@GetMapping("/num/{num}")
	public Facture findByNum(@PathVariable Long num) {
		return factureService.findByNum(num);
	}

	@DeleteMapping("/num/{num}")
	public int deleteByNum(@PathVariable Long num) {
		return factureService.deleteByNum(num);
	}

	@PostMapping("/")
	public int save(@RequestBody Facture facture) {
		return factureService.save(facture);
	}

	@GetMapping("/comptable/libelle/{libelle}")
	public List<Facture> findByComptableLibelle(@PathVariable String libelle) {
		return factureService.findByComptableLibelle(libelle);
	}

	@GetMapping("/fournisseur/nom/{nom}")
	public List<Facture> findByFournisseurNom(@PathVariable String nom) {
		return factureService.findByFournisseurNom(nom);
	}

}
