package lab3;

public class FoodItemEntry {
	public final int id;
	public final String name;
	public final String description;
	public final String url;
	public final String price;

	public FoodItemEntry(int id, String name, String description, String url, String price) {
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

	public String getPrice() {
		return price;
	}

}