package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Admin;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> register(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.adminRegister(admin), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Admin> update(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.update(admin), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> delete(@PathVariable("id") Integer adminId){
		return new ResponseEntity<Admin>(adminService.deleteAdmin(adminId), HttpStatus.OK);
	}

}