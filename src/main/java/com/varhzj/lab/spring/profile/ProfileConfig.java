package com.varhzj.lab.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public DemoBean devDemoBean() {
		return new DemoBean("from dev profile");
	}

	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean() {
		return new DemoBean("from prod profile");
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(ProfileConfig.class);
		context.refresh();

		System.out.println(context.getBean(DemoBean.class).getContent());
		System.out.println(context.getBean("devDemoBean"));

		context.close();
	}
}
