package com.simbion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.simbion.dao.SimbionMapper;
import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SimbionServiceDatabase implements SimbionService{
	@Autowired
	private SimbionMapper simbionMapper;
	
	public List<TempatWawancaraModel>selectAllTempatWawancara(){
		log.info("Tampilkan semua tempat wawancara");
		return simbionMapper.selectAllTempatWawancara();
	}
}
