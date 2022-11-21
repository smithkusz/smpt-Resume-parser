package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class Emailid {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String emaillink;
	public Emailid() {
		super();
	}
	public Emailid(int id, String name, String emaillink) {
		super();
		this.id = id;
		this.name = name;
		this.emaillink = emaillink;
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
	public String getEmaillink() {
		return emaillink;
	}
	public void setEmaillink(String emaillink) {
		this.emaillink = emaillink;
	}
	@Override
	public String toString() {
		return "Emailid [id=" + id + ", name=" + name + ", emaillink=" + emaillink + "]";
	}
	
	
}
