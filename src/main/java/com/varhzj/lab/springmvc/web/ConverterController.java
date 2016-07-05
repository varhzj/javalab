package com.varhzj.lab.springmvc.web;

import com.varhzj.lab.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {

	@RequestMapping(value = "/convert", produces = "application/x-sohulab")
	public @ResponseBody
	DemoObj covert(@RequestBody DemoObj obj) {
		return obj;
	}
}
