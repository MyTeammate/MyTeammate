package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eliminate")
public class EliminateController {
	@RequestMapping("/eliminateflaw")
	public String eliminate() {
		return "eliminate_flaw";
	}
	
	@RequestMapping("/addeliminateflaw")
	public String eliminates() {
		return "add_eliminate_flaw";
	}
	
}
