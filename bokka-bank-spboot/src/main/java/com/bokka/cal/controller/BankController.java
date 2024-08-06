package com.bokka.cal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bokka.cal.model.BankUser;
import com.bokka.cal.repository.BankRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;
	
	@PostMapping("/user")
	public BankUser saveUser(@RequestBody BankUser user) {
		return bankRepository.save(user);
	}
	
	
	@GetMapping("/user")
	public Iterable<BankUser> getUser() { //iterable is root interface of collection
		return bankRepository.findAll();
	}
	
	
	@GetMapping("/user/{id}")
	public BankUser getUser(@PathVariable int id) { 
		Optional<BankUser> opt=bankRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	
	
	@PutMapping("/user")
	public BankUser updateUser(@RequestBody BankUser user) {
		
		
		BankUser existing = bankRepository.findById(user.getId()).orElseThrow();
		if(existing!=null) {
			existing.setName(user.getName());
			existing.setEmail(user.getEmail());
			existing.setPassword(user.getPassword());
			 
			return bankRepository.save(existing);
		}
		
		return null;
	}
	
	
	
	

}
