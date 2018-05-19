package com.simbion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenggunaModel {
	private String username;
	private String password;
	private String role;
}
