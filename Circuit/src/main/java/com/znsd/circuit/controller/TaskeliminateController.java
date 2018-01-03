package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.TaskEliminate;
import com.znsd.circuit.service.TaskEliminateService;

@Controller
public class TaskeliminateController {

	@Autowired
	private TaskEliminateService taskEliminateService;

	@RequestMapping("/taskElnews")
	public String taskElnew() {
		return "taskElnews";
	}

	@RequestMapping("/selectAllEliminPost")
	@ResponseBody
	public Map<String, Object> selectAllEliminPost(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "renTitles", required = false) String renTitles,
			@RequestParam(value = "conteTitles", required = false) String conteTitles) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = taskEliminateService.selectElCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();

		if (renTitles != null && renTitles != "" || conteTitles != "" && conteTitles != null) {
			if (renTitles != null && renTitles != "") {
				map.put("rent", "%" + renTitles + "%");
			}
			if (conteTitles != "" && conteTitles != null) {
				map.put("cont", "%" + conteTitles + "%");
			}
			System.out.println("----**" + map);
		}

		List<TaskEliminate> list = taskEliminateService.selectEliminate(map);
		for (TaskEliminate eliminate : list) {
			eliminate.setEdescription("<a href='javascript:onclick=selElId()'>查看</a>");
		}
		System.out.println(list);
		maps.put("rows", list);
		maps.put("total", list.size());
		return maps;
	}

	@RequestMapping("/taskElTowerPost")
	public String taskElTowerPost(HttpSession session, @RequestParam("tcoding") String tcoding) {
		TaskEliminate task = taskEliminateService.selectElCoding(tcoding);
		session.setAttribute("taskt", task);
		return "taskElnews";
	}

	@RequestMapping("/taskElTowerAllPost")
	@ResponseBody
	public Map<String, Object> taskElTowerAllPost(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam("tcoding") String tcoding,
			@RequestParam(value = "gantTitle", required = false) String gantTitle,
			@RequestParam(value = "quexTitle", required = false) String quexTitle,
			@RequestParam(value = "seTitle", required = false) String seTitle,
			@RequestParam(value = "staTitle", required = false) String staTitle,
			@RequestParam(value = "endTitle", required = false) String endTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(tcoding + "///");
		int count = taskEliminateService.getselTowerCount(tcoding);
		System.out.println(count + "****");
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();

		if (gantTitle != null && gantTitle != "" || quexTitle != null && quexTitle != ""
				|| seTitle != null && seTitle != "" || staTitle != null && staTitle != ""
				|| endTitle != null && endTitle != "") {
			if(gantTitle != null && gantTitle != ""){
				map.put("gant", "%" + gantTitle + "%");
			}
			if(quexTitle != null && quexTitle != ""){
				map.put("quex", "%" + quexTitle + "%");
			}
			if(seTitle != null && seTitle != "" ){
				map.put("ist", seTitle);
			}
			map.put("start", staTitle);
			map.put("entt", endTitle);
		}

		List<TaskEliminate> list = taskEliminateService.selectElTower(map, tcoding);
		System.out.println("=====" + list);
		maps.put("rows", list);
		maps.put("total", list.size());
		return maps;
	}

}
