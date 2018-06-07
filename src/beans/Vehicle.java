package beans;

import java.time.Year;
import java.util.concurrent.atomic.AtomicLong;

public class Vehicle {

	private static AtomicLong counter = new AtomicLong();
	private long id;
	private String manufacturer;
	private String model;
	private String type;
	private String registration;
	private Year created;
	private boolean inUsage;
	private String notice;

	public Vehicle() {
	}

	public Vehicle(String manufacturer, String model, String type, String registration, Year created, boolean inUsage,
			String notice) {
		this.id = counter.incrementAndGet();
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.registration = registration;
		this.created = created;
		this.inUsage = inUsage;
		this.notice = notice;
	}

	public long getId() {
		return id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Year getCreated() {
		return created;
	}

	public void setCreated(Year created) {
		this.created = created;
	}

	public boolean isInUsage() {
		return inUsage;
	}

	public void setInUsage(boolean inUsage) {
		this.inUsage = inUsage;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", type=" + type
				+ ", registration=" + registration + ", created=" + created + ", inUsage=" + inUsage + ", notice="
				+ notice + "]";
	}
}
