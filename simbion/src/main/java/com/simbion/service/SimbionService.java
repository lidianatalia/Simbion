package com.simbion.service;

import java.util.List;

import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.SkemaBeasiswaModel;

public interface SimbionService {
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswa();
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
}
