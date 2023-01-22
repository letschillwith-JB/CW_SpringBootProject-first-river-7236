package com.tripmaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.exceptions.AdminException;
import com.tripmaster.models.Admin;
import com.tripmaster.models.AdminSigninDTO;
import com.tripmaster.models.CurrentAdminSession;
import com.tripmaster.repository.AdminDao;
import com.tripmaster.repository.AdminSessionDAO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminSessionDAO adminSessionDAO;
	
	@Override
	public Admin createAdmin(AdminSigninDTO adminsigninDto) throws AdminException {
		Optional<Admin> opt= adminDao.findByMobile(adminsigninDto.getMobile());
		if(opt.isEmpty()) {
			Admin admin = new Admin();
		 admin.setAdminName(adminsigninDto.getAdminName());
		 admin.setPassword(adminsigninDto.getPassword());
		 admin.setMobile(adminsigninDto.getMobile());
		 admin.setEmail(adminsigninDto.getEmail());
		 
		 return adminDao.save(admin);
		}
//		 admin.setUserType("admin");
		
		throw new AdminException("User already exist...");
		
	}

	@Override
	public Admin updateAdmin(AdminSigninDTO adminsigninDto, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Admin admin = new Admin();
		 admin.setAdminName(adminsigninDto.getAdminName());
		 admin.setPassword(adminsigninDto.getPassword());
		 admin.setMobile(adminsigninDto.getMobile());
		 admin.setEmail(adminsigninDto.getEmail());
		 
//		 admin.setUserType("admin");
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return adminDao.save(admin);
	}
}
