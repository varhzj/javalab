package com.varhzj.lab.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@CombineConfiguration
public class AnnotationConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		DemoService ds = context.getBean(DemoService.class);
		ds.outputResult();

		context.close();
	}

}
