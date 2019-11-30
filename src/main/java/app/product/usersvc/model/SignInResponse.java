package app.product.usersvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInResponse {
	
	private Integer statusCode;
	private String authToken;
	private Status status;

}
