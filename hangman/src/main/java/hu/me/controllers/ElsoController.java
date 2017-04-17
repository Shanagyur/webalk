//model a beállítás paramétereinek 1 model a játéknak
//spring-boot:run talán

package hu.me.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.me.model.GetMunkakModel;
import hu.me.service.MunkaService;

@Controller
public class ElsoController {
	
	//@Autowired
	//adattagba injectálás
	private MunkaService munkaService;

/*
	@Autowired
	//konstruktorba injectálás
	public ElsoController(MunkaService munkaService) {
		this.munkaService = munkaService;
	}
*/	
	
	@Autowired
	//setterbe injectálás
	public void setMunkaService(MunkaService munkaService) {
		this.munkaService = munkaService;
	}

	@GetMapping("/")
	@ResponseBody
	public String getMunkaString(
			@Valid GetMunkakModel munkakmodel, BindingResult bindingResult) {
		String rv;
		
		if(bindingResult.hasErrors()) {
			rv = "TILOS";
		} else {
			rv = munkaService.getMessage(munkakmodel);
		}
		
		return rv; 
	}
	
	@PostMapping("/posttest")
	@ResponseBody
	public String getMunkaString() {
		return "POST valasz";
	}
}
