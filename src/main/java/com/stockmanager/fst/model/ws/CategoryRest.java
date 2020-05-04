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

import com.stockmanager.fst.bean.Category;
import com.stockmanager.fst.model.service.facade.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class CategoryRest {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/libelle/{libelle}")
	public Category findByLibelle(@PathVariable String libelle) {
		return categoryService.findByLibelle(libelle);
	}

	@GetMapping("/")
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return categoryService.deleteByLibelle(libelle);
	}

}
