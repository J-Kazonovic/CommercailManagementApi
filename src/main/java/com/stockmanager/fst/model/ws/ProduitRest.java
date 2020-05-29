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

import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.service.facade.ProduitService;

@RestController
@RequestMapping("/produit")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class ProduitRest {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/cat/libelle/{libelle}")
	public List<Produit> findByCatLibelle(@PathVariable String libelle) {
		return produitService.findByCatLibelle(libelle);
	}

	@GetMapping("/")
	public List<Produit> findAll() {
		return produitService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Produit produit) {
		return produitService.save(produit);
	}

	@GetMapping("/libelle/{libelle}")
	public Produit findByLibelle(@PathVariable String libelle) {
		return produitService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return produitService.deleteByLibelle(libelle);
	}
}
