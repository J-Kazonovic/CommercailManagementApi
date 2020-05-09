package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;


@RestController
@RequestMapping("/ebproduits")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class ExpressionBesoinProduitRest {
	
	@Autowired
	private ExpressionBesoinProduitService ebps;

	@GetMapping("/{ebID}")
	public List<ExpressionBesoinProduit> findByEb(@PathVariable Long ebID) {
		return ebps.findByEbId(ebID);
	}
    @DeleteMapping("/{id}")
	public int deleteByProduit(@PathVariable Long id) {
		return ebps.deleteByEbpId(id);
	}

    
	
	

}
