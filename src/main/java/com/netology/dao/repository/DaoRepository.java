package com.netology.dao.repository;

import com.netology.dao.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	String scriptFile = read("select.sql");

	public String getProductName(String name) {
		List<Product> listProduct = null;
		try {
			listProduct = namedParameterJdbcTemplate.queryForList(scriptFile,
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

	public String read(String scriptFileName) {
		try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
			return bufferedReader.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}