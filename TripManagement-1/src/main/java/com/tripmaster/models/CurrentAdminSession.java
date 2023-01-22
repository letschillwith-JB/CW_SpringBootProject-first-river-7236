package com.tripmaster.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CurrentAdminSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer adminId;
	private String uuid;
	private LocalDateTime localDateTime;
	
	public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

}
