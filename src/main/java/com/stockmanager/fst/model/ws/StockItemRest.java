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
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.StockItemService;

@RestController
@RequestMapping("/stockItems")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class StockItemRest {

	@Autowired
	private StockItemService stockItemService;

	@GetMapping("/produit/ref/{ref}")
	public List<StockItem> findByProduitRef(@PathVariable String ref) {
		return stockItemService.findByProduitRef(ref);
	}

	@DeleteMapping("/{libelle}")
	public int deleteByProduitLibelle(@PathVariable String libelle) {
		return stockItemService.deleteByProduitLibelle(libelle);
	}

	@GetMapping("/stock/ref/{ref}")
	public List<StockItem> findByStockRef(@PathVariable String ref) {
		return stockItemService.findByStockRef(ref);
	}



	@GetMapping("/")
	public List<StockItem> findAll() {
		return stockItemService.findAll();
	}

}
