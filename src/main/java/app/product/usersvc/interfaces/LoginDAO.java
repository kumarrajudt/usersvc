package app.product.usersvc.interfaces;

import java.util.List;

import app.product.usersvc.entity.LoginEntity;

public interface LoginDAO {
	
	public List<LoginEntity> getUser(String username);
	
	public LoginEntity createLogin(LoginEntity loginEntity);

}
