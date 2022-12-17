package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin adminRegister(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		if(admin==null) {
			throw new AdminException("Unable to Register");
		}
		adminDao.save(admin);
		return admin;
		
	}

	@Override
	public Admin update(Admin admin) throws AdminException {
		Optional<Admin> opt = adminDao.findById(admin.getAdminId());
		if(opt.isPresent()) {
			opt.get().setUser(admin.getUser());
			adminDao.save(opt.get());
		}else {
			throw new AdminException("Update Failed....");
		}
		return opt.get();
	}

	@Override
	public Admin deleteAdmin(Integer AdminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> opt = adminDao.findById(AdminId);
		if(opt.isPresent()) {
			adminDao.delete(opt.get());
		}else {
			throw new AdminException("Delete Failed...");
		}
		return opt.get();
	}

	

}