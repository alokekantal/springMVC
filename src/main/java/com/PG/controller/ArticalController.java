package com.PG.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.PG.entity.Artical;
import com.PG.service.ArticalService;

@Controller
//@RequestMapping("user")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticalController {

	@Autowired
	ArticalService articalService;
	
	//@RequestMapping("/allarticles")
	@RequestMapping(value="/allarticles", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artical>> getAllArticles(){
		List<Artical> articales =  articalService.getAllArticales();		
		return new ResponseEntity<List<Artical>>(articales, HttpStatus.OK);
	}
}
