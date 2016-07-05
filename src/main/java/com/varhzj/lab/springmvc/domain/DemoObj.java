package com.varhzj.lab.springmvc.domain;

public class DemoObj {

	private Long id;
	private String name;

	/**
	 * can not use jackson to covert json to object without default constructor
	 */
	public DemoObj() {
		super();
	}

	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
