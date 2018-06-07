package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import beans.Admin;
import beans.Buyer;
import beans.Delivery;
import beans.User;
import util.RuntimeTypeAdapterFactory;

public class UserDAO {

	private Map<Long, User> users = new HashMap<>();
	private static UserDAO instance;

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
			instance.createUsers();
		}
		return instance;
	}

	private UserDAO() {
	}

	private void createUsers() {
		load();
		if (users.isEmpty()) {
			Admin admin = new Admin("admin", "admin", "admin", "admin", "admin@gmail.com", "011/1234-456",
					LocalDate.now());
			Delivery mod = new Delivery("janko", "jankovic", "janko", "1234", "janko@gmail.com", "021/555-333",
					LocalDate.now());
			Buyer user = new Buyer("milan", "milanovic", "miki", "1234", "miki@hotmail.rs", "023/233-333",
					LocalDate.now());

			users.put(admin.getId(), admin);
			users.put(mod.getId(), mod);
			users.put(user.getId(), user);
		}
	}

	public Collection<User> getUsers() {
		return users.values();
	}

	public User getUserById(long id) {
		return users.get(id);
	}

	private void save() {
		RuntimeTypeAdapterFactory<User> runtimeAdapterFactory = RuntimeTypeAdapterFactory.of(User.class, "isA")
				.registerSubtype(Buyer.class, "buyer")
				.registerSubtype(Delivery.class, "delivery")
				.registerSubtype(Admin.class,"admin");
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(runtimeAdapterFactory).create();
		try (FileWriter file = new FileWriter(new File("users.json"))) {
			file.write(gson.toJson(users));
		} catch (IOException e) {
		}
	}

	private void load() {
		RuntimeTypeAdapterFactory<User> runtimeAdapterFactory = RuntimeTypeAdapterFactory.of(User.class, "isA")
				.registerSubtype(Buyer.class, "buyer")
				.registerSubtype(Delivery.class, "delivery")
				.registerSubtype(Admin.class, "admin");
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapterFactory(runtimeAdapterFactory).create();
		try {
			JsonReader reader = new JsonReader(new FileReader("users.json"));
			users = gson.fromJson(reader, new TypeToken<Map<Long, User>>() {}.getType());
		} catch (FileNotFoundException | JsonSyntaxException jpe) {
		}
	}

	public User login(String username, String password) {
		return users.entrySet().stream()
				.filter(u -> u.getValue().getUsername().equals(username) && u.getValue().getPassword().equals(password))
				.findFirst().orElse(null).getValue();
	}

	public User create(User user) {
		users.put(user.getId(), user);
		save();
		return user;
	}

	public boolean checkUniqueUsername(String username) {
		for (User u : users.values()) {
			if (u.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

	public User updateUser(User user) {
		users.replace(user.getId(), user);

		return user;
	}
}
