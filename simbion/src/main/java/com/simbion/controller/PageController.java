//package com.simbion.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.simbion.service.SimbionService;
//
//
//@Controller
//public class PageController {
//	@Autowired
//	SimbionService simbionService;
//	
//	@RequestMapping("/login")
//	public String login() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//	    if (!(auth instanceof AnonymousAuthenticationToken))
//	    {
//	        return "redirect:/home";
//	    }
//		return "form-login";
//	}
//	
//	@RequestMapping("/")
//	public String index() {
//		return "redirect:/home";
//	}
//	
//	@RequestMapping("/home")
//	public String home() {
//		return "/mhs/index";
//	}
//	
//}
