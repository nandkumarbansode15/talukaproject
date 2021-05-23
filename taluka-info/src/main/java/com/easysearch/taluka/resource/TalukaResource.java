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
	
	@GetMapping("/taluka/{talukaId}")
	public @ResponseBody Taluka getTalukaDetails(@PathVariable int talukaId)
	{
		log.info("In TalukaResource->getTalukaDetails method id="+talukaId);
		
		return talukaDao.findById(talukaId).orElse(new Taluka());
	}
	
	@PostMapping("/taluka")
	public @ResponseBody Taluka saveTalukaDetails(@RequestBody Taluka taluka)
	{
		log.info("In TalukaResource->saveTalukaDetails method taluka="+taluka);
		return talukaDao.save(taluka);
	}
}
