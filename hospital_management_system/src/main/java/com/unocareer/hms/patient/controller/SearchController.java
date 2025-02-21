package com.unocareer.hms.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unocareer.hms.patient.model.PatientModel;

@Controller
public class SearchController {
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("pageTitle", "search");
		return "views/responsive/thymeleaf/patient/search";	
	}
	
	@PostMapping("/search/result")	public String searchResult(@ModelAttribute PatientModel search,Model model) {
		model.addAttribute("pageTitle ", "Search result");
	if(search.getNewPatientName().equals("sathish")) {
		search.setLastName("kumar");
		search.setId(12);
	}
	    model.addAttribute("search", search);
		return "views/responsive/thymeleaf/patient/search";
	
	}
	

}
