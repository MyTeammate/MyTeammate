package com.znsd.circuit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Personalwork;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.PersonalworkService;

@Controller
@RequestMapping("work")
public class PerWorkController {

	@Autowired
	private PersonalworkService personalworkService;
	
	@RequestMapping("/getPersonalworkData")
	@ResponseBody
	public Map<String,Object> getPersonalworkData(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="userId",required=false)Integer userId,HttpSession session) {
		Personalwork personalwork = new Personalwork();
		personalwork.setIsAccomplish(0);
		if(userId==null) {
			personalwork.setUserId(((User)session.getAttribute("user")).getId());
		}else {
		  personalwork.setUserId(userId);
		}
		return  personalworkService.selectMyWork(page,rows,personalwork);
	}
}
