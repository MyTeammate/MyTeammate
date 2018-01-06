package com.znsd.circuit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.znsd.circuit.model.Systemlog;
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
		List<Systemrole> s=systemUserService.selectSysteUser();
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			Systemrole systemrole = (Systemrole) iterator.next();
			System.out.println("systemrole"+systemrole);
		}
		return s;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public int addSysteUser(HttpSession session,String userName,String name,String passWord,int roleId,String entryDate){
		System.out.println("passWord:"+passWord+";roleId:"+roleId);
	    String passWord2=passWord.replaceAll(" ", "");
	    User user=new User();
	    user.setUserName(userName);
	    user.setName(name);
	    user.setPassWord(passWord2);
	    user.setEntryDate(entryDate);
	    User u=(User) session.getAttribute("user");
	    user.setCreateBy(u.getId());
	    Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		user.setCreateDate(time);
		int adduser=systemUserService.add(user);
		if(adduser==1&&roleId!=0){
			System.out.println("进来了");
			User u2=systemUserService.queryUserName(userName);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("userId", u2.getId());
			map.put("roleId",roleId);
			int i=systemUserService.addRoleId(map);
			return i;
		}else if(adduser==1){
			return adduser;
		}else {
			return 0;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/queryUserName")
	public String queryUserNameSysteUser(String userName){
		if(systemUserService.queryUserNameSysteUser(userName)!=null){
			return "error";
		}
	    return "success";
	}
	
	@ResponseBody
	@RequestMapping("/queryName")
	public String queryNameSysteUser(String name){
		if(systemUserService.queryNameSysteUser(name)!=null){
			return "error";
		}
	    return "success";
	}
	
	//冻结用户
	@ResponseBody
	@RequestMapping("/freezeUser")
	public int freezeSysteUser(HttpSession session,int id,int state){
		String newState="";
		if(state==0){
			newState="1";
		}else{
			newState="0";
		}
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("newState",newState);
		User u=(User) session.getAttribute("user");
		map.put("updateBy",u.getId());
		map.put("updatedDate", time);
	    return systemUserService.freezeSysteUser(map);
	}
	
	//根据Id查询用户信息
	@ResponseBody
	@RequestMapping("/userId")
	public User IdSysteUser(int id){
		return systemUserService.IdSysteUser(id);
	}
	
	//修改，判断账号不重复
	@ResponseBody
	@RequestMapping("/queryUserName2")
	public String queryUserNameSysteUser2(int id,String userName){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("userName",userName);
		if(systemUserService.queryUserNameSysteUser2(map)!=null){
			return "error";
		}
	    return "success";
	}
	
	@ResponseBody
	@RequestMapping("/queryName2")
	public String queryNameSysteUser2(int id,String name){
		System.out.println(id+","+name);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("name",name);
		if(systemUserService.queryNameSysteUser2(map)!=null){
			return "error";
		}
	    return "success";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public int updateSysteUser(HttpSession session,int id,String userName,String name,String passWord,int roleId,String entryDate,String leaveDate){
		System.out.println("passWord:"+passWord+";roleId:"+roleId);
	    String passWord2=passWord.replaceAll(" ", "");
	    User user=new User();
	    user.setId(id);
	    user.setUserName(userName);
	    user.setName(name);
	    user.setPassWord(passWord2);
	    user.setEntryDate(entryDate);
	    if("".equals(leaveDate)){
	    	leaveDate=null;
	    }
	    user.setLeaveDate(leaveDate);
	    User u=(User) session.getAttribute("user");
	    user.setUpdatedBy(u.getId());
	    Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		user.setUpdatedDate(time);
		int adduser=systemUserService.update(user);
		if(adduser==1&&roleId!=0){
			System.out.println("进来了");
			User u2=systemUserService.queryUserName(userName);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("userId", u2.getId());
			map.put("roleId",roleId);
			int i=systemUserService.addRoleId2(map);
			return i;
		}else if(adduser==1){
			return adduser;
		}else {
			return 0;
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public int deleteSysteUser(int id) {
		return systemUserService.delete(id);
	}
	
	@ResponseBody
	@RequestMapping("/listSystemLog")
	public Map<String,Object> listSystemLog(HttpSession session,@RequestParam("page") int page, @RequestParam("rows") int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = systemUserService.systemLogCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		List<Systemlog> listLog=systemUserService.listSystemLog(map);
		for (Iterator iterator = listLog.iterator(); iterator.hasNext();) {
			Systemlog log = (Systemlog) iterator.next();
			String time=log.getCreateDate();
	    	if(time.contains(".")){
	    		 time=time.substring(0,time.indexOf("."));
	    	}
	    	log.setCreateDate(time);
		}
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("rows",listLog);
		map2.put("total",count);
		return map2;
	}
	
	//log
    @ResponseBody
    @RequestMapping("/addLog")
    public String addLog(HttpSession session,int logId){
    	System.out.println("ew22```````````````````r");
    	return "success";
    }
}
