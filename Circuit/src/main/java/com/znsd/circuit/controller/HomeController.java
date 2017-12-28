package com.znsd.circuit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.HomeService;

@Controller
@RequestMapping("/homeController")
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	//树形菜单查询
	@ResponseBody
	@RequestMapping("/homeNav")
    public List<Power> homeNav(Integer id){
		Integer nid = id == null ? 0 : id;
		List<Power> listPower=homeService.selectAllPower(nid);
		for (Iterator iterator = listPower.iterator(); iterator.hasNext();) {
			Power power = (Power) iterator.next();
		}
    	return listPower;
    }
	
	@ResponseBody
	@RequestMapping("/login")
	public boolean login(HttpSession session,HttpServletResponse response,String userName,String passWord){
		response.setContentType("text/html;charset=UTF-8"); 
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName",userName);
		map.put("passWord",passWord);
		User user=homeService.login(map);
		if(user!=null){
			System.out.println(user);
			session.setAttribute("user",user);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String time=format.format(date);
			Map<String,Object> map2=new HashMap<String,Object>();
			map2.put("id",user.getId());
			map2.put("time",time);
			homeService.loginDate(map2);
			return true;
		}else{
			return false;
		}
		
	}
}
