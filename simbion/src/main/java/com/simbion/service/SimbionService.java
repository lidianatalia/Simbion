package com.simbion.service;

import java.util.List;

import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.model.SkemaBeasiswaModel;
import com.simbion.model.SyaratBeasiswaModel;

public interface SimbionService {
	List<TempatWawancaraModel>selectAllTempatWawancara();
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswa();
	List<SyaratBeasiswaModel>selectSyaratBeasiswaByKode(int kode_beasiswa);
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
}
