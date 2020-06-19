package com.rickandmortyservices;

import java.util.List;

import com.rickandmortydtos.Episode;

/**
 * 
 * @author BUSRA
 * rickandmorty apisinden Epispde larin alindigi method imzasidir
 */
public interface IEpisodeService {

	public List<Episode> getEpisode();
}
