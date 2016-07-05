package com.varhzj.lab.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {

	private DeferredResult<String> defferredResult;

	public DeferredResult<String> getAsyncUpdate() {
		defferredResult = new DeferredResult<>();
		return defferredResult;
	}

	@Scheduled(fixedDelay = 5000)
	public void refresh() {
		if (defferredResult != null)
			defferredResult.setResult(String.valueOf(System.currentTimeMillis()));
	}
}
