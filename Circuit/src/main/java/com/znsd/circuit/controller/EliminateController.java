package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Eliminate;
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
		for (Eliminate eliminate : list) {
			eliminate.setOperation("<a href='#'>查看</a>|<a href='#'>分配任务</a>|<a href='#'>修改</a>|<a href='#'>取消</a>");
		}
		/*Eliminate eliminate = new Eliminate();
		eliminate.setOperation(operation);*/
		System.out.println("........"+list);
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}
	//��ѯ�����е����񵥾�
	//@RequestMapping("/getBills")
	//@ResponseBody
	/*public List<> getbills() {
		
	}*/
}
