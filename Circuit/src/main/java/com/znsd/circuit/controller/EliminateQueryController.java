package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eliminatequery")
public class EliminateQueryController {

	@RequestMapping("/eliminate_query")
	public String Eliminate_query(){
		return "eliminate_query";
	}
	
}
