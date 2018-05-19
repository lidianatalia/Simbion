package com.simbion.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PendaftaranModel {
	private int no_urut;
	private int kode_skema_beasiswa;
	private String npm;
	private Date waktu_daftar;
	private String status_daftar;
	private String status_terima;
}
