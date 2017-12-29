package com.znsd.circuit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Threads;
import com.znsd.circuit.service.ThreadService;

@Controller
@RequestMapping("thread")
public class ThreadController {

	@Autowired
	private ThreadService threadService;
	
	@RequestMapping("/getThreadData")
	@ResponseBody
	public Map<String,Object> getThreadData(@RequestParam("page")int page,@RequestParam("rows")int rows,
			@RequestParam(value="coding",required=false)String coding,
			@RequestParam(value="runState",required=false,defaultValue="0")int runState,
			@RequestParam(value="lineId")int lineId) {
		Threads thread = new Threads();	
		thread.setCoding(coding);
		thread.setRunningState(runState);
		thread.setLineId(lineId);
		return threadService.pageSelectThread(page, rows, thread);
	}
	
	@RequestMapping("/intoThread")
	public String intoThread() {
		return "threadManage";
	}
	
	
	@RequestMapping("/auThread")
	public String auLine() {
		return "auThread";
	}
	
}
