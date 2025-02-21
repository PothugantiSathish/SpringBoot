package com.unocareer.hms.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unocareer.hms.patient.model.MyRepository;
import com.unocareer.hms.patient.model.PatientModel;

@Controller
public class PatientManagementController {
	@Autowired
	private MyRepository myrepository;
	
	@RequestMapping("/patient")
	public String manage(Model model) {
		model.addAttribute("pageTitle", "Patient Management");
		return "/views/responsive/thymeleaf/patient/patientManagement";
		
	}
	@RequestMapping("/details")
	public String test() {
		return "/views/responsive/thymeleaf/patient/patientDetails";
		
	}
	@GetMapping("/information")
	public String info(Model model) {
		model.addAttribute("patient", new PatientModel());
		return "views/responsive/thymeleaf/patient/patientInformation";
		
	}
	@PostMapping("/newpatient")
	public String newpatient(@ModelAttribute("patient") PatientModel patientModel,Model model) {
		
        model.addAttribute("patient", patientModel);
        myrepository.save(patientModel);
		return "views/responsive/thymeleaf/patient/newpatient";		
	}
	
	@GetMapping("/getdata")
	public String findAll(Model model) {
		List<PatientModel> details=myrepository.findAll();
		model.addAttribute("details", details);
		return "views/responsive/thymeleaf/patient/result";
		
	}

	
	
	
	

}
