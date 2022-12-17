package com.trippy.models;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class LoginDTO {
	
	private String mobileNo;
	
	private String password;

}
