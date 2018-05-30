package com.simbion.service;

import java.util.List;

import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;
import com.simbion.model.PembayaranModel;
import com.simbion.model.PendaftaranModel;
import com.simbion.model.PenggunaModel;
import com.simbion.model.PengumumanModel;
import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.model.YayasanModel;
import com.simbion.model.SkemaBeasiswaModel;
import com.simbion.model.SyaratBeasiswaModel;

public interface SimbionService {
	List<TempatWawancaraModel>selectAllTempatWawancara();
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswa();
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswaByStatus();
	List<SkemaBeasiswaAktifModel> selectListBeasiswaByDonatur(String username);
	List<SyaratBeasiswaModel>selectSyaratBeasiswaByKode(int kode_beasiswa);
	List<PengumumanModel>selectAllPengumuman();
	List<PendaftaranModel>selectPendaftaranByDonatur(int kode_skema_beasiswa, int no_urut);
	List<SkemaBeasiswaAktifModel> selectBeasiswaDonatur();
	List<PendaftaranModel> selectPendaftar();
	List<SkemaBeasiswaModel>selectSkemaBeasiswa(String nomor_identitas_donatur);
	SkemaBeasiswaModel selectSkemaBeasiswa (int kode);
	SkemaBeasiswaAktifModel selectSkemaBeasiswaAktif(int kode_skema_beasiswa, int no_urut);
	PengumumanModel viewPengumuman(String judul);
	MahasiswaModel selectMahasiswa(String username);
	MahasiswaModel selectMahasiswaByNPM(String npm);
	PenggunaModel selectPengguna(String username);
	DonaturModel selectDonatur (String username);
	PendaftaranModel selectPendaftaranByNPM (int no_urut,int kode_skema_beasiswa, String npm);
	PengumumanModel selectPengumuman(int kode_skema_beasiswa,int no_urut,String username);
	TempatWawancaraModel selectTempatWawancara(int kode);
	void insertMahasiswa(MahasiswaModel mahasiswa);
	void insertPengguna(PenggunaModel pengguna);
	void insertDonatur(DonaturModel donatur);
	void insertIndividualDonor(IndividualDonorModel individualDonor);
	void insertYayasan(YayasanModel yayasan);
	void insertSkemaBeasiswa(SkemaBeasiswaModel skemaBeasiswa);
	void insertSkemaBeasiswaAktif(SkemaBeasiswaAktifModel skemaBeasiswaAktif);
	void insertPembayaran(PembayaranModel pembayaran);
	void insertSyaratBeasiswa(SyaratBeasiswaModel syarat);
	void insertPengumuman(PengumumanModel pengumuman);
	void insertTempatWawancara(TempatWawancaraModel tempatWawancara);
	void insertPendaftaran (PendaftaranModel pendaftaran);
}
