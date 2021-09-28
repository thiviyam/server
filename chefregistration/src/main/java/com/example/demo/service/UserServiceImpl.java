package com.example.demo.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

    
	@Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    
	@Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
	}
}

