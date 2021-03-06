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

import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemRoleService;

@Controller
@RequestMapping("/roleManage")
public class SystemRoleController {
	@Autowired
	private SystemRoleService systemRoleService;
	
	@ResponseBody
	@RequestMapping("/listSystemRole")
    public Map<String,Object> listSystemRole(HttpSession session,@RequestParam("page") int page, @RequestParam("rows") int rows,String name,String state){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		map.put("name",name);
		map.put("state",state);
		int count = systemRoleService.systemRoleCount(map);
		List<Systemrole> listRole=systemRoleService.listSystemRole(map);
		for (Iterator iterator = listRole.iterator(); iterator.hasNext();) {
			Systemrole role = (Systemrole) iterator.next();
			if(role.getUpdatedDate()==null){
				role.setUpdatedDate("暂未修改");
			}else{
				String time=role.getUpdatedDate();
		    	if(time.contains(".")){
		    		 time=time.substring(0,time.indexOf("."));
		    	}
		    	role.setUpdatedDate(time);
			}
		}
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listRole);
		map2.put("total",count);
		return map2;
    }
	
	//验证角色编号和角色名称是否重复
	@ResponseBody
	@RequestMapping("/verifyRole")
	public String verifyRole(int id,String coding,String name){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("coding",coding);
		map.put("name",name);
		String re="";
		if(systemRoleService.verifyCoding(map)==null){
			re=re+"1";
		}else{
			re=re+"2";
		}
		if(systemRoleService.verifyName(map)==null){
			re=re+"1";
		}else{
			re=re+"2";
		}
		return re;
	}
	
	@ResponseBody
	@RequestMapping("/addRole")
	public int addRole(HttpSession session,int id,String coding,String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("coding", coding);
		map.put("name",name);
		User user=(User) session.getAttribute("user");
		map.put("createBy",user.getId());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		map.put("createDate",time);
		map.put("remark",name);
		return systemRoleService.addRole(map);
	}
	
	@ResponseBody
	@RequestMapping("/stateRole")
	public int stateRole(HttpSession session,int id,String state) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		String newState="0";
		if("0".equals(state)) {
			newState="1";
		}else {
			newState="0";
		}
		map.put("newState", newState);
		User user=(User) session.getAttribute("user");
		map.put("updatedBy",user.getId());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		map.put("updatedDate",time);
		return systemRoleService.stateRole(map);
	}
	
	@ResponseBody
	@RequestMapping("/queryRole")
	public Systemrole queryRole(int id) {
		return systemRoleService.queryRole(id);
	}
	
	@ResponseBody
	@RequestMapping("/updateRole")
	public int updateRole(HttpSession session,int id,String coding,String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("coding", coding);
		map.put("name",name);
		User user=(User) session.getAttribute("user");
		map.put("updatedBy",user.getId());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		map.put("updatedDate",time);
		return systemRoleService.updateRole(map);
	}
	
	@ResponseBody
	@RequestMapping("/deleteRole")
	public int deleteRole(HttpSession session,int id) {
		return systemRoleService.deleteRole(id);
	}
}
