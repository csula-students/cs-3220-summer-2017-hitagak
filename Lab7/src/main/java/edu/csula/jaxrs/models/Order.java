package edu.csula.jaxrs.models;


public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public final int id;
	public final String food_name;
	public final String food_url;
	public final Double food_price;
	public String customer;
	public String status;
	
	public Order(){
		this.id=0;
		this.food_name="";
		this.food_url="";
		this.food_price=0.0;
		this.customer="";
		this.status="";
	}

	public Order(int id, String food_name, String food_url, double food_price, String customer, String status) {
		this.id = id;
		this.food_name = food_name;
		this.food_url=food_url;
		this.food_price=food_price;
		this.customer = customer;
		this.status = status;

	}

	public int getId() {
		return id;
	}


	public String getCustomer() {
		return customer;
	}


	public String getFood_name() {
		return food_name;
	}

	public String getFood_url() {
		return food_url;
	}

	public Double getFood_price() {
		return food_price;
	}

	public String getName() {
		return customer;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}


}
