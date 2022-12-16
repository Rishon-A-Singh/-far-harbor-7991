package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.AdminDTO;
import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminSession;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	AdminSessionDao adminSessionDao;

	@Override
	public Admin adminRegister(Admin admin) {
		return adminDao.save(admin);
	}

	@Override
	public Admin updatePassword(AdminDTO dto, String username, String key) {
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		Admin updated = null;
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");
		Optional<Admin> opt = adminDao.findByUserUsername(username);
		if (opt.isEmpty())
			throw new AdminException("Username not found");
		else {
			Admin toUpdate = opt.get();
			Integer id = toUpdate.getAdminId();
			User user = toUpdate.getUser();
			user.setPassword(dto.getPassword());
			Admin newOne = new Admin(id, user);
			updated = adminDao.save(newOne);
		}
		return updated;

	}

	@Override
	public Admin update(Admin admin, String Username, String key) {
		Admin updated = null;
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);

		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");
		else {
			Optional<Admin> opt = adminDao.findByUserUsername(Username);
			if (opt.isEmpty())
				throw new AdminException("Username not found. Please provide proper username");
			else {
				Admin toUpdate = opt.get();
				Integer id = toUpdate.getAdminId();
				Admin newOne = new Admin(id, admin.getUser());
				updated = adminDao.save(newOne);
			}
		}
		return updated;

	}

	@Override

	public String deleteByUsername(AdminDTO dto, String key) {
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");
		else {
			Optional<Admin> opt = adminDao.findByUserUsername(dto.getUsername());
			if (opt.isEmpty())
				throw new AdminException("Username not found");
			else {
				Admin toBeDelete = opt.get();
				adminDao.delete(toBeDelete);
			}
		}
		return "Your Id with Username " + dto.getUsername() + " is Deleted.";
	}

	@Override
	public String logoutAdmin(String key) {
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		if (otp.isEmpty())
			throw new LoginException("Admin is not logged in, Please login first!");

		adminSessionDao.delete(otp.get());
		return "Admin has succefully logged out.";
	}

}