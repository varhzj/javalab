package com.varhzj.lab.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent event) {
		System.out.println("I (bean-demoListener) have got message from bean-demoPublisher: " + event.getMsg());
	}

}
