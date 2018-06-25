package com.PG.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.PG.entity.Artical;
import com.PG.service.ArticalService;

@RestController
@RequestMapping("user")
@EnableWebMvc

@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticalController {
	@Autowired
	ArticalService articalService;
	
	@RequestMapping("/allarticles")
	@ResponseBody
	public List<Artical> getAllArticles(){
		List articales =  articalService.getAllArticales();		
		return articales;
	}
}
