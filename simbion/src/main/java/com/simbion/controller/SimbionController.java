package com.simbion.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;
import com.simbion.model.PendaftaranModel;
import com.simbion.model.PenggunaModel;
import com.simbion.model.PengumumanModel;
import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.model.YayasanModel;
import com.simbion.model.SkemaBeasiswaModel;
import com.simbion.model.SyaratBeasiswaModel;
import com.simbion.service.SimbionService;

@Controller
public class SimbionController {
	
	@Autowired
	SimbionService simbionDAO;
	
    //feature all user
	@RequestMapping("/")
    public String index (Model model)
    {
		List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectAllListBeasiswa();
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "index";
    }	
    
    @RequestMapping("/register")
    public String register(@ModelAttribute("mahasiswa") MahasiswaModel mahasiswa, Model model)
    {
        return "form-register";
    }
    
    @RequestMapping(value="/register/submit", method=RequestMethod.POST)
    public String register_submit(
    		@ModelAttribute("mahasiswa") MahasiswaModel mahasiswa, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	simbionDAO.insertPengguna(pengguna);
    	simbionDAO.insertMahasiswa(mahasiswa);
    	model.addAttribute("mahasiswa",mahasiswa);
        return "success-add";
    }
    
    @RequestMapping("/register-individual")
    public String register_i()
    {
        return "form-register-individual";
    }
    
    @RequestMapping(value="/register/individual/submit", method=RequestMethod.POST)
    public String register_submit_i(
    		@ModelAttribute("individual_donor") IndividualDonorModel individualDonor, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	simbionDAO.insertPengguna(pengguna);
    	donatur.setNomor_identitas(individualDonor.getNomor_identitas_donatur());
    	simbionDAO.insertDonatur(donatur);
    	simbionDAO.insertIndividualDonor(individualDonor);
    	model.addAttribute("individualDonor",individualDonor);
        return "success-add";
    }
    
    @RequestMapping("/register-yayasan")
    public String register_y()
    {
        return "form-register-yayasan";
    }
    
    @RequestMapping(value="/register/yayasan/submit", method=RequestMethod.POST)
    public String register_submit_y(
    		@ModelAttribute("yayasan") YayasanModel yayasan, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	simbionDAO.insertPengguna(pengguna);
    	donatur.setNo_telp(yayasan.getNo_telp_cp());
    	simbionDAO.insertDonatur(donatur);
    	yayasan.setNomor_identitas_donatur(donatur.getNomor_identitas());
    	simbionDAO.insertYayasan(yayasan);
    	model.addAttribute("yayasan",yayasan);
        return "success-add";
    }
    
    @RequestMapping("/viewall-pengumuman")
    public String viewall_pengumuman(Model model)
    {
    	List<PengumumanModel>pengumuman = simbionDAO.selectAllPengumuman();
    	model.addAttribute("pengumuman",pengumuman);
    	return "viewall-pengumuman";
    }
    
    @RequestMapping("/view-pengumuman/{judul}")
    public String view_pengumuman(Model model, @PathVariable(value="judul")String judul)
    {
    	PengumumanModel detailPengumuman = simbionDAO.viewPengumuman(judul);
    	model.addAttribute("detailPengumuman",detailPengumuman);
    	return "view-pengumuman";
    }
    
    @RequestMapping("/view-detail-skema/{no_urut}")
    public String detail(Model model,  @PathVariable(value= "no_urut")int no_urut)
    {
    	SkemaBeasiswaModel detailBeasiswa = simbionDAO.selectSkemaBeasiswa(no_urut);
    	List<SyaratBeasiswaModel>syaratBeasiswa=simbionDAO.selectSyaratBeasiswaByKode(detailBeasiswa.getKode());
    	model.addAttribute("detailBeasiswa", detailBeasiswa);
    	model.addAttribute("syaratBeasiswa",syaratBeasiswa);
    	return "view-detail-skema";
    }
    
    //feature mhs
    @RequestMapping("/mhs")
    public String index_mhs (Model model)
    {
    	List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectAllListBeasiswa();
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "/mhs/index";
    }
    
    @RequestMapping("/mhs/viewall-pengumuman")
    public String viewall_pengumuman_mhs(Model model)
    {
    	List<PengumumanModel>pengumuman = simbionDAO.selectAllPengumuman();
    	model.addAttribute("pengumuman",pengumuman);
        return "/mhs/viewall-pengumuman";
    }
    
    @RequestMapping("/mhs/view-pengumuman/{judul}")
    public String view_pengumuman_mhs(Model model, @PathVariable(value="judul")String judul)
    {
    	PengumumanModel detailPengumuman = simbionDAO.viewPengumuman(judul);
    	model.addAttribute("detailPengumuman",detailPengumuman);
    	return "/mhs/view-pengumuman";
    }
    
    @RequestMapping("/mhs/form-daftar-beasiswa")
    public String addBeasiswa ()
    {
        return "/mhs/form-daftar-beasiswa";
    }
    
    @RequestMapping("/mhs/view-detail-skema/{no_urut}")
    public String detail_mhs(Model model,  @PathVariable(value= "no_urut")int no_urut)
    {
    	SkemaBeasiswaModel detailBeasiswa = simbionDAO.selectSkemaBeasiswa(no_urut);
    	List<SyaratBeasiswaModel>syaratBeasiswa=simbionDAO.selectSyaratBeasiswaByKode(detailBeasiswa.getKode());
    	model.addAttribute("detailBeasiswa", detailBeasiswa);
    	model.addAttribute("syaratBeasiswa",syaratBeasiswa);
    	return "/mhs/view-detail-skema";
    }
    
    //feature donatur
    @RequestMapping("/donatur")
    public String index_donatur (Model model)
    {
    	List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectAllListBeasiswa();
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "/donatur/index";
    }
    
    @RequestMapping("/donatur/form-pengumuman-tambah")
    public String form_pengumuman_donatur()
    {
        return "/donatur/form-pengumuman-add";
    }
    
    @RequestMapping(value="/donatur/form-pengumuman-tambah/simpan", method=RequestMethod.POST)
    public String add_pengumuman(
    		@ModelAttribute("pengumuman") PengumumanModel pengumuman,
    		Model model)
    {
    	simbionDAO.insertPengumuman(pengumuman);
    	return "success-add-pengumuman";
    }
    
    @RequestMapping("/donatur/viewall-pengumuman")
    public String viewall_pengumuman_donatur(Model model)
    {
    	List<PengumumanModel>pengumuman = simbionDAO.selectAllPengumuman();
    	model.addAttribute("pengumuman",pengumuman);
        return "/donatur/viewall-pengumuman";
    }
    
    @RequestMapping("/donatur/view-pengumuman/{judul}")
    public String view_pengumuman_donatur(Model model, @PathVariable(value="judul")String judul)
    {
    	PengumumanModel detailPengumuman = simbionDAO.viewPengumuman(judul);
    	model.addAttribute("detailPengumuman",detailPengumuman);
    	return "/donatur/view-pengumuman";
    }
    
    @RequestMapping("/donatur/form-skema-tambah")
    public String daftar_paket (
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa, 
    		@ModelAttribute("syaratBeasiswa") SyaratBeasiswaModel syaratBeasiswa,
    		Model model)
    {
    	return "/donatur/form-skema-beasiswa-add";
    }
    
    @RequestMapping(value="/donatur/form-skema-tambah/simpan", method=RequestMethod.POST)
    public String tambah_skema(
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa,
    		@ModelAttribute("syarat") SyaratBeasiswaModel syarat,
    		Model model)
    {
    	simbionDAO.insertSkemaBeasiswa(skemaBeasiswa);
    	for (String datum: skemaBeasiswa.getSyarat().split("-")) {
    		syarat.setKode_beasiswa(skemaBeasiswa.getKode());
    		syarat.setSyarat(datum);
    		simbionDAO.insertSyaratBeasiswa(syarat);
    	}
    	model.addAttribute("skemaBeasiswa", skemaBeasiswa);
    	model.addAttribute("syarat", syarat);
    		return "success-add-skema";
    }

    @RequestMapping(value="/donatur/skema/submit", method=RequestMethod.POST)
    public String register_skema(
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa, 
    		@ModelAttribute("syaratBeasiswa") SyaratBeasiswaModel syaratBeasiswa,  Model model)
    {
    	String nomor_identitas="127150014474";
    	skemaBeasiswa.setNomor_identitas_donatur(nomor_identitas);
    	simbionDAO.insertSkemaBeasiswa(skemaBeasiswa);
    	for (String datum: skemaBeasiswa.getSyarat().split("-")) {
    		syaratBeasiswa.setKode_beasiswa(skemaBeasiswa.getKode());
    		syaratBeasiswa.setSyarat(datum);
    		simbionDAO.insertSyaratBeasiswa(syaratBeasiswa);
    	}
    	model.addAttribute("skemaBeasiswa",skemaBeasiswa);
    	model.addAttribute("syaratBeasiswa",syaratBeasiswa);
        return "/donatur/success-add";
    }
    
    @RequestMapping("/donatur/form-beasiswa-tambah")
    public String add_beasiswa()
    {
    	return "/donatur/form-beasiswa-aktif-add";
    }
    
    @RequestMapping(value="/donatur/form-beasiswa-aktif-add/simpan", method=RequestMethod.POST)
    public String add_beasiswa_aktif(
    		@ModelAttribute("beasiswaAktif") SkemaBeasiswaAktifModel beasiswaAktif,
    	    BindingResult userloginResult,
    		Model model)
    {
    	simbionDAO.insertSkemaBeasiswaAktif(beasiswaAktif);
    	model.addAttribute("beasiswaAktif",beasiswaAktif);
        return "success-add";
    }
    
    @RequestMapping("/donatur/form-pembayaran-tambah")
    public String info_bayar()
    {
    	return "/donatur/form-pembayaran-tambah";
    }
       
    @RequestMapping("/donatur/view-beasiswa")
    public String viewBeasiswa (Model model)
    {
    	List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectListBeasiswaByDonatur("127150014474");
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "/donatur/view-beasiswa";
    }
    
    @RequestMapping("/donatur/view-detail-beasiswa/{kode_skema_beasiswa}/{no_urut}")
    public String lihatDetailBeasiswa (Model model,
    		@PathVariable(value="kode_skema_beasiswa")int kode_skema_beasiswa,
    		@PathVariable(value="no_urut")int no_urut)
    {
    	List<PendaftaranModel>pendaftaran = simbionDAO.selectPendaftaranByDonatur(kode_skema_beasiswa,no_urut);
    	model.addAttribute("pendaftaran",pendaftaran);
        return "/donatur/view-detail-beasiswa";
    }
    
    @RequestMapping("/donatur/view-detail-skema/{no_urut}")
    public String detail_donatur(Model model,  @PathVariable(value= "no_urut")int no_urut)
    {
    	SkemaBeasiswaModel detailBeasiswa = simbionDAO.selectSkemaBeasiswa(no_urut);
    	List<SyaratBeasiswaModel>syaratBeasiswa=simbionDAO.selectSyaratBeasiswaByKode(detailBeasiswa.getKode());
    	model.addAttribute("detailBeasiswa", detailBeasiswa);
    	model.addAttribute("syaratBeasiswa",syaratBeasiswa);
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
    
    @RequestMapping(value="/admin/form-pengumuman-tambah/simpan", method=RequestMethod.POST)
    public String admin_add_pengumuman(
    		@ModelAttribute("pengumuman") PengumumanModel pengumuman,
    		Model model)
    {
    	simbionDAO.insertPengumuman(pengumuman);
    	return "success-add-pengumuman";
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
