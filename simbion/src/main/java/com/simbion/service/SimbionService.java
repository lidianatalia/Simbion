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
	List<SkemaBeasiswaAktifModel> selectListBeasiswaByDonatur(String nomor_identitas_donatur);
	List<SyaratBeasiswaModel>selectSyaratBeasiswaByKode(int kode_beasiswa);
	List<PengumumanModel>selectAllPengumuman();
	List<PendaftaranModel>selectPendaftaranByDonatur(int kode_skema_beasiswa, int no_urut);
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
	PengumumanModel viewPengumuman(String judul);
	void insertMahasiswa(MahasiswaModel mahasiswa);
	void insertPengguna(PenggunaModel pengguna);
	void insertDonatur(DonaturModel donatur);
	void insertIndividualDonor(IndividualDonorModel individualDonor);
	void insertYayasan(YayasanModel yayasan);
	void insertSkemaBeasiswa(SkemaBeasiswaModel skemaBeasiswa);
	void insertSkemaBeasiswaAktif(SkemaBeasiswaAktifModel skemaBeasiswaAktif);
	void insertPembayaran(PembayaranModel pembayaran);
	List<SkemaBeasiswaAktifModel> selectBeasiswaDonatur();
	List<PendaftaranModel> selectPendaftar();
	void insertSyaratBeasiswa(SyaratBeasiswaModel syarat);
	void insertPengumuman(PengumumanModel pengumuman);
	void insertTempatWawancara(TempatWawancaraModel tempatWawancara);
	void updatePendaftaranA(int kode_skema_beasiswa, int no_urut, String npm);
	void updatePendaftaranR(int kode_skema_beasiswa, int no_urut, String npm);
}
