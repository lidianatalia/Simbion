package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SkemaBeasiswaModel {
	private int kode;
	private String nama;
	private String jenis;
	private String deskripsi;
	private String nomor_identitas_donatur;
	
	private int no_urut;
	private String syarat;
}
