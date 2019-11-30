package app.product.usersvc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Signup {
	
	private String userName;	
	private String secret;
	private String confirmSecret;
	private String firstName;
	private String lastName;
	private String middleName;

}
