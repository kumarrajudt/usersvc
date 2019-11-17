package app.product.usersvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "usersvc/v1/")
public class User {

	@GetMapping(path = "user")
	public String getUser() {
		return "Raj Test";
	}
}
