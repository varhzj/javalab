package com.varhzj.lab.springmvc.web;

import javax.servlet.http.HttpServletRequest;

import com.varhzj.lab.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

	@RequestMapping(produces = "text/plain; charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access";
	}

	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain; charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access";
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access, str: " + str;
	}

	@RequestMapping(value = "/requestparam", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access, id: " + id;
	}

	@RequestMapping(value = "/obj", produces = "text/json; charset=UTF-8")
	public @ResponseBody String passObj(DemoObj obj, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access, id: " + obj.getId() + " name: " + obj.getName();
	}

}
