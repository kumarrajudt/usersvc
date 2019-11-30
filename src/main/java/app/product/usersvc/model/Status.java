package app.product.usersvc.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Status {
	private Integer code;
	private String	message;
	private List<Status> statuses;
}
