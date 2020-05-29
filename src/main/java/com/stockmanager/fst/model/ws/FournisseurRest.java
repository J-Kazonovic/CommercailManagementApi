package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.service.facade.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class FournisseurRest {

	@Autowired
	private FournisseurService fournisseurService;
	
	
    @PostMapping("/")
	public int save(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.save(fournisseur);
	}
    
    
    @PutMapping("/")
    public int update(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.update(fournisseur);
	}
    
    
    @DeleteMapping("/{id}")
	public int delete(@PathVariable Long id) {
		return fournisseurService.delete(id);
	}


	@GetMapping("/")
	public List<Fournisseur> findAll() {
		return fournisseurService.findAll();
	}

	@GetMapping("/nom/{nom}")
	public Fournisseur findByNom(@PathVariable String nom) {
		return fournisseurService.findByNom(nom);
	}



    @GetMapping("/term/{term}")
	public List<Fournisseur> findByNomContaining(@PathVariable String term) {
		return fournisseurService.findByNomContaining(term);
	}
	
	

	
	

}
