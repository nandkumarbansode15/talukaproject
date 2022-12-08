package com.easysearch.taluka.resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easysearch.taluka.dao.TalukaDao;
import com.easysearch.taluka.pojo.Taluka;

@RestController
@Slf4j
public class TalukaResource {

	@Autowired
	private TalukaDao talukaDao;
	
	@GetMapping("/taluka/{talukaName}")
	public @ResponseBody Taluka getTalukaDetails(@PathVariable String talukaName)
	{
		log.info("In TalukaResource->getTalukaDetails method id="+talukaName);
		
		return talukaDao.findByName(talukaName);
	}
	
	@PostMapping("/taluka")
	public @ResponseBody Taluka saveTalukaDetails(@RequestBody Taluka taluka)
	{
		log.info("In TalukaResource->saveTalukaDetails method taluka="+taluka);
		return talukaDao.save(taluka);
	}
}
