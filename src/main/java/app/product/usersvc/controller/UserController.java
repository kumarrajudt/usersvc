package app.product.usersvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.product.usersvc.interfaces.Login;
import app.product.usersvc.model.SignIn;
import app.product.usersvc.model.SignInResponse;
import app.product.usersvc.model.Signup;
import app.product.usersvc.model.SignupResponse;
import app.product.usersvc.model.Status;

@RestController
@RequestMapping(path = "usersvc/v1/user")
public class UserController {
//	
//	@Autowired
//	AuthTokenProvider authTokenProvider;
//	
	@Autowired
	Login login;
	

	@PostMapping(path = "/authenticate")
	public SignInResponse authenticate(@RequestBody SignIn signInDetails) {
		return login.authenticate(signInDetails.getUserName(), signInDetails.getSecret());
	}

	@PostMapping(path = "/signup")
	public SignupResponse createUser(@RequestBody Signup signupDetails) {
		SignupResponse signup = new SignupResponse();
		boolean isSuccess = login.createLogin(signupDetails.getUserName(), signupDetails.getSecret(), true);
		if (isSuccess)
			signup.setStatus(new Status(201, "User created ".concat(signupDetails.getUserName()), null));
		else {
			signup.setStatus(new Status(500, "User not created ".concat(signupDetails.getUserName()), null));
		}
		return signup;
	}
}
