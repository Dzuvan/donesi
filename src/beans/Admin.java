package beans;

import java.time.LocalDate;

public class Admin extends User {
	
	public Admin() {
		super();
	}
	
	public Admin(String firstName, String lastName, String username, String password, String email, String phone,
			LocalDate birthday) {
		super(firstName, lastName, username, password, email, phone, birthday, "admin");
	}
	
}
