package app.product.usersvc.interfaces;

import java.util.UUID;

import app.product.usersvc.model.SignInResponse;
import app.product.usersvc.model.UserSignUp;

public interface Login {
	
//	boolean createLogin(UserSignUp userSignUp);
	boolean createLogin(String userName, String secret, Boolean isActive);
	boolean isValidUser(UUID userId);
	UserSignUp getLoginDetails(UUID userId);
	SignInResponse authenticate(String userName, String secret);

}
