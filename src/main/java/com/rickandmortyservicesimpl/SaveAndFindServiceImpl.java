package com.rickandmortyservicesimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rickandmortydtos.ProgressResult;
import com.rickandmortyservices.ISaveAndFindService;

/**
 * 
 * @author BUSRA
 */
@Service
public class SaveAndFindServiceImpl<T> implements ISaveAndFindService {

	Map<Integer, Object> dataMap;
	Map<Integer, Object> dataMapCharacter;
	Map<Integer, Object> dataMapEpisode;
	Map<Integer, Object> dataMapLocation;

	public SaveAndFindServiceImpl() {
		dataMap = new HashMap<Integer, Object>();
		dataMapCharacter = new HashMap<Integer, Object>();
		dataMapEpisode = new HashMap<Integer, Object>();
		dataMapLocation = new HashMap<Integer, Object>();
	}

	/**
	 * 
	 * rickandmorty apisinden gelen verileri kayit eder
	 * @param Integer id, Onject object, String c
	 * @return progressResult
	 */
	public ProgressResult save(Integer id, Object object , String c) {
		ProgressResult progressResult = new ProgressResult();
		dataMap.put(id, object);
		progressResult.setInfo("İşlem başarılı!");
		progressResult.setResult(true);
		if( c == "C")
			dataMapCharacter = dataMap;
		else if ( c == "E")
			dataMapEpisode = dataMap;
		else
			dataMapLocation = dataMap;
		
		return progressResult;
	}

	/**
	 * 
	 * rickandmorty apisinden gelen veriyi id si ile bulur
	 * @param  Integer id, String c
	 * @return Object o
	 */
	public Object find(Integer id , String c) {
		ProgressResult progressResult = new ProgressResult();
		Object o;
		if(c == "C") {
			o = dataMapCharacter.get(id);
		} else if (c == "E") {
			o = dataMapEpisode.get(id);
		} else {
			o = dataMapLocation.get(id);
		}
		
		if (o == null) {
			progressResult.setInfo("Böyle bir kayıt bulunmamaktadır!");
			progressResult.setResult(false);
			return progressResult;
		}
		return o;
	}

	/**
	 * 
	 * rickandmorty apisinden gelen verinin tamamini liste halinde getirir
	 * @param String c
	 * @return List dataMapAllList
	 */
	public <T> List<T> findAll(String c) {
		Map<Integer, Object> dataMapAll = new HashMap<Integer, Object>();
		if(c == "C") {
			dataMapAll = dataMapCharacter;
		} else if (c == "E") {
			dataMapAll = dataMapEpisode;
		} else if (c == "L"){
			dataMapAll = dataMapLocation;
		} else {
			List<ProgressResult> progressResultList = new ArrayList<ProgressResult>();
			ProgressResult progressResult = new ProgressResult();
			progressResult.setInfo("Yanlızca \"C\", \"E\" ve \"L\" karakterleri girebilirsiniz!");
			progressResult.setResult(false);
			progressResultList.add(progressResult);
			return (List<T>) progressResultList;
		}
		List<Object> dataMapAllList = new ArrayList<Object>(dataMapAll.values());
		return (List<T>) dataMapAllList;
	}

	/**
	 * 
	 * rickandmorty apisinden gelen listenin istenilen sayfasinin, istenilen veri kadarini getirir
	 * @param String c
	 * @return List dataMapAllList
	 */

	@Override
	public <T> List<T> findPage(Integer count, Integer pageNumber, String c) {
		Map<Integer, Object> dataMapAll = new HashMap<Integer, Object>();
		if(c == "C") {
			dataMapAll = dataMapCharacter;
		} else if (c == "E") {
			dataMapAll = dataMapEpisode;
		} else if (c == "L"){
			dataMapAll = dataMapLocation;
		} else {
			List<ProgressResult> progressResultList = new ArrayList<ProgressResult>();
			ProgressResult progressResult = new ProgressResult();
			progressResult.setInfo("Yanlızca \"C\", \"E\" ve \"L\" karakterleri girebilirsiniz!");
			progressResult.setResult(false);
			progressResultList.add(progressResult);
			return (List<T>) progressResultList;
		}
		List<Object> dataMapAllList = new ArrayList<Object>(dataMapAll.values());

		int from = Math.max(0,pageNumber*count);
		int to = Math.min(dataMapAllList.size(),(pageNumber+1)*count);

		dataMapAllList = dataMapAllList.subList(from,to);
		return (List<T>) dataMapAllList;
	}
}