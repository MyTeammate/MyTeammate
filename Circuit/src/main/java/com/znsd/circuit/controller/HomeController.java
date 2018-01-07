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
    public List<Power> homeNav(HttpSession session,Integer id){
		Integer nid = id == null ? 0 : id;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("nid",nid);
		map.put("userId",((User)session.getAttribute("user")).getId());
		List<Power> listPower=homeService.selectAllPower(map);
    	return listPower;
    }
	
	@ResponseBody
	@RequestMapping("/defined")
	public String login(HttpSession session,HttpServletResponse response,String userName,String passWord,String logId){
		response.setContentType("text/html;charset=UTF-8"); 
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName",userName);
		map.put("passWord",passWord);
		User user=homeService.login(map);
		String type="";
		
		if(user!=null){
			if(user.getState()==0) {
				session.setAttribute("user",user);
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				Map<String,Object> map2=new HashMap<String,Object>();
				map2.put("id",user.getId());
				map2.put("time",time);
				session.setAttribute("date",time);
				homeService.loginDate(map2);
				type="success";
			}else {
				type="state";
			}
		}else{
			type="error";
		}
		
		return type;
	}
}
