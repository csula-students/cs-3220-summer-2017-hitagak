package cs3220_lab4;

public class Order {

	public final int id;
	public final String foodname;
	public final String foodimage;
	public final String customername;
	public String status;
	public final String date;

	public Order(int id, String foodname, String foodimage, String customername, String status, String date) {
		this.id = id;
		this.foodname = foodname;
		this.foodimage = foodimage;
		this.customername = customername;
		this.status = status;
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getFoodname() {
		return foodname;
	}

	public String getFoodimage() {
		return foodimage;
	}

	public String getCustomername() {
		return customername;
	}

	public String getDate() {
		return date;
	}

}
