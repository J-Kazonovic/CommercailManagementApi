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

import com.stockmanager.fst.bean.Unite;
import com.stockmanager.fst.model.service.facade.UniteService;

@RestController
@RequestMapping("/unite")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class UniteRest {

	@Autowired
	private UniteService uniteService;

	@GetMapping("/libelle/{libelle}")
	public Unite findByLibelle(@PathVariable String libelle) {
		return uniteService.findByLibelle(libelle);
	}

	@GetMapping("/")
	public List<Unite> findAll() {
		return uniteService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Unite unite) {
		return uniteService.save(unite);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return uniteService.deleteByLibelle(libelle);
	}

}
