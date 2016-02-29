package com.model;

public class User {

	private int id;
	private String name;
	private String password;
	private String type;
	
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		String str="id:"+this.id+"\n"+
				"name:"+this.name+"\n"+
				"password:"+this.password+"\n"+
				"type:"+this.type;
		return str;
	}
	
}
