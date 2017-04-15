package com.aarestu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aarestu.form.HelloForm;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "helloNew";
	}

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(ModelMap model) {
		model.addAttribute("hi", "Hi Deepak welocome to ur 1st project");
		return "hiDpk";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("demo", "command", new HelloForm());
	}

//	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
//	public String addStudent(@ModelAttribute("SpringWeb") HelloForm student, ModelMap model) {
//		model.addAttribute("name", student.getName());
//		model.addAttribute("age", student.getAge());
//		model.addAttribute("id", student.getId());
//
//		return "result";
//	}
	
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public ModelAndView template() {
		return new ModelAndView("tempBs", "command", new HelloForm());
	}
}
