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

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.model.service.facade.AchatService;

@RestController
@RequestMapping("/achats")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class AchatRest {

	@Autowired
	private AchatService achatService;

	@PostMapping("/")
	public Achat save(@RequestBody Achat achat) {
		return achatService.save(achat, achat.getAchatItems());
	}
	
	@PutMapping("/")
	public int update(@RequestBody Achat achat) {
		return achatService.update(achat, achat.getAchatItems());
	}

	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return achatService.deleteById(id);
	}


	@GetMapping("/")
	public List<Achat> findAll() {
		return achatService.findAll();
	}
	@GetMapping("/ref/{ref}")
	public Achat findByRef(@PathVariable String ref) {
		return achatService.findByRef(ref);
	}
	@GetMapping("/nom/{nom}")
	public List<Achat> findByFournisseurNom(@PathVariable String nom) {
		return achatService.findByFournisseurNom(nom);
	}

}
