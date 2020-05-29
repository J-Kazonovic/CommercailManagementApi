package com.stockmanager.fst.model.ws;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinService;


@RestController
@RequestMapping("/ebs")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class ExpressionBesoinRest {
	
	@Autowired
	private ExpressionBesoinService ebs;

    @PostMapping("/")
	public int saveEb(@RequestBody ExpressionBesoin expb) {
		return ebs.saveEb(expb);
	}
    
    @PutMapping("/")
    public int updateEb(@RequestBody ExpressionBesoin expb) {
		return ebs.updateEb(expb);
	}

	@DeleteMapping("/eb/{id}")
	public int deleteById(@PathVariable Long id) {
		return ebs.deleteById(id);
	}
	
	@GetMapping("")
	public Page<ExpressionBesoin> getAllExpB(@RequestParam(defaultValue = "0") int page) {
		return ebs.getAllExpB(page);
	}

    
    /*
    @GetMapping("/")
	public List<ExpressionBesoin> getAllExpB() {
		return ebs.getAllExpB();
	}*/

    @GetMapping("/entite/{libelle}")
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(@PathVariable String libelle) {
		return ebs.getByEntiteAdministrativeLibelle(libelle);
	}
    
    @GetMapping("/personnel/{cin}")
    public List<ExpressionBesoin> getByPersonnelCin(@PathVariable String cin) {
		return ebs.getByPersonnelCin(cin);
	}

    @GetMapping("/date/{saveDate}")
	public List<ExpressionBesoin> getBySaveDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date saveDate) throws ParseException {
		return ebs.getBySaveDate(saveDate);
	}

    
	
    
	

}
