package beans;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Restaurant {

	private static AtomicLong counter = new AtomicLong();
	private long id;
	private String name;
	private String address;
	private String category;
	private ArrayList<Meal> meals = new ArrayList<>();
	private ArrayList<Drink> drinks = new ArrayList<>();
	private boolean active;

	public Restaurant() {
	}

	public Restaurant(String name, String address, String category) {
		this.id = counter.incrementAndGet();
		this.name = name;
		this.address = address;
		this.category = category;
		this.active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}

	public ArrayList<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(ArrayList<Drink> drinks) {
		this.drinks = drinks;
	}

}
