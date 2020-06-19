package com.rickandmortydemo1.rickandmortydemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.rickandmortyservices.ICharacterService;
import com.rickandmortyservices.IEpisodeService;
import com.rickandmortyservices.ILocationService;

/**
 * @author BUSRA
*/
@SpringBootApplication(scanBasePackages = { "com" })
public class Rickandmortydemo1Application extends SpringBootServletInitializer{

	/**
	 * servislerin methot imzalarina ulasmak icin applicationcontex uzerinden bean lerine erisilmistir
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Rickandmortydemo1Application.class, args);
		ICharacterService characterService = applicationContext.getBean(ICharacterService.class);
		IEpisodeService episodeService = applicationContext.getBean(IEpisodeService.class);
		ILocationService locationService = applicationContext.getBean(ILocationService.class);
		characterService.getCharacter();
		episodeService.getEpisode();
		locationService.getLocation();
		
	}
}