package com.simbion.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PembayaranModel {
	private int urutan;
	private int kode_skema_beasiswa;
	private int no_urut_skema_beasiswa_aktif;
	private String npm;
	private String keterangan;
	private Date tgl_bayar;
	private int nominal;
}
