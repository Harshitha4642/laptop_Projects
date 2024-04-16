package com.prodapt.cycles.rent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private int user_id;
	private String user_name;
	private String password;
	
}
