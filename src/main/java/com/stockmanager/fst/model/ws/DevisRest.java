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
import com.stockmanager.fst.bean.Devis;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DevisService;

@RestController
@RequestMapping("/devis")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class DevisRest {

	@Autowired
	private DevisService devisService;

	@GetMapping("/numero/{numero}")
	public Devis findByNumero(@PathVariable Long numero) {
		return devisService.findByNumero(numero);
	}

	@DeleteMapping("/numero/{numero}")
	public int deleteByNumero(@PathVariable Long numero) {
		return devisService.deleteByNumero(numero);
	}

	@PostMapping("/")
	public int save(@RequestBody Devis devis) {
		return devisService.save(devis);
	}

	@GetMapping("/comptable/libelle/{libelle}")
	public List<Devis> findByComptableLibelle(@PathVariable String libelle) {
		return devisService.findByComptableLibelle(libelle);
	}

	@GetMapping("/fournisseur/nom/{nom}")
	public List<Devis> findByFournisseurNom(@PathVariable String nom) {
		return devisService.findByFournisseurNom(nom);
	}

}
