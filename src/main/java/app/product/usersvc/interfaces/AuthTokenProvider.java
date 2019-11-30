package app.product.usersvc.interfaces;

public interface AuthTokenProvider {
	
	public String generateToken(String subject);
	public boolean validateToken(String key);

}
