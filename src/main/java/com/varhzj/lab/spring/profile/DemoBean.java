package com.varhzj.lab.spring.profile;

public class DemoBean {

	private String content;

    private static final String staticFinalField;

    static {
        if ("prod".equals(System.getProperties().get("env"))) {
            staticFinalField = "prod";
        } else {
            staticFinalField = "test";
        }
    }

	public DemoBean(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
