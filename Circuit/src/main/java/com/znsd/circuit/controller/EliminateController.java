package com.znsd.circuit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;

@Controller
@RequestMapping("/eliminate")
public class EliminateController {
	
	@Autowired
	private EliminateService eliminateService;
	@RequestMapping("/eliminateflaw")
	public String eliminate() {
		return "eliminate_flaw";
	}
	
	@RequestMapping("/addeliminateflaw")
	public String eliminates() {
		return "add_eliminate_flaw";
	}
	//查询出任务
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String,Object> getAll(@RequestParam("page") int page, @RequestParam("rows") int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = eliminateService.getCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		List<Eliminate> list = eliminateService.getAllTask(map);
		/*for (Eliminate eliminate : list) {
			eliminate.setOperation("<a href='#'>查看</a> | <a href='#'>分配任务</a> | <a href='#'>修改</a> | <a href='#'>取消</a>");
		}*/
		/*Eliminate eliminate = new Eliminate();
		eliminate.setOperation(operation);*/
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}
	//查询单据
	@RequestMapping("/getBills")
	@ResponseBody
	public List<Systemparam> getbills() {
		String str = "bills";
		List<Systemparam> list = eliminateService.getAllBills(str);
		return list;
	}
	//查询线路管理员
	@RequestMapping("/getLineUser")
	@ResponseBody
	public List<User> getLineUser(){
		List<User> list = eliminateService.getAllLineUser();
		return list;
	}
	//查询消缺员
	@RequestMapping("/getEliminateUser")
	@ResponseBody
	public List<User> getEliminateUser(){
		List<User> list = eliminateService.getAlleliminateUser();
		return list;
	}
	@RequestMapping("/getEliminateUserById")
	@ResponseBody
	public List<User> getById(String str){
		String[] s = str.split(",");
		List<User> list = new ArrayList<User>();
		User user=null;
		for (String string : s) {
			int id = Integer.parseInt(string);
			user= eliminateService.getAllUserEliminate(id);
			list.add(user);
		}
		System.out.println("...."+list);
		return list;
	}
	@RequestMapping("/updateTaskStatusById")
	public String updateTaskStatusById(Integer id) {
		eliminateService.updateTaskstatus(id);
		return "eliminate_flaw";
	}
}
