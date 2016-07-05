package com.varhzj.lab.spring.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("Execute per 5 second: " + DATE_FORMAT.format(new Date()));
	}

	@Scheduled(cron = "0 10 10 ? * *")
	public void fixTimeExecution() {
		System.out.println("Execute at:" + DATE_FORMAT.format(new Date()));
	}

}
