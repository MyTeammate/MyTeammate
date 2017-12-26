package com.znsd.circuit.controller;

import java.util.Iterator;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.service.HomeService;

@Controller
@RequestMapping("/homeController")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@ResponseBody
	@RequestMapping("/homeNav")
    public List<Power> homeNav(Integer id){
		Integer nid = id == null ? 0 : id;
		List<Power> listPower=homeService.selectAllPower(nid);
		for (Iterator iterator = listPower.iterator(); iterator.hasNext();) {
			Power power = (Power) iterator.next();
			System.out.println(power);
		}
    	return listPower;
    }
}
