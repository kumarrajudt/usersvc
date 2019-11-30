package app.product.usersvc.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.product.usersvc.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, UUID> {
	
	public List<LoginEntity> findByUserName(String username);
	
	public List<LoginEntity> findByUserNameAndActive(String username, Boolean active);

}
