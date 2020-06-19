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
import com.rickandmortydtos.InfoDto;
import com.rickandmortydtos.Location;
import com.rickandmortyservices.ILocationService;
import com.rickandmortyservices.ISaveAndFindService;

/**
 * 
 * @author BUSRA
 */
@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
    private final static HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	@Autowired
	ISaveAndFindService saveAndFindService;

	/**
	 * 
	 *Location bilgisini rickandmorty apisinden getirip kayit eder.
	 */
	public List<Location> getLocation() {

		String methodUrl = "https://rickandmortyapi.com/api/location/";

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
			InfoDto locationInfo = objectMapper.readValue(info, InfoDto.class);
			List<Location> locationList = objectMapper.readValue(results, typeFactory.constructCollectionType(List.class, Location.class));
			
			while(locationInfo.getNext() != null) {
				methodUrl=locationInfo.getNext();
				request = HttpRequest.newBuilder().GET().uri(URI.create(methodUrl)).setHeader("User-Agent","").build();
				response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
				
				resultIndex = response.body().indexOf("\"results\":");
				info = response.body().substring(infoIndex , resultIndex);
				results = response.body().substring(resultIndex+10);
				
				locationInfo = objectMapper.readValue(info, InfoDto.class);
				
				locationList.addAll(objectMapper.readValue(results, typeFactory.constructCollectionType(List.class, com.rickandmortydtos.Location.class)));
			}
			
			
			for (com.rickandmortydtos.Location location : locationList) {
				saveAndFindService.save(location.getId(), location, "L");
			}
			System.out.println(locationList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
