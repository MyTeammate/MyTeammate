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
			}
		}
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listUser);
		map2.put("total",count);
		return map2;
	}
}
