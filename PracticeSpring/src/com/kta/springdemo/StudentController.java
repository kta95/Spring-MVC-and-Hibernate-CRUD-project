package com.kta.springdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder
	public void InitBinder(WebDataBinder databinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, ste);
		
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("student", new Student());
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult result) {
		
		System.out.println("BindingResult is "+result);
		if(result.hasErrors()) {
			
			return "student-form";			
		
		}else {
			
			return "student-confirmation";			
		
		}
		
	}
}
