package beans;

public class Drink extends Article {

	public Drink() {
		super("drink");
	}

	public Drink(String name, float price, String description, float volume) {
		super(name, price, description, volume, "drink");
	}
}
