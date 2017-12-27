package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SetController {
	//首页
    @RequestMapping("/home")
	public String home(){
		return "home";
				
	}
    
    //登录页
    @RequestMapping("/login")
	public String login(){
		return "login";		
	}
}
