package com.tripmaster.service;

import org.springframework.stereotype.Component;

import com.tripmaster.exceptions.AdminException;
import com.tripmaster.models.Admin;
import com.tripmaster.models.AdminSigninDTO;
@Component
public interface AdminService {
		public Admin createAdmin(AdminSigninDTO adminsiginDto) throws AdminException;
		public Admin updateAdmin(AdminSigninDTO adminsiginDTO, String key);
}
