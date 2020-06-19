package com.rickandmortyservicesimpl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.rickandmortydtos.Episode;
import com.rickandmortydtos.InfoDto;
import com.rickandmortyservices.IEpisodeService;
import com.rickandmortyservices.ISaveAndFindService;

/**
 * 
 * @author BUSRA
 */
@Service
public class EpisodeServiceImpl implements IEpisodeService {

	@Autowired
    private final static HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	@Autowired
	ISaveAndFindService saveAndFindService;

	/**
	 * 
	 *Episode bilgisini rickandmorty apisinden getirip kayit eder.
	 */
	public List<Episode> getEpisode() {

		String methodUrl = "https://rickandmortyapi.com/api/episode/";

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(methodUrl)).setHeader("User-Agent","").build();

        HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			String info = response.body();
			int infoIndex = info.indexOf("\"info\":")+7;
			int resultIndex = info.indexOf("\"results\":");
			info = info.substring(infoIndex , resultIndex);
			String results = response.body().substring(resultIndex+10);
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			InfoDto episodeInfo = objectMapper.readValue(info, InfoDto.class);
			List<Episode> episodeList = objectMapper.readValue(results, typeFactory.constructCollectionType(List.class, Episode.class));
			
			while(episodeInfo.getNext() != null) {
				methodUrl=episodeInfo.getNext();
				request = HttpRequest.newBuilder().GET().uri(URI.create(methodUrl)).setHeader("User-Agent","").build();
				response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
				
				resultIndex = response.body().indexOf("\"results\":");
				info = response.body().substring(infoIndex , resultIndex);
				results = response.body().substring(resultIndex+10);
				
				episodeInfo = objectMapper.readValue(info, InfoDto.class);
				
				episodeList.addAll(objectMapper.readValue(results, typeFactory.constructCollectionType(List.class, Episode.class)));
			}
			
			for (com.rickandmortydtos.Episode episode : episodeList) {
				saveAndFindService.save(episode.getId(), episode, "E");
			}
			System.out.println(episodeList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
