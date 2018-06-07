package beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Buyer extends User {

	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<Restaurant> favoriteRestaurants = new ArrayList<>();

	public Buyer() {
		super();
	}

	public Buyer(String firstName, String lastName, String username, String password, String email, String phone,
			LocalDate birthday) {
		super(firstName, lastName, username, password, email, phone, birthday, "buyer");
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	public ArrayList<Restaurant> getFavoriteRestaurants() {
		return favoriteRestaurants;
	}

	public void setFavoriteRestaurants(ArrayList<Restaurant> favoriteRestaurants) {
		this.favoriteRestaurants = favoriteRestaurants;
	}
}
