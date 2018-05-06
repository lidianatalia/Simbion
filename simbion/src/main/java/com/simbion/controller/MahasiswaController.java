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
    
    @RequestMapping("/login")
    public String login ()
    {
        return "form-login";
    }
    
    @RequestMapping("/register")
    public String register()
    {
        return "form-register";
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

    @RequestMapping("/donatur/form-skema-tambah")
    public String daftar_paket ()
    {
    	return "daftarskemabeasiswa";
    }
    
    @RequestMapping("/donatur/form-beasiswa-tambah")
    public String daftar_beasiswa()
    {
    	return "beasiswa_aktif";
    }
    
    @RequestMapping("/view-skema-detail")
    public String detail ()
    {
    	return "detail_beasiswa";
    }
    
    @RequestMapping("/donatur/form-pembayaran-tambah")
    public String info_bayar()
    {
    	return "info_pembayaran";
    }
    
    @RequestMapping("/mhs/form-daftar-beasiswa")
    public String daftarBeasiswa ()
    {
        return "daftar_beasiswa";
    }
    
    @RequestMapping("/donatur/view-beasiswa")
    public String lihatBeasiswa ()
    {
        return "lihat-beasiswa-donatur";
    }
    
    @RequestMapping("/donatur/view-detail-beasiswa")
    public String lihatDetailBeasiswa ()
    {
        return "detail_beasiswa_donatur";
    }
    
    @RequestMapping("/admin/form-tempat-wawancara-tambah")
    public String tempatWawancara ()
    {
        return "tempat-wawancara";
    }
}
