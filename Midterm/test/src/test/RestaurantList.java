package test;

public class RestaurantList {

	public final String name;
	public final String url;
	public final Double design;
	public final Double taste;
	public final int reviewers;

	public RestaurantList(String name, String url, Double design, Double taste, int reviewers) {
		this.name = name;
		this.url = url;
		this.design = design;
		this.taste = taste;
		this.reviewers = reviewers;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Double getDesign() {
		return design;
	}

	public Double getTaste() {
		return taste;
	}

	public int getReviewers() {
		return reviewers;
	}

}
