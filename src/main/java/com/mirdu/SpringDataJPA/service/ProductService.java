package com.mirdu.SpringDataJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirdu.SpringDataJPA.dao.ProductDao;
import com.mirdu.SpringDataJPA.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao pdao;
	
	public String addProduct(Product p)
	{
		pdao.save(p);
		return "Product added";
	}
	
	public String viewProduct(int pid)
	{
		Product p = pdao.findById(pid).orElse(null);
		if(p!=null)
			return p.toString();
		else
			return "Product Not available";
	}
	
	public String updateProduct(Product p)
	{
		Product p1 = pdao.findById(p.getPid()).orElse(null);
		if(p1 != null)
		{
			pdao.delete(p1);
		}
		
			pdao.save(p);
	
		return "Product Updated";
	}
	
	public String deleteProduct(int pid)
	{
		Product p1 = pdao.findById(pid).orElse(null);
		if(p1 != null)
		{
			pdao.delete(p1);
			return "Product Deleted";
		}
		return "Product Not available";
		
	}
}
