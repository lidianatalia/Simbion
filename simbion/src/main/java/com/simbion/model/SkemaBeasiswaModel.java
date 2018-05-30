package com.simbion.model;

import java.util.List;

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

	private String syarat;
}
