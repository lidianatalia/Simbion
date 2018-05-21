package com.simbion.service;

import java.util.List;

import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;
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
	List<SyaratBeasiswaModel>selectSyaratBeasiswaByKode(int kode_beasiswa);
	List<PengumumanModel>selectAllPengumuman();
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
	PengumumanModel viewPengumuman(String judul);
	void insertMahasiswa(MahasiswaModel mahasiswa);
	void insertPengguna(PenggunaModel pengguna);
	void insertDonatur(DonaturModel donatur);
	void insertIndividualDonor(IndividualDonorModel individualDonor);
	void insertYayasan(YayasanModel yayasan);
	
}
