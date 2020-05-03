package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.bean.Personnel;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.model.service.facade.PersonnelService;

@RestController
@RequestMapping("/personnel")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class PersonnelRest {
	
	@Autowired
	private PersonnelService ps;

	@GetMapping("/all")
	public List<Personnel> findAll() {
		return ps.findAll();
	}
	
	

}
