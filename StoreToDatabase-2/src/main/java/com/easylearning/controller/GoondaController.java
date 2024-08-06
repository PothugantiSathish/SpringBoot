package com.easylearning.controller;

import org.springframework.web.bind.annotation.RestController;

import com.easylearning.model.Worker;
import com.easylearning.repository.WorkRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class GoondaController {
	
	@Autowired
	private WorkRepository workrepository;
	
	@PostMapping("/saveWorker")
	public Worker saveWorker(@RequestBody Worker worker) {
		
		
		return workrepository.save(worker);
	}
	
	@GetMapping("/worker")	
	public List<Worker> getWorker(){
		return workrepository.findAll();
		
	}
	
	@GetMapping("/worker/{id}")   //url-end point same id in the method parameters
	public Worker getWorker(@PathVariable int id) {   //we are picking the variable with @pathvariable-retrive the one variable
		Optional<Worker> opt=workrepository.findById(new Integer(id)); //wrapper class to pass the value .//optional container-java.util
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	

}
