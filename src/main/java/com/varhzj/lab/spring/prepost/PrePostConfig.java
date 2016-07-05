package com.varhzj.lab.spring.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PrePostConfig {

	@Bean(initMethod = "init", destroyMethod = "destory")
	public BeanWayService beanWayService() {
		return new BeanWayService();
	}

	@Bean
	public JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);

		@SuppressWarnings("unused")
		BeanWayService bws = context.getBean(BeanWayService.class);
		@SuppressWarnings("unused")
		JSR250WayService jws = context.getBean(JSR250WayService.class);

		context.close();

	}

}
