package com.simbion.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.simbion.model.RiwayatAkademikModel;
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
    @RequestMapping("/register")
    public String register(
    		@ModelAttribute("mahasiswa") MahasiswaModel mahasiswa, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
        return "form-register";
    }
    
    @RequestMapping(value="/register/submit", method=RequestMethod.POST)
    public String register_submit(
    		@ModelAttribute("mahasiswa") MahasiswaModel mahasiswa, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	mahasiswa.setUsername(pengguna.getUsername());
    	if ((simbionDAO.selectMahasiswaByNPM(mahasiswa.getNpm())== null) && (simbionDAO.selectPengguna(pengguna.getUsername())== null)){
    			simbionDAO.insertPengguna(pengguna);
    	    	simbionDAO.insertMahasiswa(mahasiswa);
    	    	model.addAttribute("mahasiswa",mahasiswa);
    	        return "success-register";
    	}else return "cancel-register";
    }
    
    @RequestMapping("/register-individual")
    public String register_i(@ModelAttribute("individual_donor") IndividualDonorModel individualDonor, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
        return "form-register-individual";
    }
    
    @RequestMapping(value="/register/submit/individual", method=RequestMethod.POST)
    public String register_submit_i(
    		@ModelAttribute("individual_donor") IndividualDonorModel individualDonor, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	if ((simbionDAO.selectDonatur(donatur.getNomor_identitas())== null) && (simbionDAO.selectPengguna(pengguna.getUsername())== null)){
	    	simbionDAO.insertPengguna(pengguna);
	    	donatur.setNomor_identitas(individualDonor.getNomor_identitas_donatur());
	    	simbionDAO.insertDonatur(donatur);
	    	simbionDAO.insertIndividualDonor(individualDonor);
	    	model.addAttribute("individualDonor",individualDonor);
	        return "success-register";
    	}else return "cancel-register";
    }
    
    @RequestMapping("/register-yayasan")
    public String register_y(@ModelAttribute("yayasan") YayasanModel yayasan, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
        return "form-register-yayasan";
    }
    
    @RequestMapping(value="/register/submit/yayasan", method=RequestMethod.POST)
    public String register_submit_y(
    		@ModelAttribute("yayasan") YayasanModel yayasan, 
    		@ModelAttribute("donatur") DonaturModel donatur, 
    		@ModelAttribute("pengguna") PenggunaModel pengguna, 
    		Model model)
    {
    	if ((simbionDAO.selectDonatur(donatur.getNomor_identitas())== null) && (simbionDAO.selectPengguna(pengguna.getUsername())== null)){
	    	simbionDAO.insertPengguna(pengguna);
	    	donatur.setNo_telp(yayasan.getNo_telp_cp());
	    	simbionDAO.insertDonatur(donatur);
	    	yayasan.setNomor_identitas_donatur(donatur.getNomor_identitas());
	    	simbionDAO.insertYayasan(yayasan);
	    	model.addAttribute("yayasan",yayasan);
	        return "success-register";
    	}else return "cancel-register";
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
    
    @RequestMapping("/view-detail-skema/{kode_skema_beasiswa}/{no_urut}")
    public String detail(Model model,  @PathVariable(value= "kode_skema_beasiswa")int kode_skema_beasiswa, @PathVariable(value= "no_urut")int no_urut)
    {
    	SkemaBeasiswaAktifModel detailBeasiswa = simbionDAO.selectSkemaBeasiswaAktif(kode_skema_beasiswa,no_urut);
    	List<SyaratBeasiswaModel>syaratBeasiswa=simbionDAO.selectSyaratBeasiswaByKode(detailBeasiswa.getKode_skema_beasiswa());
    	DonaturModel donatur = simbionDAO.selectDonatur(detailBeasiswa.getNomor_identitas_donatur().replace(" ", ""));
    	model.addAttribute("detailBeasiswa", detailBeasiswa);
    	model.addAttribute("syaratBeasiswa",syaratBeasiswa);
    	model.addAttribute("donatur",donatur);
    	return "view-detail-skema";
    }
    
    @RequestMapping("/form-daftar-beasiswa")
    public String regBeasiswa (@ModelAttribute("pendaftaran") PendaftaranModel pendaftaran,Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		List<SkemaBeasiswaAktifModel> sba = simbionDAO.selectAllListBeasiswaByStatus();
		MahasiswaModel mahasiswa =simbionDAO.selectMahasiswa(username);
		pendaftaran.setNpm(mahasiswa.getNpm());
		int isKode=0;
		model.addAttribute("sba",sba);
		model.addAttribute("isKode", isKode);
		model.addAttribute("mahasiswa",mahasiswa);
        return "form-daftar-beasiswa";
    }
    
    @RequestMapping("/form-daftar-beasiswa/{kode_skema_beasiswa}/{no_urut}")
    public String addBeasiswa (@ModelAttribute("pendaftaran") PendaftaranModel pendaftaran, Model model, 
    		@PathVariable(value="kode_skema_beasiswa")int kode_skema_beasiswa,
    		@PathVariable(value="no_urut")int no_urut)
    {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		int isKode=1;
		SkemaBeasiswaAktifModel sba = simbionDAO.selectSkemaBeasiswaAktif(kode_skema_beasiswa, no_urut);
		MahasiswaModel mahasiswa =simbionDAO.selectMahasiswa(username);
		pendaftaran.setNpm(mahasiswa.getNpm());
		model.addAttribute("sba",sba);
		model.addAttribute("isKode", isKode);
		model.addAttribute("kode_skema_beasiswa", kode_skema_beasiswa);
		model.addAttribute("mahasiswa",mahasiswa);
        return "form-daftar-beasiswa";
    }
    
    @RequestMapping(value="/form-daftar-beasiswa/submit", method=RequestMethod.POST)
    public String daftar_beasiswa(@ModelAttribute("pendaftaran") PendaftaranModel pendaftaran,Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		MahasiswaModel mahasiswa =simbionDAO.selectMahasiswa(username);
		pendaftaran.setNpm(mahasiswa.getNpm());
		String[] kode = pendaftaran.getJenis_beasiswa().split("-");
		int kode_skema_beasiswa = Integer.parseInt(kode[0]);
		int no_urut = Integer.parseInt(kode[1]);
		pendaftaran.setKode_skema_beasiswa(kode_skema_beasiswa);
		pendaftaran.setNo_urut(no_urut);
    	pendaftaran.setWaktu_daftar(new Date());
    	pendaftaran.setStatus_daftar("aktif");
    	PendaftaranModel checkData = simbionDAO.selectPendaftaranByNPM(no_urut, kode_skema_beasiswa, pendaftaran.getNpm());
    	if (checkData != null) {
    		return "cancel-daftar";
    	}
    	else {
	    	simbionDAO.insertPendaftaran(pendaftaran);
	    	model.addAttribute("pendaftaran", pendaftaran);
	    	return "success-add-daftar";
    	}
    }
    
    //feature donatur
    @RequestMapping("/form-pengumuman-tambah/{kode_skema_beasiswa}/{no_urut}")
    public String form_pengumuman(@ModelAttribute("pengumuman")PengumumanModel pengumuman, 
    		@PathVariable(value="kode_skema_beasiswa")int kode_skema_beasiswa,
    		@PathVariable(value="no_urut")int no_urut,
    		Model model)
    {
    	
    	pengumuman.setKode_skema_beasiswa(kode_skema_beasiswa);
    	pengumuman.setNo_urut_skema_beasiswa_aktif(no_urut);
        return "form-pengumuman-add";
    }
    
    @RequestMapping(value="/form-pengumuman-tambah/simpan", method=RequestMethod.POST)
    public String add_pengumuman(
    		@ModelAttribute("pengumuman") PengumumanModel pengumuman,
    		Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		pengumuman.setUsername(username);
		pengumuman.setTanggal(new Date());
		if (simbionDAO.selectPengumuman(pengumuman.getKode_skema_beasiswa(), pengumuman.getNo_urut_skema_beasiswa_aktif(), username)== null) {
			simbionDAO.insertPengumuman(pengumuman);
			return "success-add-pengumuman";
		}
		else return "cancel-pengumuman";
    }
    
    @RequestMapping("/form-skema-tambah")
    public String add_beasiswa(
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa, 
    		@ModelAttribute("syaratBeasiswa") SyaratBeasiswaModel syaratBeasiswa,
    		Model model)
    {
    	return "form-skema-beasiswa-add";
    }
    
    @RequestMapping(value="/form-skema-tambah/simpan", method=RequestMethod.POST)
    public String add_beasiswa_submit(
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa,
    		@ModelAttribute("syarat") SyaratBeasiswaModel syarat,
    		Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String nomor_identitas_donatur = simbionDAO.selectDonatur(username).getNomor_identitas();
    	if (simbionDAO.selectSkemaBeasiswa(skemaBeasiswa.getKode())== null) {
    		skemaBeasiswa.setNomor_identitas_donatur(nomor_identitas_donatur);
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
    	else return"cancel-daftar";
    }
    
    @RequestMapping("/form-beasiswa-tambah")
    public String add_beasiswa_aktif(
    		@ModelAttribute("skemaBeasiswaAktif") SkemaBeasiswaAktifModel skemaBeasiswaAktif,
    		Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String nomor_identitas_donatur = simbionDAO.selectDonatur(username).getNomor_identitas();
		List<SkemaBeasiswaModel> beasiswa= simbionDAO.selectSkemaBeasiswa(nomor_identitas_donatur);
    	model.addAttribute("beasiswa",beasiswa);
    	return "form-beasiswa-aktif-add";
    }
    
    @RequestMapping(value="/form-beasiswa-tambah/simpan", method=RequestMethod.POST)
    public String add_beasiswa_aktif_submit(
    		@ModelAttribute("skemaBeasiswaAktif") SkemaBeasiswaAktifModel skemaBeasiswaAktif, 
    		@ModelAttribute("skemaBeasiswa") SkemaBeasiswaModel skemaBeasiswa,
    		Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
    	if (simbionDAO.selectSkemaBeasiswaAktif(skemaBeasiswaAktif.getKode_skema_beasiswa(),skemaBeasiswaAktif.getNo_urut())== null) {
    		skemaBeasiswaAktif.setNomor_identitas_donatur(simbionDAO.selectDonatur(username).getNomor_identitas());
    		skemaBeasiswaAktif.setStatus("dibuka");    		
    		
    		//Initialize your Date however you like it.
    		Calendar calendar = new GregorianCalendar();
    		calendar.setTime(skemaBeasiswaAktif.getTgl_tutup_pendaftaran());
    		Integer year = calendar.get(Calendar.YEAR);
    		skemaBeasiswaAktif.setPeriode_penerimaan(year.toString());
    		simbionDAO.insertSkemaBeasiswaAktif(skemaBeasiswaAktif);
	    	model.addAttribute("skemaBeasiswa", skemaBeasiswa);
	        return "success-add-skema";
    	}
    	else return"cancel-daftar";
    }
    
    @RequestMapping("/form-pembayaran-tambah")
    public String info_bayar()
    {
    	return "form-pembayaran-tambah";
    }
    
    @RequestMapping("/view-beasiswa")
    public String viewBeasiswa (Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String nomor_identitas_donatur = simbionDAO.selectDonatur(username).getNomor_identitas();
    	List<SkemaBeasiswaAktifModel> beasiswaAktif = simbionDAO.selectListBeasiswaByDonatur(nomor_identitas_donatur);
		model.addAttribute("beasiswaAktif", beasiswaAktif);
		return "view-beasiswa";
    }
    
    @RequestMapping("/view-detail-beasiswa/{kode_skema_beasiswa}/{no_urut}")
    public String lihatDetailBeasiswa (Model model,
    		@PathVariable(value="kode_skema_beasiswa")int kode_skema_beasiswa,
    		@PathVariable(value="no_urut")int no_urut)
    {
    	List<PendaftaranModel>pendaftaran = simbionDAO.selectPendaftaranByDonatur(kode_skema_beasiswa,no_urut);
    	model.addAttribute("pendaftaran",pendaftaran);
        return "/view-detail-beasiswa";
    }
    
    //feature admin
    @RequestMapping("/tempat-wawancara/add")
    public String tempatWawancara (@ModelAttribute("tempatWawancara") TempatWawancaraModel tempatWawancara, Model model)
    {
    	return "form-tempat-wawancara-add";
    }
    
    @RequestMapping(value="/tempat-wawancara/submit", method=RequestMethod.POST)
    public String register_tempat(
    		@ModelAttribute("tempatWawancara") TempatWawancaraModel tempatWawancara, Model model)
    {
    	if(simbionDAO.selectTempatWawancara(tempatWawancara.getKode())!= null){
    		return "cancel-tempat";
    	}
    	else {
	    	simbionDAO.insertTempatWawancara(tempatWawancara);
	    	model.addAttribute("tempatWawancara",tempatWawancara);
	        return "success-add-tempat";
    	}
    }
    
    @RequestMapping("/viewall-tempat-wawancara")
    public String viewall_tempat_wawancara(Model model)
    {
    	List<TempatWawancaraModel>tempat_wawancara=simbionDAO.selectAllTempatWawancara();
    	model.addAttribute("tempat_wawancara",tempat_wawancara);
        
        return "viewall-tempat-wawancara";
    }
}
