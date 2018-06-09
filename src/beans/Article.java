package beans;

import java.util.concurrent.atomic.AtomicLong;

public class Article {

	private static AtomicLong counter = new AtomicLong();
	private long id;
	private String name;
	private float price;
	private String description;
	private boolean active;
	private float amount;
	protected String isA;

	public Article(String isA) {
		this.isA = isA;
	}

	public Article(String name, float price, String description, float amount, String isA) {
		this.id = counter.incrementAndGet();
		this.name = name;
		this.price = price;
		this.description = description;
		this.amount = amount;
		this.active = true;
		this.isA = isA;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
