package com.hcl.api;

import java.util.Arrays;

public class POJO_PostRequest {

	String name;
	String location;
	String phone;
	String[] courses;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "POJO_PostRequest [name=" + name + ", location=" + location + ", phone=" + phone + ", courses="
				+ Arrays.toString(courses) + "]";
	}
	
}
