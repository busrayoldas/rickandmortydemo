package com.rickandmortycontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rickandmortyservices.ISaveAndFindService;

/**
 * @author BUSRA
 * disaridan gelen istekleri karsilar.
*/
@RestController
public class EpisodeController {
	
	@Autowired
	ISaveAndFindService saveAndFindService;
	
	/**
	 * getirilmis olan tüm karakter listesini doner
	 * @return List
	 */
	@GetMapping("/episode")
	public  <T> List<T> getAllCharacters() {
		return saveAndFindService.findAll("E");
	}
	 
	/**
	 * id ile character getirir
	 * @param id
	 * @return Episode
	 */
	@GetMapping("/episode/{id}")
	public Object getSingleCharacter(@PathVariable Integer id) {
		return saveAndFindService.find(id, "E");
	}
	
	/**
	 * getirilmis olan episode listesinde hangi sayfayi ve o sayfada kac tane veri getirilecegini doner
	 * @return List
	 */
	@GetMapping("/character/{count}/{pageNumber}")
	public  <T> List<T> getAllCharactersPaging(@PathVariable Integer count, @PathVariable Integer pageNumber) {
		return saveAndFindService.findPage(count, pageNumber , "C");
	}
	
}
