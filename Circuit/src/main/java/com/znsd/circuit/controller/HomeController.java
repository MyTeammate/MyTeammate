package com.znsd.circuit.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homeController")
public class HomeController {
	
	@RequestMapping("/homeNav")
    public String homeNav(){
		
    	return "";
    }
}
