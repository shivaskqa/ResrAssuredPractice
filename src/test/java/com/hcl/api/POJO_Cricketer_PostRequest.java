package com.hcl.api;

public class POJO_Cricketer_PostRequest {
	
	
	String name;
	String country;
	String[] type_of_player;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getType_of_player() {
		return type_of_player;
	}
	public void setType_of_player(String[] type_of_player) {
		this.type_of_player = type_of_player;
	}
	

}
