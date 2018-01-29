package fr.mds.exos.supcommerce.model;

public class Product {
	public static int totalProduct;
	private long id;
	private String name;
	private String description;
	private float price;
	
	public Product(String name, String description, float price) {
		super();
		++totalProduct;
		this.id = totalProduct;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

