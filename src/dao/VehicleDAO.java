package dao;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import beans.Vehicle;
import servlets.vehicle.VehicleType;
import util.Serializator;

public class VehicleDAO {

	private static final String fileName = "vehicles.json";
	private static VehicleDAO instance;
	private Map<Long, Vehicle> vehicles = new HashMap<>();

	private VehicleDAO() {
	}

	public static VehicleDAO getInstance() {
		if (instance == null) {
			instance = new VehicleDAO();
			instance.createVehicles();
		}
		return instance;
	}

	private void createVehicles() {
		Serializator.load(fileName, vehicles);
		if (vehicles.isEmpty()) {
			Vehicle car = new Vehicle("Ford", "4", VehicleType.Car.name(), "BG 202", Year.of(1990), "Too fast");
			Vehicle bike = new Vehicle("Capriolo", "4", VehicleType.Bike.name(), "NS 202", Year.of(2018), "Slow");
			Vehicle scooter = new Vehicle("Yamaha", "bs10", VehicleType.Scooter.name(), "NS 102", Year.of(2010),
					"Not quite Italian");

			vehicles.put(car.getId(), car);
			vehicles.put(bike.getId(), bike);
			vehicles.put(scooter.getId(), scooter);
		}
	}

	public ArrayList<Vehicle> getVehicles() {
		return new ArrayList<Vehicle>(vehicles.values());
	}

	public Vehicle create(Vehicle vehicle) {
		vehicles.put(vehicle.getId(), vehicle);
		Serializator.save(fileName, vehicles);
		return vehicle;
	}

	public Vehicle getVehicleById(long id) {
		return vehicles.get(id);
	}

	public Vehicle update(Vehicle vehicle) {
		vehicles.replace(vehicle.getId(), vehicle);
		Serializator.save(fileName, vehicles);
		return vehicle;
	}

	public boolean deleteVehicle(long id) {
		if (getVehicleById(id) != null) {
			vehicles.get(id).setActive(false);
			Serializator.save(fileName, vehicles);
			return true;
		}
		return false;
	}
}
