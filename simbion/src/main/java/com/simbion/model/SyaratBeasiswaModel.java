package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SyaratBeasiswaModel {
	private int kode_beasiswa;
	private String syarat;
}
