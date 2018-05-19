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
    
    @RequestMapping("/viewall")
    public String viewall ()
    {
        return "viewall";
    }
    
    @RequestMapping("/beasiswa/daftar")
    public String daftarBeasiswa ()
    {
        return "daftarbeasiswa";
    }
    
    @RequestMapping("/beasiswa/donatur/lihat")
    public String lihatBeasiswa ()
    {
        return "lihat-beasiswa-donatur";
    }
    
    @RequestMapping("/beasiswa/donatur/detail/lihat")
    public String lihatDetailBeasiswa ()
    {
        return "detail-beasiswa-donatur";
    }
    
    @RequestMapping("/beasiswa/tempatwawancara")
    public String tempatWawancara ()
    {
        return "tempat-wawancara";
    }
}
