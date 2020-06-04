package com.stockmanager.fst.model.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.StockService;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class StockRest {

	@Autowired
	private StockService stockService;

	@GetMapping("/date/{dateResu}")
	public List<Stock> findByDateResu(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateResu) {
		return stockService.findByDateResu(dateResu);
	}

	@PostMapping("/")
	public int save(@RequestBody Stock stock) {
		return stockService.save(stock, stock.getStockItems());
	}
	@PutMapping("/")
	public int update(@RequestBody Stock stock) {
		return stockService.update(stock, stock.getStockItems());
	}

	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return stockService.deleteById(id);
	}

	@GetMapping("/ref/{ref}")
	public Stock findByRef(@PathVariable String ref) {
		return stockService.findByRef(ref);
	}

	@GetMapping("/")
	public List<Stock> findAll() {
		return stockService.findAll();
	}

}
