package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TempatWawancaraModel {
	private int kode;
	private String nama;
	private String lokasi;
}
