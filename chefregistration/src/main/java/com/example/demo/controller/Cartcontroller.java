package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("registration/")
public class Cartcontroller 
{

	@Autowired
	UserRepository udao;
	
	 @GetMapping("cart")
	  public List<User> name() 
	  {
		  String email = Logincontroller.getEmailid();
//		  String email = "raamala@gmail.com";
		  System.out.println(email);
		  List<User> user = udao.getuser(email);
		  
		  System.out.println(email);
		  return user;
	  }
}
