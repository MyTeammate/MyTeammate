package com.znsd.circuit.controller;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemParamService;

@Controller
@RequestMapping("/paramManage")
public class SystemParamController {
	@Autowired
    private SystemParamService systemParamService;
	
	//数据字典分页
	@ResponseBody
	@RequestMapping("/listSystemparam")
	public Map<String,Object> listSystemsetting(HttpSession session,@RequestParam("page") int page, @RequestParam("rows") int rows){
		int systemsettingId=(int) session.getAttribute("systemsettingId");
		Map<String, Object> map = new HashMap<String, Object>();
		int count = systemParamService.systemparamCount(systemsettingId);
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		map.put("systemsettingId",systemsettingId);
		List<Systemparam> listSystem=systemParamService.listSystemparam(map);
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listSystem);
		map2.put("total",count);
		return map2;
	}
	
	//根据数据字典参数名查询
	@ResponseBody
	@RequestMapping("/query")
	public Systemparam query(HttpSession session,String name){
		int systemsettingId=(int) session.getAttribute("systemsettingId");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("settingId", systemsettingId);
		map.put("settingName",name);
		return systemParamService.querySystemparam(map);
	}
	
	//增加数据字典参数
	@ResponseBody
	@RequestMapping("/add")
	public String add(HttpSession session,String obj){
		String[] os=obj.split(",");
		for (int u = 0; u < os.length; u++) {
			for (int i = 0; i < os.length; i++) {
				if(os[u].equals(os[i])&&u!=i){
					System.out.println(os[u]+","+os[i]);
					return "error";
				}
				String string = os[i];
				if(this.query(session,string)!=null){
					//System.out.println("2");
					return string;
				}
			}
		}
		User user=(User) session.getAttribute("user");
		int id=(int)session.getAttribute("systemsettingId");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		Systemparam param=null;
		int in=0;
		System.out.println("12");
		for (int i = 0; i < os.length; i++) {
			String string = os[i];
			param=new Systemparam();
			param.setSettingId(id);
			param.setSettingName(string);
			param.setCreateBy(user.getId());
			param.setCreateDate(time);
			param.setRemark("配置参数名称");
			in=systemParamService.addSystemparam(param);
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public int delete(int id){
		return systemParamService.deleteSystemparam(id);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpSession session,int id,String newName){
		if(this.query(session,newName)==null){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id",id);
			map.put("name",newName);
			systemParamService.updateSystemparam(map);
			return "success";
		}
		return "error";
	}
}
