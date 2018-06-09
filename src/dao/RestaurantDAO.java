package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import beans.Restaurant;
import util.Serializator;

public class RestaurantDAO {

	private static final String fileName = "restaurants.json";
	private static RestaurantDAO instance;
	private Map<Long, Restaurant> restaurants = new HashMap<>();

	private RestaurantDAO() {
	}

	public static RestaurantDAO getInstance() {
		if (instance == null) {
			instance = new RestaurantDAO();
			instance.createRestaurants();
		}
		return instance;
	}

	public ArrayList<Restaurant> getRestaurants() {
		return new ArrayList<Restaurant>(restaurants.values());
	}

	private void createRestaurants() {
		Serializator.load(fileName, restaurants);
		if (restaurants.isEmpty()) {
			Restaurant restaurant = new Restaurant("Kod Laze", "Marka Markovića 2", "Domaća Kuhinja");
			Restaurant rostilj = new Restaurant("Zar Mance", "Subotička 4", "Roštilj");
			Restaurant indija = new Restaurant("Hindu", "Negde 2", "Indijski Restoran");
			Restaurant kinezi = new Restaurant("88", "Bulevar Oslobođenja 88", "Kineski Restoran");
			restaurants.put(restaurant.getId(), restaurant);
			restaurants.put(rostilj.getId(), rostilj);
			restaurants.put(indija.getId(), indija);
			restaurants.put(kinezi.getId(), kinezi);
		}
	}

	public Restaurant create(Restaurant restaurant) {
		restaurants.put(restaurant.getId(), restaurant);
		Serializator.save(fileName, restaurants);
		return restaurant;
	}

	public Restaurant getRestaurantById(long id) {
		return restaurants.get(id);
	}

	public boolean deleteRestaurant(long id) {
		if (getRestaurantById(id) != null) {
			restaurants.get(id).setActive(false);
			Serializator.save(fileName, restaurants);
			return true;
		}
		return false;
	}

	public Restaurant update(Restaurant restaurant) {
		restaurants.replace(restaurant.getId(), restaurant);
		Serializator.save(fileName, restaurants);
		return restaurant;
	}
}
