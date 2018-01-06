package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.EliminateQuery;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.service.EliminateQueryService;

@Controller
@RequestMapping("/eliminatequery")
public class EliminateQueryController {

	@Autowired
	private EliminateQueryService eliminateQueryService;

	@RequestMapping("/eliminate_query")
	public String Eliminate_query() {
		return "eliminate_query";
	}

	@RequestMapping("/queryAllPost")
	@ResponseBody
	public Map<String, Object> queryAllPost(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "taskcoding", required = false) String taskcoding,
			@RequestParam(value = "workbills", required = false) String workbills,
			@RequestParam(value = "taskstatus", required = false) String taskstatus,
			@RequestParam(value = "xiapeople", required = false) String xiapeople,
			@RequestParam(value = "startdate", required = false) String startdate,
			@RequestParam(value = "enddate", required = false) String enddate,
			@RequestParam(value = "fxstatus", required = false) String fxstatus,
			@RequestParam(value = "fxend", required = false) String fxend) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = eliminateQueryService.getEQueryCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		
		Map<String, Object> maps = new HashMap<String, Object>();

		if (taskcoding != null && taskcoding != "" || workbills != null && workbills != ""
				|| taskstatus != null && taskstatus != "" || xiapeople != null && xiapeople != ""
				|| startdate != null && startdate != "" || enddate != null && enddate != ""
				|| fxstatus != null && fxstatus != "" || fxend != null && fxend != "") {
			if(taskcoding != null && taskcoding != "" ){
				map.put("tacoding", "%"+taskcoding+"%");
			}			
			map.put("workbills",workbills);
			map.put("taskstatus", taskstatus);			
			map.put("xiajibie", xiapeople);
			map.put("startdate", startdate);			
			map.put("enddate", enddate);
			map.put("fxstatus", fxstatus);			
			map.put("fxend", fxend);			
			
			List<EliminateQuery> querylist2 = eliminateQueryService.selectEliminayeQuery(map);
			
			maps.put("rows", querylist2);
			maps.put("total", querylist2.size());
		}else{

		List<EliminateQuery> querylist = eliminateQueryService.selectEliminayeQuery(map);

		maps.put("rows", querylist);
		maps.put("total", count);
		}
		return maps;
	}
	
	@RequestMapping("/selFlawPost")
	@ResponseBody
	public List<Flaw> selFlawPost(){
		List<Flaw> list = eliminateQueryService.selectFlawName();	
		return list;
	}

}
