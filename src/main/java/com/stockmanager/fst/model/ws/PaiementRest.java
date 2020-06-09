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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.Paiement;
import com.stockmanager.fst.model.service.facade.PaiementService;

@RestController
@RequestMapping("/paiement")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class PaiementRest {
	
	@Autowired
	private PaiementService pS;

	@PostMapping("/")
	public int save(@RequestBody Paiement p) {
		return pS.save(p);
	}

	@PutMapping("/")
	public int update(@RequestBody Paiement p) {
		return pS.update(p);
	}

	@DeleteMapping("/{id}")
	public int delete(@PathVariable Long id) {
		return pS.delete(id);
	}

	@GetMapping("/")
	public List<Paiement> findAll() {
		return pS.findAll();
	}

	@GetMapping("facture/ref/{ref}")
	public List<Paiement> findByFactureRef(@PathVariable String ref) {
		return pS.findByFactureRef(ref);
	}
	
	
	

}
