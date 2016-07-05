package com.varhzj.lab.springmvc.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.varhzj.lab.springmvc.MyMvcConfig;
import com.varhzj.lab.springmvc.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyMvcConfig.class })
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {

	private MockMvc mockMvc;

	@Autowired
	private DemoService demoService;

	@Autowired
	private WebApplicationContext wac;

	// @Autowired
	// private MockHttpSession session;
	//
	// @Autowired
	// private MockHttpServletRequest request;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testNormalController() throws Exception {
		mockMvc.perform(get("/normal")).andExpect(status().isOk()).andExpect(view().name("page"))
				.andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
				.andExpect(model().attribute("msg", demoService.sayHello()));
	}

	@Test
	public void testRestController() throws Exception {
		mockMvc.perform(get("/testRest")).andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"))
				.andExpect(content().string(demoService.sayHello()));
	}

}
