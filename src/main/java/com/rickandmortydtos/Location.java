package com.rickandmortydtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author BUSRA
 * Location bilgilerini iceren class
 */
@Data
public class Location {

	private Integer id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents= new ArrayList<String>();
	private String url;
	private String created;
}
