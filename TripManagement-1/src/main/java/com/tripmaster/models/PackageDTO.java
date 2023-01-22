package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDTO {
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
}
