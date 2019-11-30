package app.product.usersvc.entity;

import org.springframework.data.annotation.CreatedDate;

public class CommonEntity {
	
	@CreatedDate
	String createdOn;
	String updatedOn;
	boolean isActive;
}
