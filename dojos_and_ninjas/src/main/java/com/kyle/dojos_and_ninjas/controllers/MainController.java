package com.kyle.dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kyle.dojos_and_ninjas.models.Dojo;
import com.kyle.dojos_and_ninjas.models.Ninja;
import com.kyle.dojos_and_ninjas.services.DojoService;
import com.kyle.dojos_and_ninjas.services.NinjaService;

@Controller
public class MainController {

	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
	@GetMapping("/dojos/{id}")
	public String ninjaInfo(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "ninjaShower.jsp";
	}
	

	
	// NEW DOJO
	@GetMapping("/dojos")
	public String newDojo(@ModelAttribute Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newDojo.jsp";
	}
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}

	// NEW NINJA
	@GetMapping("/ninjas")
	public String newNinja(@ModelAttribute Ninja ninja, Model model) {
		model.addAttribute("ninjas", ninjaService.allNinjas());
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ninjas", ninjaService.allNinjas());
			model.addAttribute("dojos", dojoService.allDojos());
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}

}
