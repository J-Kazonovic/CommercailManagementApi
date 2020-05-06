package com.stockmanager.fst.model.ws;

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
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.FactureService;
import com.stockmanager.fst.model.service.facade.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class FournisseurRest {

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("/nom/{nom}")
	public Fournisseur findByNom(@PathVariable String nom) {
		return fournisseurService.findByNom(nom);
	}

	@PostMapping("/")
	public int save(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.save(fournisseur);
	}

}
