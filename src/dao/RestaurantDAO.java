package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import beans.Restaurant;
import servlets.restaurant.Category;

public class RestaurantDAO {

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
		load();
		if (restaurants.isEmpty()) {
			Restaurant restaurant = new Restaurant("Kod Laze", "Marka Markovića 2", Category.DomacaKuhinja.name());
			Restaurant rostilj = new Restaurant("Zar Mance", "Subotička 4", Category.Rostilj.name());
			Restaurant indija = new Restaurant("Hindu", "Negde 2", Category.IndijskiRestoran.name());
			Restaurant kinezi = new Restaurant("88", "Bulevar Oslobođenja 88", Category.KineskiRestoran.name());
			restaurants.put(restaurant.getId(), restaurant);
			restaurants.put(rostilj.getId(), rostilj);
			restaurants.put(indija.getId(), indija);
			restaurants.put(kinezi.getId(), kinezi);
		}
	}

	private void save() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try (FileWriter file = new FileWriter(new File("restaurants.json"))) {
			file.write(gson.toJson(restaurants));
		} catch (IOException e) {
		}
	}

	private void load() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			JsonReader reader = new JsonReader(new FileReader("restaurants.json"));
			restaurants = gson.fromJson(reader, new TypeToken<Map<Long, Restaurant>>() {
			}.getType());
		} catch (FileNotFoundException | JsonSyntaxException jpe) {
		}
	}

	public Restaurant create(Restaurant restaurant) {
		restaurants.put(restaurant.getId(), restaurant);
		save();
		return restaurant;
	}

	public Restaurant getRestaurantById(long id) {
		return restaurants.get(id);
	}

	public boolean deleteRestaurant(long id) {
		if (getRestaurantById(id) != null) {
			restaurants.get(id).setActive(false);
			save();
			return true;
		}
		return false;
	}

	public Restaurant update(Restaurant restaurant) {
		restaurants.replace(restaurant.getId(), restaurant);
		save();
		return restaurant;
	}
}
