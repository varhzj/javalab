package com.varhzj.lab.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varhzj.lab.springmvc.service.DemoService;

@Controller
public class MyRestController {

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/testRest", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String testRest() {
		return demoService.sayHello();
	}

}
