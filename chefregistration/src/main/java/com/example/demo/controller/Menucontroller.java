package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Deletemenu;
import com.example.demo.models.Displaymenu;
import com.example.demo.models.Menudata;
import com.example.demo.models.Updatemenu;
import com.example.demo.repo.Cheftable;
import com.example.demo.repo.Menutable;
import com.example.demo.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("menu/")
public class Menucontroller 
{
	@Autowired
	Menutable menudao;
	
	@Autowired
	Cheftable dao;
	
	@Autowired
	UserRepository udao;
	
	
	
	@RequestMapping("menup")
	public String menupage() 
	{
		System.out.println("entered");
		return "menucard";
	}
	
	
	@PostMapping("menusave")
	public String menudata(@RequestBody Menudata m) 
	{
		System.out.println("hii");
		menudao.save(m);
		long id = menudao.getFoodid(m.getFoodName());
		
		return " Your Food id is " + id;
	}
	
	@RequestMapping("updatemenu")
	public String upmenudata() 
	{
		return "updatemenu";
	}
	
	
	@PostMapping("updating_menu")
	public String updatemenudata(@RequestBody Updatemenu u) 
	{		
		menudao.setUserInfoById(u.getFoodName(), u.getFoodType(), u.getFoodPeriod(), u.getFoodPrice(), u.getFoodId());
		return " Updated ";
	}
	
	
	@PostMapping("listMenuContent")
	public List<Menudata> displaychefmenus(@RequestBody Displaymenu d) 
	{
		System.out.println("hii chefid");
		System.out.println(d.getChefId());
//		chefId = 49;
		List<Menudata> menu = menudao.getAllFood(d.getChefId());
		return menu;
		
	}
	
	
	@PostMapping("delete")
	public String deletemenu(@RequestBody Deletemenu d) 
	{
		System.out.println("foodid" + d.getFoodId());
		menudao.deleteById(d.getFoodId());
		return "deleted";
	}
	
	
	
	

}
