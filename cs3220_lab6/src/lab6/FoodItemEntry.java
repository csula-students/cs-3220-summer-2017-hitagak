package lab6;

public class FoodItemEntry {
	public final int id;
	public final String name;
	public final String description;
	public final String url;
	public final Double price;
	public final String date;

	public FoodItemEntry(int id, String name, String description, String url, Double price, String date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.price = price;
		this.date = date;
	}

	public String getDate() {
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
