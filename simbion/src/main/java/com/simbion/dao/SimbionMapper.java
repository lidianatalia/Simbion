package com.simbion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.SkemaBeasiswaModel;

@Mapper
public interface SimbionMapper {
	@Select("select sba.no_urut, sb.nama, sba.tgl_tutup_pendaftaran, \r\n" + 
			"case when  sba.status='aktif' then 'dibuka'\r\n" + 
			"else 'ditutup' end as status, sba.jumlah_pendaftar \r\n" + 
			"from SKEMA_BEASISWA sb left join SKEMA_BEASISWA_AKTIF sba\r\n" + 
			"on sb.kode= sba.kode_skema_beasiswa order by status asc")
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswa();
	
	@Select("select sba.no_urut, sb.nama, sy.syarat, sb.kode,sb.jenis, sb.deskripsi,sb.nomor_identitas_donatur \r\n" + 
			"from skema_beasiswa sb, skema_beasiswa_aktif sba, syarat_beasiswa sy\r\n" + 
			"where sb.kode = sba.kode_skema_beasiswa and sb.kode = sy.kode_beasiswa and no_urut = #{no_urut}")
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
	
}
