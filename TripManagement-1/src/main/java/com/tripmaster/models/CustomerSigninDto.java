package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CustomerSigninDto {
	
	private String customerName;
	private String address;
	private String mobile;
	private String email;
	private String password;
	
}
