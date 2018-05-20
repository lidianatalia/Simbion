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

import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.service.SimbionService;

@Controller
public class SimbionController {
	
	@Autowired
	SimbionService simbionDAO;
	
    //feature all user
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
    
    @RequestMapping("/view-detail-skema")
    public String detail()
    {
    	return "view-detail-skema";
    }
    
    //feature mhs
    @RequestMapping("/mhs")
    public String index_mhs ()
    {
		return "/mhs/index";
    }
    
    @RequestMapping("/mhs/viewall-pengumuman")
    public String viewall_pengumuman_mhs()
    {
        return "/mhs/viewall-pengumuman";
    }
    
    @RequestMapping("/mhs/view-pengumuman")
    public String view_pengumuman_mhs()
    {
        return "/mhs/view-pengumuman";
    }
    
    @RequestMapping("/mhs/form-daftar-beasiswa")
    public String addBeasiswa ()
    {
        return "mhs/form-daftar-beasiswa";
    }
    
    @RequestMapping("/mhs/view-detail-skema")
    public String detail_mhs()
    {
    	return "/mhs/view-detail-skema";
    }
    
    //feature donatur
    @RequestMapping("/donatur")
    public String index_donatur ()
    {
		return "/donatur/index";
    }
    
    @RequestMapping("/donatur/form-pengumuman-tambah")
    public String form_pengumuman_donatur()
    {
        return "/donatur/form-pengumuman-add";
    }
    
    @RequestMapping("/donatur/viewall-pengumuman")
    public String viewall_pengumuman_donatur()
    {
        return "/donatur/viewall-pengumuman";
    }
    
    @RequestMapping("/donatur/view-pengumuman")
    public String view_pengumuman_donatur()
    {
        return "/donatur/view-pengumuman";
    }
    
    @RequestMapping("/donatur/form-skema-tambah")
    public String daftar_paket ()
    {
    	return "/donatur/form-skema-beasiswa-add";
    }
    
    @RequestMapping("/donatur/form-beasiswa-tambah")
    public String add_beasiswa()
    {
    	return "/donatur/form-beasiswa-aktif-add";
    }
    
    @RequestMapping("/donatur/form-pembayaran-tambah")
    public String info_bayar()
    {
    	return "/donatur/form-pembayaran-tambah";
    }
       
    @RequestMapping("/donatur/view-beasiswa")
    public String viewBeasiswa ()
    {
        return "/donatur/view-beasiswa";
    }
    
    @RequestMapping("/donatur/view-detail-beasiswa")
    public String lihatDetailBeasiswa ()
    {
        return "/donatur/view-detail-beasiswa";
    }
    
    @RequestMapping("/donatur/view-detail-skema")
    public String detail_donatur()
    {
    	return "/donatur/view-detail-skema";
    }
    
    //feature admin
    @RequestMapping("/admin")
    public String index_admin ()
    {
		return "/admin/index";
    }
    @RequestMapping("/admin/form-tempat-wawancara-tambah")
    public String tempatWawancara ()
    {
    	return "/admin/form-tempat-wawancara-add";
    }
    
    @RequestMapping("/admin/form-pengumuman-tambah")
    public String form_pengumuman()
    {
        return "/admin/form-pengumuman-add";
    }
    @RequestMapping("/admin/view-detail-skema")
    public String detail_admin()
    {
    	return "/admin/view-detail-skema";
    }
    
    @RequestMapping("/admin/viewall-pengumuman")
    public String viewall_pengumuman_admin()
    {
        return "/admin/viewall-pengumuman";
    }
    
    @RequestMapping("/admin/viewall-tempat-wawancara")
    public String viewall_tempat_wawancara(Model model)
    {
    	List<TempatWawancaraModel>tempat_wawancara=simbionDAO.selectAllTempatWawancara();
    	model.addAttribute("tempat_wawancara",tempat_wawancara);
        
        return "/admin/viewall-tempat-wawancara";
    }
}
