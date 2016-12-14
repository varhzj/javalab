package com.varhzj.lab.springmvc.web;

import com.varhzj.lab.springmvc.domain.DemoObj;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@RequestMapping(value = "/getjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DemoObj getJson(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "huang");
	}

	@RequestMapping(value = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
	public DemoObj getXML(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "huang");
	}

}
