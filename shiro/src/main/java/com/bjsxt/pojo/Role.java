package com.bjsxt.pojo;

public class Role {
	private long id;
	private String name;
	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
