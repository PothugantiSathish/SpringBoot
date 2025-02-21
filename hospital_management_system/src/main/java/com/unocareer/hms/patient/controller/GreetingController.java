package com.unocareer.hms.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unocareer.hms.patient.model.Greeting;

@Controller
public class GreetingController {
	 @GetMapping("/greeting")
	  public String greetingForm(Model model) {
	    model.addAttribute("greeting", new Greeting());
	    return "views/greeting";
	  }

	  @PostMapping("/result")
	  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		greeting.setCode("sdfff");
	    model.addAttribute("greeting", greeting);
	    return "views/result";
	  }

}
