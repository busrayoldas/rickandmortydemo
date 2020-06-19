package com.rickandmortydtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author BUSRA
 * Character bilgilerini iceren class
 */
@Data
public class Character {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private Location origin;
	private Location location;
	private String image;
	private List<String> episode= new ArrayList<String>();
	private String url;
	private String created;

}
