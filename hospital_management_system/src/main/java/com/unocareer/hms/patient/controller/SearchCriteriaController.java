package com.unocareer.hms.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unocareer.hms.patient.model.PatientModel;
import com.unocareer.hms.patient.model.PatientService;
import com.unocareer.hms.patient.model.SearchCriteria;
import com.unocareer.hms.patient.model.SearchRepository;

@Controller
public class SearchCriteriaController {
	 @Autowired
	    private SearchRepository searchRepository;
	 @Autowired
	    private PatientService patientService;
	
	@GetMapping("/search1")
	public String searchCriteria(Model model) {
		model.addAttribute("pageTitle","search1");
		return "views/responsive/thymeleaf/patient/searchcriteria";
	}
	
	
	@PostMapping("/search1/result")
	public String searchCriteriaResult(@ModelAttribute SearchCriteria searchcriteria,Model model) {
		model.addAttribute("pageTitle","Search Result");
		if (searchcriteria.getPatientContactNumber().isEmpty()) {
			return "views/responsive/thymeleaf/patient/searchcriteria";
		}
		 String contactNumber = searchcriteria.getPatientContactNumber();
		    List<PatientModel> patients = patientService.findPatientsByContactNumberJoining(contactNumber);

		    if (patients.isEmpty()) {
		        // Handle no matching patients found
		        model.addAttribute("noResultsMessage", "No patients found matching the entered contact number.");
		    } else {
		        // Pass the list of matching patients to the view
		        model.addAttribute("patients", patients);
		    }
		searchRepository.save(searchcriteria);
		System.out.println(searchcriteria.getPatientContactNumber());
		model.addAttribute("searchcriteria",searchcriteria);
		return "views/responsive/thymeleaf/patient/searchcriteria";
	}


}
