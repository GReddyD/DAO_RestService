package com.netology.dao.controller;

import com.netology.dao.service.DaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DaoController {
	DaoService service;

	public DaoController (DaoService service){
		this.service = service;
	}

	@GetMapping("/products/fetch-product")
	public String getProductName(@RequestParam("name") String name){
		return service.getProductName(name);
	}
}
