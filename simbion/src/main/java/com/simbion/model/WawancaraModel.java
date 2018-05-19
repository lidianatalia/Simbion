package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WawancaraModel {
	private int no_urut_skema_beasiswa_aktif;
	private int kode_skema_beasiswa;
	private String jadwal;
	private int kode_tempat_wawancara;
}
