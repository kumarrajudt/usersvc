package app.product.usersvc.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.product.usersvc.dao.LoginDAOImpl;
import app.product.usersvc.entity.LoginEntity;
import app.product.usersvc.interfaces.AuthTokenProvider;
import app.product.usersvc.interfaces.Login;
import app.product.usersvc.model.SignInResponse;
import app.product.usersvc.model.Status;
import app.product.usersvc.model.UserSignUp;

@Service
public class LoginImpl implements Login {
	
	@Autowired
	LoginDAOImpl loginDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthTokenProvider authTokenProvider;
	

	@Override
	@Transactional
	public boolean createLogin(String userName, String secret, Boolean isActive) {
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setActive(isActive);
		loginEntity.setSecret(passwordEncoder.encode(secret));
		loginEntity.setUserName(userName);		
		loginEntity.setCreatedOn(new Date());
		loginDAO.createLogin(loginEntity);
		return true;
	}

	@Override
	public boolean isValidUser(UUID userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserSignUp getLoginDetails(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInResponse authenticate(String userName, String secret) {
		try {
			List<LoginEntity> loginEntities = loginDAO.getUser(userName);
			if (loginEntities == null || loginEntities.isEmpty()) {
				return new SignInResponse(4001, null, new Status(5001, "User Not Found", null));
			}	
			LoginEntity loginEntity = loginEntities.get(0);
			if(passwordEncoder.matches(secret, loginEntity.getSecret())) {
				String userAuthBearerToken = authTokenProvider.generateToken(userName);
				return new SignInResponse(2000, userAuthBearerToken, null);
			}
			return new SignInResponse(4001, null, new Status(5001, "Incorrect password", null));
		} catch (Exception ex) {
			return new SignInResponse(5001, null, null);
		}		
	}

}
