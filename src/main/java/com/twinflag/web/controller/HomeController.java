package com.twinflag.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twinflag.web.model.User;
import com.twinflag.web.service.IBaseService;

@Controller
public class HomeController {
	
	@Autowired
	private IBaseService<User, String> baseService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public String login(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		String id = baseService.save(user);
		return id;
	}
}
