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
	private SystemDataService systemDataService;
	
	//数据字典分页
	@ResponseBody
	@RequestMapping("/listSystemsetting")
	public Map<String,Object> listSystemsetting(@RequestParam("page") int page, @RequestParam("rows") int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = systemDataService.systemsettingCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		List<Systemsetting> listSystem=systemDataService.listSystemsetting(map);
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listSystem);
		map2.put("total",count);
		return map2;
	}
	
	//数据字典添加数据
	@ResponseBody
	@RequestMapping("/addSystemsetting")
	public int addSystemsetting(HttpSession session,String coding,String typeName,String describe){
		Systemsetting s=this.updateSystemsetting3(coding);
		if(coding.equals(s.getCoding())){
			return 0;
		}else{
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
			int i=systemDataService.addSystemsetting(system);
			System.out.println(i);
			return i;
		}
	}
	
	//数据字典删除数据
	@ResponseBody
	@RequestMapping("/deleteSystemsetting")
	public int deleteSystemsetting(int id){
		return systemDataService.deleteSystemsetting(id);
	}
	
	//查询数据字典根据id数据
	@ResponseBody
	@RequestMapping("/updateSystemsetting")
	public Systemsetting updateSystemsetting(int id){
		return systemDataService.updateSystemsetting(id);
	}
	
	//查询数据字典根据id数据
	@ResponseBody
	@RequestMapping("/updateSystemsetting3")
	public Systemsetting updateSystemsetting3(String coding){
		return systemDataService.updateSystemsetting3(coding);
	}
    
	//数据字典修改数据
	@ResponseBody
	@RequestMapping("/updateSystemsetting2")
	public int updateSystemsetting2(int id,String coding,String typeName,String describe){
		Systemsetting system=new Systemsetting();
		system.setId(id);
		system.setCoding(coding);
		system.setName(typeName);
		system.setRemark(describe);
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		system.setUpdateDate(time);
		return systemDataService.updateSystemsetting2(system);
	}
	
	//数据字典启用禁用
	@ResponseBody
	@RequestMapping("/stateSystemsetting")
	public int stateSystemsetting(int id){
		Map<String,Object> map=new HashMap<String,Object>();
		Systemsetting system=systemDataService.updateSystemsetting(id);
		String state="";
		if("启用".equals(system.getState())){
			state="禁用";
		}else{
			state="启用";
		}
		map.put("id",id);
		map.put("state",state);
		return systemDataService.stateSystemsetting(map);
	}
	
	//数据字典配置参数
	@ResponseBody
	@RequestMapping("/querySystemsetting")
	public int querySystemsetting(HttpSession session,int id){
		session.setAttribute("systemsettingId",id);
		return 1;
	}
}
