package app.product.usersvc.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.product.usersvc.entity.LoginEntity;
import app.product.usersvc.interfaces.LoginDAO;
import app.product.usersvc.repository.LoginRepository;

@Component
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public List<LoginEntity> getUser(String username) {
		return loginRepository.findByUserNameAndActive(username, true);
	}

	@Override
	public LoginEntity createLogin(LoginEntity loginEntity) {
		return loginRepository.save(loginEntity);
	}

}
