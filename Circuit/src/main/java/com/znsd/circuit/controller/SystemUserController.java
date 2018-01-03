package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemUserService;

@Controller
@RequestMapping("/userManage")
public class SystemUserController {
	@Autowired
    private SystemUserService systemUserService;
	
	@ResponseBody
	@RequestMapping("/listSystemUser")
	public Map<String,Object> listSysteUser(HttpSession session,@RequestParam("page") int page, @RequestParam("rows") int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = systemUserService.systemUserCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		List<User> listUser=systemUserService.listSystemUser(map);
		for (Iterator iterator = listUser.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(user.getLoginDate()==null){
				user.setLoginDate("新用户，暂未登录");
			}else{
				String time=user.getLoginDate();
		    	if(time.contains(".")){
		    		 time=time.substring(0,time.indexOf("."));
		    	}
		    	user.setLoginDate(time);
			}
		}
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listUser);
		map2.put("total",count);
		return map2;
	}
	
	//查询有哪些角色
	@ResponseBody
	@RequestMapping("/select")
	public List<Systemrole> selectSysteUser(){
		System.out.println("123");
		List<Systemrole> s=systemUserService.selectSysteUser();
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			Systemrole systemrole = (Systemrole) iterator.next();
			System.out.println("systemrole"+systemrole);
		}
		return s;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public int addSysteUser(int id){
		
		return 0;
	}
}
