package com.varhzj.lab.spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	@Async
	public void executeAsyncTaskService(Integer i) {
		System.out.println("Execute Async Task Service: " + i);
	}

	@Async
	public void executeAsyncTaskServicePlus(Integer i) {
		System.out.println("Execute Async Task Service Plus: " + i);
	}

}
