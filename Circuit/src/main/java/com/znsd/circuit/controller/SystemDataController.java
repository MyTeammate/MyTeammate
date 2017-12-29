package com.znsd.circuit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Systemsetting;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemDataService;

@Controller
@RequestMapping("/dateManage")
public class SystemDataController {
	@Autowired
	private SystemDataService sytemDataService;
	
	@ResponseBody
	@RequestMapping("/listSystemsetting")
	public Map<String,Object> listSystemsetting(@RequestParam("page") int page, @RequestParam("rows") int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = sytemDataService.systemsettingCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		List<Systemsetting> listSystem=sytemDataService.listSystemsetting(map);
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listSystem);
		map2.put("total",count);
		return map2;
	}
	
	@ResponseBody
	@RequestMapping("/addSystemsetting")
	public int addSystemsetting(HttpSession session,String coding,String typeName,String describe){
		User user=(User)session.getAttribute("user");
		Systemsetting system=new Systemsetting();
		system.setCoding(coding);
		system.setName(typeName);
		system.setRemark(describe);
		system.setCreateBy(user.getId());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		system.setCreateDate(time);
		System.out.println(system);
		int i=sytemDataService.addSystemsetting(system);
		System.out.println(i);
		return i;
	}
    
}
