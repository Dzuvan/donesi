package beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Delivery extends User {

	private Vehicle vehicle;
	private ArrayList<Order> deliveryOrders = new ArrayList<>();

	public Delivery() {
		super();
	}

	public Delivery(String firstName, String lastName, String username, String password, String email, String phone,
			LocalDate birthday) {
		super(firstName, lastName, username, password, email, phone, birthday, "delivery");
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ArrayList<Order> getDeliveryOrders() {
		return deliveryOrders;
	}

	public void setDeliveryOrders(ArrayList<Order> deliveryOrders) {
		this.deliveryOrders = deliveryOrders;
	}

}
