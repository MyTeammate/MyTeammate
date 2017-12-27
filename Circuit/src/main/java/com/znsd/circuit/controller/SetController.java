package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SetController {
    @RequestMapping("/home")
	public String home(){
		return "home";
				
	}
}
