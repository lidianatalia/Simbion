package com.simbion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simbion.dao.SimbionMapper;
import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;
import com.simbion.model.PenggunaModel;
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
		log.info("Tampilkan semua data pengguna");
		return simbionMapper.selectAllListBeasiswa();
	}
	
	@Override
	public List<TempatWawancaraModel>selectAllTempatWawancara(){
		log.info("Tampilkan semua tempat wawancara");
		return simbionMapper.selectAllTempatWawancara();
	}
	
	@Override
	public SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut) {
		log.info("Tampilkan detail beasiswa");
		return simbionMapper.selectSkemaBeasiswa(no_urut);
	}

	@Override
	public List<SyaratBeasiswaModel> selectSyaratBeasiswaByKode(int kode_beasiswa) {
		log.info("Tampilkan list syarat beasiswa");
		return simbionMapper.selectSyaratBeasiswaByKode(kode_beasiswa);
	}
	
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
}
