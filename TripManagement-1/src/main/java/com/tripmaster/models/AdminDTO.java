package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This is not an entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
	
	private String mobile;
	private String password;

}
