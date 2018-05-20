package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class YayasanModel {
	private String no_sk_yayasan;
	private String email;
	private String nama;
	private String no_telp_cp;
	private String nomor_identitas_donatur;
}
