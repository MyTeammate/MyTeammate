package com.znsd.circuit.controller;

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
    public Map<String,Object> listSystemRole(HttpSession session,@RequestParam("page") int page, @RequestParam("rows") int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = systemRoleService.systemRoleCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
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
	public String verifyRole(String coding,String name){
		String re="";
		if(systemRoleService.verifyCoding(coding)==null){
			re=re+"1";
		}else{
			re=re+"2";
		}
		if(systemRoleService.verifyName(name)==null){
			re=re+"1";
		}else{
			re=re+"2";
		}
		return re;
	}
}
