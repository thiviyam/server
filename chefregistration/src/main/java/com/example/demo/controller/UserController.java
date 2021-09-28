package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("registration/")
public class UserController 
{
	
	@Autowired
	private UserService userService;
  
  @PostMapping("user")
  public String add(@RequestBody User user)
  {
	  userService.saveUser(user);
	  return "New User is added";
	    
  }

  @GetMapping("getAll")
  public List<User> list()
  {
      return userService.getAllUsers();
  }
    
 
  
    
  }
