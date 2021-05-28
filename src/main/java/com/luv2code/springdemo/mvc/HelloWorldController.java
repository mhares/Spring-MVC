package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request , Model model ) {
		
		// read the request paramter from the html Form
		String theName = request.getParameter("studentName");
		
		// covert the data to upper case
        theName = theName.toUpperCase();
		
        //create the message 
        String result = "YO! " + theName;
        
        //add message to the model
        model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName  , Model model ) {
		
		
		// covert the data to upper case
        theName = theName.toUpperCase();
		
        //create the message 
        String result = "Hey My Friend! " + theName;
        
        //add message to the model
        model.addAttribute("message", result);
		return "helloworld";
	}
}
