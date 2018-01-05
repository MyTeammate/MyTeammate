package com.znsd.circuit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SetController {
	//首页
    @RequestMapping("/home")
	public String home(){
		return "home";
				
	}
    
  //注销
    @RequestMapping("/logout")
	public String logout(HttpSession session){
    	session.removeAttribute("user");
		return "login";
				
	}
    
    
  //注销
    @ResponseBody
    @RequestMapping("/prepareLogout")
	public String prepareLogout(int logId){
		return "login";
				
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
    
  //数据字典参数页面
    @RequestMapping("/systemParam")
    public String systemParam(){
    	return "systemParam";
    }
    
  //用户管理页面
    @RequestMapping("/systemUser")
    public String systemUser(){
    	return "systemUser";
    }
    
  //用户管理页面
    @RequestMapping("/systemRole")
    public String systemRole(){
    	return "systemRole";
    }
    
  //用户管理日志
    @RequestMapping("/systemLog")
    public String systemLog(){
    	return "systemLog";
    }
    
  
}
