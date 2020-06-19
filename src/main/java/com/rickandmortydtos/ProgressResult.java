package com.rickandmortydtos;

import lombok.Data;

/**
 * 
 * @author BUSRA
 * ortak bir return bilgisi icin kullanilir
 */
@Data
public class ProgressResult {

	private String info = "";
	private Boolean result;
}
