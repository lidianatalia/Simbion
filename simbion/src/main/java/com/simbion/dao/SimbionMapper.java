package com.simbion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SimbionMapper {
	@Select("select  * from tempat_wawancara")
	List<TempatWawancaraModel>selectAllTempatWawancara();
}
