package com.simbion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MahasiswaController {
	
	@Autowired
    
	@RequestMapping("/")
    public String index ()
    {
		return "index";
    }
	
    @RequestMapping("/paket/tambah")
    public String add ()
    {
        return "form-tambah-paket-beasiswa";
    }
    
    @RequestMapping("/login")
    public String login ()
    {
        return "form-login";
    }
    
    @RequestMapping("/register")
    public String register()
    {
        return "form-register-mahasiswa";
    }
    
    @RequestMapping("/register-individual")
    public String register_i()
    {
        return "form-register-individual";
    }
    
    @RequestMapping("/register-yayasan")
    public String register_y()
    {
        return "form-register-yayasan";
    }
    
    @RequestMapping("/success")
    public String success()
    {
        return "tambah-sukses";
    }

    @RequestMapping("/viewall-pengumuman")
    public String viewall_pengumuman()
    {
        return "viewall-pengumuman";
    }
    
    @RequestMapping("/view-pengumuman")
    public String view_pengumuman()
    {
        return "view-pengumuman";
    }
}
