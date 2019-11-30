package app.product.usersvc.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "login")
public class LoginEntity {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(unique = true, nullable = false)
	private String userName;
	
	@NotNull
	private String secret;
	
	@NotNull
	private Boolean active;
	
	@NotNull
	private Date createdOn;
	
	private Date updatedOn;

}
