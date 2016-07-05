package com.varhzj.lab.springmvc.web;

import com.varhzj.lab.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@RequestMapping(value = "/getjson", produces = "application/json; charset=UTF-8")
	public DemoObj getJson(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "huang");
	}

	@RequestMapping(value = "/getxml", produces = "application/xml; charset=UTF-8")
	public DemoObj getXML(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "huang");
	}

}
