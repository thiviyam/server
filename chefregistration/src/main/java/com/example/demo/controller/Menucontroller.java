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

import com.example.demo.models.Menudata;
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
	
	
	@RequestMapping("menusave")
	@ResponseBody
	public String menudata( Menudata m) 
	{
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
	@ResponseBody
	public String updatemenudata(long foodId, String foodName, String foodType, int foodPeriod, int foodPrice) 
	{		
		menudao.setUserInfoById(foodName, foodType, foodPeriod, foodPrice, foodId);
		return " Updated ";
	}
	
	
	@PostMapping("listMenuContent")
	public List<Menudata> displaychefmenus(Integer chefId) 
	{
		System.out.println(chefId);
		List<Menudata> menu = menudao.getAllFood(chefId);
		return menu;
		
	}
	
	
	@DeleteMapping("delete")
	@ResponseBody
	public String deletemenu(Long foodId) 
	{
		menudao.deleteById(foodId);
		return "deleted";
	}
	
	
	
	

}
