package hw4_admin;

import java.sql.Date;

public class FoodItemEntry {
	public final int id;
	public final String name;
	public final String description;
	public final String url;
	public final Double price;
	public final Date date;

	public FoodItemEntry(int id, String name, String description, String url, Double price, Date date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.price = price;
		this.date = date;
	}

	public Date getDate() {
		return date;
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