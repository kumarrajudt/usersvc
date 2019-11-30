package app.product.usersvc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {

	private String token;
	private Status status;
}
