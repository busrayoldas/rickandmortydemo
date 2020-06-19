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
public class CharacterController {
	
	@Autowired
	ISaveAndFindService saveAndFindService;
	
	/**
	 * getirilmis olan tüm karakter listesini doner
	 * @return List
	 */
	@GetMapping("/character")
	public  <T> List<T> getAllCharacters() {
		return saveAndFindService.findAll("C");
	}
	 
	/**
	 * id ile character getirir
	 * @param id
	 * @return Character
	 */
	@GetMapping("/character/{id}")
	public Object getSingleCharacter(@PathVariable Integer id) {
		return saveAndFindService.find(id, "C");
	}
	
	/**
	 * getirilmis olan karakter listesinde hangi sayfayi ve o sayfada kac tane veri getirilecegini doner
	 * @return List
	 */
	@GetMapping("/character/{count}/{pageNumber}")
	public  <T> List<T> getAllCharactersPaging(@PathVariable Integer count, @PathVariable Integer pageNumber) {
		return saveAndFindService.findPage(count, pageNumber , "C");
	}
	
}
