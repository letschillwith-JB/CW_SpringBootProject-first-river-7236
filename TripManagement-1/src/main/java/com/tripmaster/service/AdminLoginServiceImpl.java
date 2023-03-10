package com.tripmaster.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Admin;
import com.tripmaster.models.AdminDTO;
import com.tripmaster.models.CurrentAdminSession;
import com.tripmaster.repository.AdminDao;
import com.tripmaster.repository.AdminSessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired 
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDAO adminSessionDAO;
	
	@Override
	public String logIntoAccount(AdminDTO adminDTO) {
		Optional<Admin> opt= adminDao.findByMobile(adminDTO.getMobile());
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}

		Admin admin1= opt.get();
		Integer adminId = admin1.getAdminId();
		Optional<CurrentAdminSession>  currAdminopt1= adminSessionDAO.findByAdminId(adminId);

		if(currAdminopt1.isPresent()) {
			return "Admin already logged in with this number.";
		}

		if(admin1.getPassword().equals(adminDTO.getPassword())) {

			String key = com.tripmaster.service.RandomString.getRandomNumberString();
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, key, LocalDateTime.now());

			adminSessionDAO.save(currentAdminSession);

			return currentAdminSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}
	}

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentAdminSession> currAdminOpt=adminSessionDAO.findByUuid(key);

		if(currAdminOpt.isPresent()) {
			CurrentAdminSession currAdmin1=currAdminOpt.get();

			adminSessionDAO.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		return "Admin does not exist, Enter correct uuid";
	}

	@Override
	public boolean isLoggedIn(Integer adminId) throws LoginException {
		Optional<CurrentAdminSession> opt = adminSessionDAO.findByAdminId(adminId);
		if(opt.isPresent()) return true;
		else throw new LoginException("LogIn first!!!");
	}

	@Override
	public boolean isLoggedInByUUID(String uuid) throws LoginException {
		Optional<CurrentAdminSession> opt = adminSessionDAO.findByUuid(uuid);
		if(opt.isPresent()) return true;
		else throw new LoginException("LogIn first!!!");
	}
	
}
