package com.bjsxt.pojo;

public class Permission {
	private long id;
	private String name;
	
	public Permission(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Permission() {
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
