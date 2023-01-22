package com.tripmaster.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MyErrorDetails {

	private LocalDateTime localDateTime;
	private String message;
	private String details;
	
	public MyErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
	}

	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
