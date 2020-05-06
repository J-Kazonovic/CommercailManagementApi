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
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;

@RestController
@RequestMapping("/bonDeCommande")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class BonDeCommandeRest {

	@Autowired
	private BonDeCommandeService bonDeCommandeService;

	@GetMapping("/ref/{ref}")
	public BonDeCommande findByRef(@PathVariable String ref) {
		return bonDeCommandeService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return bonDeCommandeService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody BonDeCommande bonDeCommande) {
		return bonDeCommandeService.save(bonDeCommande);
	}

	@GetMapping("/comptable/libelle/{libelle}")
	public List<BonDeCommande> findByComptableLibelle(@PathVariable String libelle) {
		return bonDeCommandeService.findByComptableLibelle(libelle);
	}

	@GetMapping("/fournisseur/nom/{nom}")
	public List<BonDeCommande> findByFournisseurNom(@PathVariable String nom) {
		return bonDeCommandeService.findByFournisseurNom(nom);
	}

}
