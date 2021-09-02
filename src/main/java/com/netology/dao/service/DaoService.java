package com.netology.dao.service;

import com.netology.dao.repository.DaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DaoService {

	DaoRepository repository;

	DaoService (DaoRepository repository) {
		this.repository = repository;
	}

	public String getProductName(String name) {
		return repository.getProductName(name);
	}
}
