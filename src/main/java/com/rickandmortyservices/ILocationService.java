package com.rickandmortyservices;

import java.util.List;

import com.rickandmortydtos.Location;

/**
 * 
 * @author BUSRA
 * rickandmorty apisinden Location larin alindigi method imzasidir
 */
public interface ILocationService {

	public List<Location> getLocation();
}
