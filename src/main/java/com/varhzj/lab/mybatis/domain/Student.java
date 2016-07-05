package com.varhzj.lab.mybatis.domain;

import java.text.DateFormat;
import java.util.Date;

public class Student {

	private Integer studId;
	private String name;
	private String email;
	private Date dob;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("StudId: ").append(studId);
		sb.append(", name: ").append(name);
		sb.append(", email: ").append(email);
		sb.append(", dob: ").append(DateFormat.getDateTimeInstance().format(dob));
		return sb.toString();
	}
}
