package com.rickandmortydtos;

import lombok.Data;

/**
 * 
 * @author BUSRA
 * Apiden liste halinde gelen bilgilerin Info alani icin kullanilir
 */
@Data
public class InfoDto {
	
	private Integer count;
	private Integer pages;
	private String next;
	private String prev;

}
