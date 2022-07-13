package com.mirdu.SpringDataJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirdu.SpringDataJPA.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
