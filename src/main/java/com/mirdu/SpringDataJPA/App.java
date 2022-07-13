package com.mirdu.SpringDataJPA;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mirdu.SpringDataJPA.configuration.AppConfig;
import com.mirdu.SpringDataJPA.entity.Product;
import com.mirdu.SpringDataJPA.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
    	ProductService ps = context.getBean(ProductService.class);
    	Product p = context.getBean(Product.class);
    	Scanner ip = new Scanner(System.in);
    	char ch = 'Y';
    	int opt = 1;
    	while(ch == 'Y')
    	{
    		ch = 'Y';
    		System.out.println("Product Management System");
        	System.out.println("Menu\n1.Add Product\n2.View Product\n3.Update Product\n4.Delete Product");
        	System.out.println("Enter your choice:");
        	opt = ip.nextInt();
        	int pid;
        	String pname;
        	float pcost;
        	switch(opt)
        	{
        	case 1:
        		System.out.println("Add a Product");
        		System.out.println("Enter the Product ID:");
        		pid = ip.nextInt();
        		p.setPid(pid);
        		System.out.println("Enter the Product Name:");
        		pname = ip.next();
        		p.setPname(pname);
        		System.out.println("Enter the product Cost:");
        		pcost = ip.nextFloat();
        		p.setPcost(pcost);
        		System.out.println(ps.addProduct(p));
        		break;
        	case 2:
        		System.out.println("Add a Product");
        		System.out.println("Enter the Product ID:");
        		pid = ip.nextInt();
        		System.out.println(ps.viewProduct(pid));
        		break;
        	case 3:
        		System.out.println("Update a Product");
        		System.out.println("Enter the Product ID:");
        		pid = ip.nextInt();
        		p.setPid(pid);
        		System.out.println("Enter the Product Name:");
        		pname = ip.next();
        		p.setPname(pname);
        		System.out.println("Enter the product Cost:");
        		pcost = ip.nextFloat();
        		p.setPcost(pcost);
        		System.out.println(ps.updateProduct(p));
        		break;
        	case 4:
        		System.out.println("Delete a Product");
        		System.out.println("Enter the Product ID:");
        		pid = ip.nextInt();
        		System.out.println(ps.deleteProduct(pid));
        		break;
        	default:
        		break;
        	}
        	System.out.println("Want to continue...(Y/N)");
        	ch = ip.next().charAt(0);
    	}
    }
}
