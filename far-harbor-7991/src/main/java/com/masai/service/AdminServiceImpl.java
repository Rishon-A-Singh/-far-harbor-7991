package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.AdminDTO;
import com.masai.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin adminRegister(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		return adminDao.save(admin);
	}

	@Override
	public Admin updatePassword(AdminDTO dto, String username, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin update(Admin admin, String Username, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByUsername(AdminDTO dto, String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
