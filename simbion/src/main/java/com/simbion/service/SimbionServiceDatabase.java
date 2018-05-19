package com.simbion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simbion.dao.SimbionMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SimbionServiceDatabase implements SimbionService{
	@Autowired
	private SimbionMapper simbionMapper;
}
