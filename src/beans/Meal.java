package beans;

public class Meal extends Article {

	public Meal() {
		super("meal");
	}
	
	public Meal(String name, float price, String description, float weight) {
		super(name, price, description, weight, "meal");
	}
}
