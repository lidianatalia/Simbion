package com.simbion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.simbion.model.DonaturModel;
import com.simbion.model.IndividualDonorModel;
import com.simbion.model.MahasiswaModel;
import com.simbion.model.PembayaranModel;
import com.simbion.model.PendaftaranModel;
import com.simbion.model.PenggunaModel;
import com.simbion.model.PengumumanModel;
import com.simbion.model.SkemaBeasiswaAktifModel;
import com.simbion.model.TempatWawancaraModel;
import com.simbion.model.SkemaBeasiswaModel;
import com.simbion.model.SyaratBeasiswaModel;
import com.simbion.model.YayasanModel;

@Mapper
public interface SimbionMapper {
	@Select("select  * from tempat_wawancara")
	List<TempatWawancaraModel>selectAllTempatWawancara();

	@Select("select sba.no_urut, sb.nama, sba.tgl_tutup_pendaftaran, \r\n" + 
			"case when  sba.status='aktif' then 'dibuka'\r\n" + 
			"else 'ditutup' end as status, sba.jumlah_pendaftar \r\n" + 
			"from SKEMA_BEASISWA sb left join SKEMA_BEASISWA_AKTIF sba\r\n" + 
			"on sb.kode= sba.kode_skema_beasiswa order by status asc")
	List<SkemaBeasiswaAktifModel> selectAllListBeasiswa();
	
	@Select("select sba.kode_skema_beasiswa, sba.no_urut, sb.nama, sba.tgl_tutup_pendaftaran, \r\n" + 
			"case when  sba.status='aktif' then 'dibuka'\r\n" + 
			"else 'ditutup' end as status, sba.jumlah_pendaftar \r\n" + 
			"from SKEMA_BEASISWA sb left join SKEMA_BEASISWA_AKTIF sba\r\n" + 
			"on sb.kode= sba.kode_skema_beasiswa where sb.nomor_identitas_donatur = #{nomor_identitas_donatur}"
			+ "order by status asc")
	List<SkemaBeasiswaAktifModel> selectListBeasiswaByDonatur(String nomor_identitas_donatur);
	
	@Select ("select p.no_urut, m.nama, p.npm, p.waktu_daftar,p.status_terima from pendaftaran p, mahasiswa m \r\n" + 
			"where p.npm=m.npm and p.kode_skema_beasiswa=#{kode_skema_beasiswa} and p.no_urut=#{no_urut}")
	List<PendaftaranModel>selectPendaftaranByDonatur(@Param("kode_skema_beasiswa")int kode_skema_beasiswa, @Param("no_urut")int no_urut);
	
	@Select("select sba.no_urut, sb.nama, sb.kode,sb.jenis, sb.deskripsi,sb.nomor_identitas_donatur \r\n" + 
			"from skema_beasiswa sb, skema_beasiswa_aktif sba \r\n" + 
			"where sb.kode = sba.kode_skema_beasiswa and no_urut = #{no_urut}")
	SkemaBeasiswaModel selectSkemaBeasiswa(int no_urut);
	
	@Select ("select * from syarat_beasiswa where kode_beasiswa=#{kode_beasiswa}")
	List<SyaratBeasiswaModel> selectSyaratBeasiswaByKode(int kode_beasiswa);

	@Insert("insert INTO mahasiswa ("
			+ "username, npm, email, nama, no_telp, "
			+ "alamat_tinggal, alamat_domisili, nama_bank, no_rekening, nama_pemilik)"
			+ "values ("
			+ "#{username},#{npm},#{email},#{nama},#{no_telp},"
			+ "#{alamat_tinggal}, #{alamat_domisili},#{nama_bank}, #{no_rekening}, #{nama_pemilik})")
	void insertMahasiswa(MahasiswaModel mahasiswa);
	
	@Insert("insert INTO individual_donor("
			+ "nik, nomor_identitas_donatur)"
			+ "values (#{nik}, #{nomor_identitas_donatur})")
	void insertIndividualDonor(IndividualDonorModel individualDonor);
	
	@Insert("insert INTO yayasan (no_sk_yayasan, email, nama, no_telp_cp, nomor_identitas_donatur) "
			+ "values (#{no_sk_yayasan}, #{email},#{nama}, #{no_telp_cp}, #{nomor_identitas_donatur})")
	void insertYayasan(YayasanModel yayasan);
	
	@Insert("insert INTO donatur ("
			+ "nomor_identitas, email, nama, npwp, no_telp, alamat,username) "
			+ "values (#{nomor_identitas}, #{email}, #{nama}, #{npwp}, #{no_telp}, #{alamat},#{username})")
	void insertDonatur(DonaturModel donatur);
	
	@Insert("insert INTO pengguna(username,password) values (#{username},#{password})")
	void insertPengguna(PenggunaModel pengguna);
	
	@Insert("insert INTO skema_beasiswa (kode, nama, jenis, deskripsi, nomor_identitas_donatur) "
			+ "values (#{kode}, #{nama}, #{jenis}, #{deskripsi}, '126193489843')")
	void insertSkemaBeasiswa(SkemaBeasiswaModel skemaBeasiswa);
	
	@Insert("insert INTO skema_beasiswa_aktif (kode_skema_beasiswa, no_urut, tgl_mulai_pendaftaran, tgl_tutup_pendaftaran) "
			+ "values (#{kode_skema_beasiswa}, #{no_urut}, #{tgl_mulai_pendaftaran}, #{tgl_tutup_pendaftaran})")
	void insertSkemaBeasiswaAktif(SkemaBeasiswaAktifModel skemaBeasiswaAktif);
	
	@Insert("insert INTO pendaftaran (kode, npm, email, indeks_prestasi) "
			+ "values (#{kode}, #{npm}, #{email}, #{indeks_prestasi})")
	void insertPendaftaran(PendaftaranModel daftarBeasiswa);
	
	@Select("select no_urut, kode_skema_beasiswa, tgl_tutup_pendaftaran, status, "
			+ "jumlah_pendaftar from skema_beasiswa_aktif where status = 'ditutup'")
	List<SkemaBeasiswaAktifModel> selectBeasiswaDonatur();
	
	
	@Select("select p.no_urut, m.nama, p.npm, p.waktu_daftar, p.status_daftar, pilih from mahasiswa m, pendaftaran p\r\n" + 
			"where p.npm = m.npm and p.kode_skema_beasiswa = #{kode};")
	List<PendaftaranModel> selectPendaftar();
	
	@Insert("insert INTO tempat_wawancara (kode, nama, lokasi) values (#{kode}, #{nama}, #{lokasi})")
	void insertTempatWawancara(TempatWawancaraModel tempatWawancara);
	
	@Select("select tanggal, judul, username from pengumuman")
	List<PengumumanModel> selectAllPengumuman();
	
	@Select("select judul, kode_skema_beasiswa, no_urut_skema_beasiswa_aktif, username, tanggal, isi\r\n" + 
			"from pengumuman where judul = #{judul}")
	PengumumanModel viewPengumuman(String judul);
	
	@Insert("insert INTO pembayaran (urutan, kode_skema_beasiswa, "
			+ "no_urut_skema_beasiswa_aktif, npm, keterangan, tgl_bayar, nominal) "
			+ "values (#{urutan}, #{kode_skema_beasiswa}, #{no_urut_skema_beasiswa_aktif},"
			+ "#{npm}, #{keterangan}, #{tgl_bayar}, #{nominal})")
	void insertPembayaran(PembayaranModel pembayaran);
	
	@Insert("insert INTO syarat_beasiswa (kode_beasiswa, syarat) values (#{kode_beasiswa}, #{syarat})")
	void insertSyaratBeasiswa(SyaratBeasiswaModel syarat);
	
	@Insert("insert INTO pengumuman (tanggal, no_urut_skema_beasiswa_aktif, kode_skema_beasiswa, username, judul, isi) "
			+ "values ('2017-04-19' , 6, 1002,  'clemens.sullivan', #{judul}, #{isi})")
	void insertPengumuman(PengumumanModel pengumuman);
<<<<<<< HEAD
	
=======
>>>>>>> d57d318e81b2f2a2fbac5aaa5a9e5b301dc07af8
	@Update("update Pendaftaran set status_terima =#{status_terima} where kode_skema_beasiswa=#{kode_skema_beasiswa}"
			+ "and no_urut=#{no_urut} and npm=#{npm}")
	void updatePendaftaran(PendaftaranModel pendaftaran, @Param("status_terima")String status_terima,
			@Param("kode_skema_beasiswa")int kode_skema_beasiswa,
			@Param("no_urut")int no_urut,
			@Param("npm")String npm);
}
