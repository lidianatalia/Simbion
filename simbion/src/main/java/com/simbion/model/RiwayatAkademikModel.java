package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RiwayatAkademikModel {
	private int no_urut;
	private String npm;
	private char semester;
	private String tahun_ajaran;
	private int jumlah_sks;
	private double ips;
	private String lampiran;
}
