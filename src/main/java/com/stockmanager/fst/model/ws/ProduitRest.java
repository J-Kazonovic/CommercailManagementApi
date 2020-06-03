package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.service.facade.ProduitService;

@RestController
@RequestMapping("/produit")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class ProduitRest {

	@Autowired
	private ProduitService produitService;
	
	@PostMapping("/")
	public int save(@RequestBody Produit produit) {
		return produitService.save(produit);
	}
	
	@PutMapping("/")
	public int update(@RequestBody Produit produit) {
		return produitService.update(produit);
	}

	@DeleteMapping("/{id}")
	public int delete(@PathVariable Long id) {
		return produitService.delete(id);
	}



	@GetMapping("/")
	public Page<Produit> findAll(@RequestParam(defaultValue = "0" )int page) {
		return produitService.findAll(page);
	}

	@GetMapping("/cat/libelle/{libelle}")
	public List<Produit> findByCatLibelle(@PathVariable String libelle) {
		return produitService.findByCatLibelle(libelle);
	}

	@GetMapping("/ref/{ref}")
	public Produit findByRef(@PathVariable String ref) {
		return produitService.findByRef(ref);
	}

	@GetMapping("/libelle/{libelle}")
	public Produit findByLibelle(@PathVariable String libelle) {
		return produitService.findByLibelle(libelle);
	}

	
}
