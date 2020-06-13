package com.stockmanager.fst.security.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.security.entity.MyRole;
import com.stockmanager.fst.security.service.RoleService;
import com.stockmanager.fst.security.service.UserService;

@RestController
@RequestMapping("/roles")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class RoleRest {
	
	@Autowired
	private RoleService rService;

	@GetMapping("/")
	public List<MyRole> findAll() {
		return rService.findAll();
	}
	
	

}
