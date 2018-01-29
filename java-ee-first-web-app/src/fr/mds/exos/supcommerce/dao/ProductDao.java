package fr.mds.exos.supcommerce.dao;

import java.util.ArrayList;
import java.util.List;

import fr.mds.exos.supcommerce.model.*;

public class ProductDao {
	
	public static ArrayList<Product> products = new ArrayList<Product>();
	
	public static ArrayList<Product> getAllProducts() {
		return products;
	}
	
	public static void addProduct(Product p) {
		products.add(p);
	}
	
	public static Product findProduct(long id) {
		for(Product p : products)
			if(p.getId() == id) return p;
		return null;
	}
	
	public static boolean removeProduct(long id) {
		return products.removeIf( (Product p) -> p.getId() == id );
	}
	
}

