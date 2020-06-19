package com.rickandmortydtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author BUSRA
 * Episode bilgilerini iceren class
 */
@Data
public class Episode {

	private Integer id;
	private String name;
	private String air_date;
	private String episode;
	private List<String> characters= new ArrayList<String>();
	private String url;
	private String created;

}
