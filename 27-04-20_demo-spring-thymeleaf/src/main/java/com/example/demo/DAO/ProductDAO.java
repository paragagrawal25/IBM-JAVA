package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer>
{
	
}
