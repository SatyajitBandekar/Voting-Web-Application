package com.MainApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Model.User;
import com.MainApp.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public User saveUser(User user)
	{
		return this.uRepo.save(user);
	}
	
	public User getUsernameAndPassword(String username, String password)
	{
		return this.uRepo.findByUsernameAndPassword(username, password);
	}

}
