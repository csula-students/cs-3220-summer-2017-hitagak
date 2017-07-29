package customer;

import admin.FoodItemEntry;

public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public final int id;
	public final FoodItemEntry food;
	public String customer;
	public String status;
	public final String date;

	public Order(int id, FoodItemEntry food, String customer, String status, String date) {
		this.id = id;
		this.food = food;
		this.customer = customer;
		this.status = status;
		this.date = date;

	}

	public int getId() {
		return id;
	}

	public FoodItemEntry getFood() {
		return food;
	}

	public String getName() {
		return customer;
	}

	public String getinqueueStatus() {
		return Status.IN_QUEUE.toString();
	}

	public String getinprogressStatus() {
		return Status.IN_PROGRESS.toString();
	}

	public String getcompletedstatus() {
		return Status.COMPLETED.toString();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}

}
