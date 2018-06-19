package com.PG.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PG.dao.ArticalDAO;
import com.PG.entity.Artical;

@Service
public class ArticalService {
	@Autowired
	ArticalDAO articalDao;
	
	public List getAllArticales() {
		return articalDao.getAllArticales();
	}
}
