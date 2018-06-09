package dao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import beans.Admin;
import beans.Buyer;
import beans.Delivery;
import beans.User;
import util.RuntimeTypeAdapterFactory;
import util.Serializator;

public class UserDAO {

	private static final String fileName = "users.json";
	private Map<Long, User> users = new HashMap<>();
	private static UserDAO instance;
	private RuntimeTypeAdapterFactory<User> factory;
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
			instance.createUsers();
		}
		return instance;
	}

	private UserDAO() {
		factory = RuntimeTypeAdapterFactory.of(User.class, "isA")
				.registerSubtype(Buyer.class, "buyer")
				.registerSubtype(Delivery.class, "delivery")
				.registerSubtype(Admin.class,"admin");
	}

	private void createUsers() {
		Serializator.loadHierarchy(factory, fileName, users);
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

	//TODO(Jovan): Double check return type, most likely it will need to be an ArrayList.
	public Collection<User> getUsers() {
		return users.values();
	}

	public User getUserById(long id) {
		return users.get(id);
	}

	public User login(String username, String password) {
		return users.entrySet().stream()
				.filter(u -> u.getValue().getUsername().equals(username) && u.getValue().getPassword().equals(password))
				.findFirst().orElse(null).getValue();
	}

	public User create(User user) {
		users.put(user.getId(), user);
		Serializator.saveHierarchy(factory, fileName, users);
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
		Serializator.saveHierarchy(factory, fileName, users);
		return user;
	}
}
