package com.varhzj.lab.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.varhzj.lab.springmvc.service.PushService;

@Controller
public class AysncController {

	@Autowired
	private PushService pushService;

	@RequestMapping(value = "/defer")
	public @ResponseBody DeferredResult<String> deferredCall() {
		return pushService.getAsyncUpdate();
	}

}
