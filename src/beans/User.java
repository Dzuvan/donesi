package beans;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class User {

	private static AtomicLong counter = new AtomicLong();
	private long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String phone;
	private LocalDate birthday;
	protected String isA;

	public User() {
	}

	public User(String firstName, String lastName, String username, String password, String email, String phone,
			LocalDate birthday, String isA) {
		this.id = counter.incrementAndGet();
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.isA = isA;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}

}
