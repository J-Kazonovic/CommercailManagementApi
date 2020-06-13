package com.stockmanager.fst.security.ws;

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

import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class UserRest {

	@Autowired
	private UserService uService;

	@PostMapping("/")
	public int save(@RequestBody MyUser user) {
		return uService.save(user);
	}

	@PutMapping("/")
	public int update(@RequestBody MyUser user) {
		return uService.update(user);
	}

	@DeleteMapping("/{id}")
	public int delete(@PathVariable Long id) {
		return uService.delete(id);
	}

	@GetMapping("/name/{nom}")
	public MyUser findByNom(@PathVariable String name) {
		return uService.findByNom(name);
	}

	@GetMapping("/")
	public List<MyUser> findAll() {
		return uService.findAll();
	}

}
