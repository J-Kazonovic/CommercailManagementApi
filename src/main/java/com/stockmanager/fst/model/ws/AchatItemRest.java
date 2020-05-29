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

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.model.service.facade.AchatItemService;

@RestController
@RequestMapping("/achatItems")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class AchatItemRest {

	@Autowired
	private AchatItemService dmmandeItemService;

	@GetMapping("/achat/ref/{ref}")
	public List<AchatItem> findByAchatRef(@PathVariable String ref) {
		return dmmandeItemService.findByAchatRef(ref);
	}

	@DeleteMapping("/{id}")
	public int deleteByAchatItemId(@PathVariable Long id) {
		return dmmandeItemService.deleteByAchatItemId(id);
	}


	@GetMapping("/")
	public List<AchatItem> findAll() {
		return dmmandeItemService.findAll();
	}
	
	

}
