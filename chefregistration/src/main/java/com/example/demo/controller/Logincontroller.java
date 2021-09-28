package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Alltable;
import com.example.demo.models.LoginCrendentials;
import com.example.demo.repo.Cheftable;
import com.example.demo.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("")
public class Logincontroller 
{

	@Autowired
	Cheftable dao;
	
	@Autowired
	UserRepository udao;
	
	long id;
	static String emailid;
	static String cemailid;
	String pwd;
	
	public static String getEmailid() {
		return emailid;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public long Logincheck(@RequestBody LoginCrendentials login)
	{		
		
		List<Alltable> cdao = dao.getall();
		List<com.example.demo.models.User> usedao = udao.getall();
		
		for(Alltable ele : cdao)
		{
			if(ele.getPassword().equals(login.getPassword()) && ele.getEmail().equals(login.getEmail()))
			{
				cemailid = login.getEmail();
				System.out.println("hii");
				id = 2;
				return id;
			}
		}
		
		for(com.example.demo.models.User ele : usedao)
		{
			if(ele.getPassword().equals(login.getPassword()) && ele.getEmail().equals(login.getEmail()))
			{
				emailid = login.getEmail();
				System.out.println("hii");
				id = 1;
				return id;
			}
		}
		
//		if(dao.getnamefromemail(email).equals(dao.getnamefrompwd(password)))
//		{
//			id = 2;
//		}
//		else if(udao.getnamefromemail(email).equals(udao.getnamefrompwd(password)))
//		{
//			System.out.println(email);
//			System.out.println(password);
//			id = 1;
//		}
		
		id = 0;
		return id;
	}
	
}
