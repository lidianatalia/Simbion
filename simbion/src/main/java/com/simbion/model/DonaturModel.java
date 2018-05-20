package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DonaturModel {
	private String nomor_identitas;
	private String email;
	private String nama;
	private String npwp;
	private String no_telp;
	private String alamat;
	private String username;
}
