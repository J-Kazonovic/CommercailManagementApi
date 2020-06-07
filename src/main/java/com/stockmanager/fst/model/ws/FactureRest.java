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

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FactureService;

@RestController
@RequestMapping("/factures")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class FactureRest {

	@Autowired
	private FactureService factureService;

	@PostMapping("/")
	public int save(@RequestBody Facture facture) {
		return factureService.save(facture);
	}
	

	@PutMapping("/")
	public int update(@RequestBody Facture facture) {
		return factureService.update(facture);
	}
	

	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return factureService.delete(id);
	}

	@GetMapping("/ref/{ref}")
	public Facture findByRef(@PathVariable String ref) {
		return factureService.findByRef(ref);
	}

	@GetMapping("/")
	public List<Facture> findAll() {
		return factureService.findAll();
	}

}
