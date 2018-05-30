package com.simbion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.service.SimbionService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class PageController {
	@Autowired
	SimbionService simbionDAO;
	
	@RequestMapping("/login")
	public String login() {
		return "form-login";
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectAllListBeasiswa();
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "index";
	}
}
