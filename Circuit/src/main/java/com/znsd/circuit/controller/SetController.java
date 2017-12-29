package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    
    //数据字典页面
    @RequestMapping("/systemData")
    public String systemData(){
    	return "systemData";
    }
}
