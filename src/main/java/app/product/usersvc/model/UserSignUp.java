package app.product.usersvc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUp {
	
	private String userName;
	private String secret;
	private String active;

}
