package com.znsd.circuit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TowerController {

	
	@RequestMapping("/intoTower")
	public String getData(){
				
		return "towerManage";		
	}
}
