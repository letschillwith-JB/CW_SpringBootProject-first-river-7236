package com.tripmaster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginData {
	
	@Id
	private Integer userId;
	private String userName;
	private String password;
	

}
