package com.rickandmortyservices;

import java.util.List;

import com.rickandmortydtos.ProgressResult;

/**
 * 
 * @author BUSRA
 * rickandmorty apisinden alinan verilerin kaydedilmeleri, object veya list halinde bulunabilmeleri icin kullanilanilan method imzasidir
 */
public interface ISaveAndFindService {

	public ProgressResult save(Integer id , Object object, String c);
	
	public Object find(Integer id, String c);
	
	public <T> List<T> findAll(String c);
	
	public <T> List<T> findPage(Integer count, Integer pageNumber, String c);

}
