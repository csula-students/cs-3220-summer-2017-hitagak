package edu.csula.jaxrs.models;


public class FoodItemEntry {
	public final int id;
	public final String name;
	public final String description;
	public final String url;
	public final Double price;
	

	public FoodItemEntry(){
		this.id=0;
		this.name="";
		this.description="";
		this.url="";
		this.price=0.0;
	
	}

	public FoodItemEntry(int id, String name, String description, String url, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.price = price;
		
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public Double getPrice() {
		return price;
	}
}