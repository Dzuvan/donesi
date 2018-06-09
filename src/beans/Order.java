package beans;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Order {

	private static AtomicLong counter = new AtomicLong();
	private long id;
	private LocalDateTime dateTime;
	private Buyer buyer;
	private Delivery delivery;
	private String status;
	private String notice;

	public Order() {
	}

	public Order(LocalDateTime dateTime, Buyer buyer, Delivery delivery, String status, String notice) {
		this.id = counter.incrementAndGet();
		this.dateTime = dateTime;
		this.buyer = buyer;
		this.delivery = delivery;
		this.status = status;
		this.notice = notice;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public long getId() {
		return id;
	}

}
