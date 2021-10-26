package com.practica.springboot.app.controllers;

import java.security.Principal;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {
       
	
	
	@GetMapping("/login")
	public String login(@RequestParam(name = "error",required = false) String error,
			@RequestParam(name = "logout",required = false) String logout,
			Principal principal, RedirectAttributes flash, Model model) {
		
		if(principal != null) {
			flash.addFlashAttribute("success", "Ya se encuentra loggiado.");
			return "redirect:/listar";
		}
		
		if(error != null) {
			model.addAttribute("error", "ERROR : error al loggiaser, verifique el usuario o la contraseña");
			return "login";
		}
		
		if(logout != null) {
			model.addAttribute("info", "Se ha salido de la cuenta exitosamente");
			return "login";
		}
		
		
		return "login";
	}
	
}
