package com.simbion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simbion.dao.SimbionMapper;
import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;

import com.simbion.model.PembayaranModel;

import com.simbion.model.PembayaranModel;

import com.simbion.model.PendaftaranModel;
import com.simbion.model.PenggunaModel;
import com.simbion.model.PengumumanModel;
import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.model.YayasanModel;
import com.simbion.model.SkemaBeasiswaModel;
import com.simbion.model.SyaratBeasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimbionServiceDatabase implements SimbionService{
	@Autowired
	private SimbionMapper simbionMapper;
	
	
	@Override
	public List<SkemaBeasiswaAktifModel> selectAllListBeasiswa(){
		log.info("Tampilkan semua data beasiswa");
		return simbionMapper.selectAllListBeasiswa();
	}
	
	@Override
	public List<SkemaBeasiswaAktifModel> selectAllListBeasiswaByStatus(){
		log.info("Tampilkan semua data beasiswa yang aktif");
		return simbionMapper.selectAllListBeasiswaByStatus();
	}
	
	@Override
	public List<TempatWawancaraModel>selectAllTempatWawancara(){
		log.info("Tampilkan semua tempat wawancara");
		return simbionMapper.selectAllTempatWawancara();
	}

	@Override
	public List<SyaratBeasiswaModel> selectSyaratBeasiswaByKode(int kode_beasiswa) {
		log.info("Tampilkan list syarat beasiswa");
		return simbionMapper.selectSyaratBeasiswaByKode(kode_beasiswa);
	}
	
	@Override
	public List<PengumumanModel> selectAllPengumuman() {
		log.info("Tampilkan list pengumuman");
		return simbionMapper.selectAllPengumuman();
	}
	
	@Override
	public List<SkemaBeasiswaAktifModel> selectBeasiswaDonatur(){
		log.info("Tampilkan list beasiswa donatur");
		return simbionMapper.selectBeasiswaDonatur();
	}
	
	@Override
	public List<PendaftaranModel> selectPendaftar(){
		log.info("Tampilkan list pendaftar");
		return simbionMapper.selectPendaftar();
	}
	
	@Override
	public List<SkemaBeasiswaAktifModel> selectListBeasiswaByDonatur(String nomor_identitas_donatur) {
		log.info("Tampilkan list beasiswa");
		return simbionMapper.selectListBeasiswaByDonatur(nomor_identitas_donatur);
	}

	@Override
	public List<PendaftaranModel> selectPendaftaranByDonatur(int kode_skema_beasiswa, int no_urut) {
		return simbionMapper.selectPendaftaranByDonatur(kode_skema_beasiswa, no_urut);
	}
	
	@Override
	public MahasiswaModel selectMahasiswa(String username) {
		log.info("Tampilkan data mahasiswa berdasarkan username");
		return simbionMapper.selectMahasiswa(username);
	}
	
	@Override
	public MahasiswaModel selectMahasiswaByNPM(String npm) {
		log.info("Tampilkan data mahasiswa berdasarkan npm");
		return simbionMapper.selectMahasiswa(npm);
	}
	
	@Override
	public DonaturModel selectDonatur(String username) {
		log.info("Tampilkan data donatur");
		return simbionMapper.selectDonatur(username);
	}
	
	@Override
	public PengumumanModel viewPengumuman(String judul) {
		log.info("Tampilkan detail pengumuman");
		return simbionMapper.viewPengumuman(judul);
	}
	
	@Override
	public SkemaBeasiswaModel selectSkemaBeasiswa(int kode) {
		log.info("Tampilkan skema beasiswa");
		return simbionMapper.selectSkemaBeasiswaByKode(kode);
	}
	
	@Override
	public SkemaBeasiswaAktifModel selectSkemaBeasiswaAktif(int kode_skema_beasiswa, int no_urut) {
		log.info("Tampilkan detail beasiswa");
		return simbionMapper.selectSkemaBeasiswaAktif(kode_skema_beasiswa, no_urut);
	}
	
	@Override
	public PendaftaranModel selectPendaftaranByNPM(int no_urut,int kode_skema_beasiswa, String npm) {
		log.info("Tampilkan data pendaftaran npm ");
		return simbionMapper.selectPendaftaranByNPM(no_urut, kode_skema_beasiswa, npm);
	}
	
	@Override
	public PenggunaModel selectPengguna(String username) {
		log.info("Tampilkan data pengguna");
		return simbionMapper.selectPengguna(username);
	}
	
	@Override
	public void insertIndividualDonor(IndividualDonorModel individualDonor) {
		simbionMapper.insertIndividualDonor(individualDonor);
	}

	@Override
	public void insertMahasiswa(MahasiswaModel mahasiswa) {
		simbionMapper.insertMahasiswa(mahasiswa);
	}
	
	@Override
	public void insertPengguna(PenggunaModel pengguna) {
		simbionMapper.insertPengguna(pengguna);
	}

	@Override
	public void insertYayasan(YayasanModel yayasan) {
		simbionMapper.insertYayasan(yayasan);
	}
	
	@Override
	public void insertDonatur(DonaturModel donatur) {
		simbionMapper.insertDonatur(donatur);
	}

	@Override
	public void insertSkemaBeasiswa(SkemaBeasiswaModel skemaBeasiswa) {
		simbionMapper.insertSkemaBeasiswa(skemaBeasiswa);
	}
		
	@Override
	public void insertSkemaBeasiswaAktif(SkemaBeasiswaAktifModel skemaBeasiswaAktif) {
		simbionMapper.insertSkemaBeasiswaAktif(skemaBeasiswaAktif);
	}
	
	@Override
	public void insertPembayaran(PembayaranModel pembayaran) {
		simbionMapper.insertPembayaran(pembayaran);
	}
	
	@Override
	public void insertPengumuman(PengumumanModel pengumuman) {
		simbionMapper.insertPengumuman(pengumuman);
	}
	
	public void insertSyaratBeasiswa(SyaratBeasiswaModel syaratBeasiswa) {
		simbionMapper.insertSyaratBeasiswa(syaratBeasiswa);
	}

	@Override
	public void insertTempatWawancara(TempatWawancaraModel tempatWawancara) {
		simbionMapper.insertTempatWawancara(tempatWawancara);
	}
	
	@Override
	public void insertPendaftaran(PendaftaranModel pendaftaran) {
		simbionMapper.insertPendaftaran(pendaftaran);
	}

	@Override
	public PengumumanModel selectPengumuman(int kode_skema_beasiswa, int no_urut_skema_beasiswa, String username) {
			return simbionMapper.selectPengumuman(kode_skema_beasiswa, no_urut_skema_beasiswa, username);
	}

	@Override
	public TempatWawancaraModel selectTempatWawancara(int kode) {
		return simbionMapper.selectTempatWawancara(kode);
	}

	@Override
	public List<SkemaBeasiswaModel> selectSkemaBeasiswa(String nomor_identitas_donatur) {
		return simbionMapper.selectSkemaBeasiswa(nomor_identitas_donatur);
	}
}
