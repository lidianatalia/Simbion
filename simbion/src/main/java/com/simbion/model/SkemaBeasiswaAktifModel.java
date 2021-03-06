package com.simbion.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SkemaBeasiswaAktifModel {
	private int kode_skema_beasiswa;
	private int no_urut;
	private Date tgl_mulai_pendaftaran;
	private Date tgl_tutup_pendaftaran;
	private String periode_penerimaan;
	private String status;
	private int jumlah_pendaftar;
	private int total_pembayaran;
	
	private String nama;
	private String syarat;

	private String jenis;
	private String deskripsi;
	private String nomor_identitas_donatur;
}
