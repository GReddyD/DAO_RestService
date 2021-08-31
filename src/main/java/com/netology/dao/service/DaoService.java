package com.netology.dao.service;

import com.netology.dao.model.Product;
import com.netology.dao.repository.DaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DaoService {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	DaoRepository repository;

	DaoService (DaoRepository repository) {
		this.repository = repository;
	}


	public String getProductName(String name) {
		List<Product> listProduct = null;
		try {
		listProduct = namedParameterJdbcTemplate.queryForList(repository.read("select.sql"),
							Map.of("name", name),Product.class);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
		if (listProduct.isEmpty()){
			return null;
		} else {
			return listProduct.toString();
		}
	}
}
