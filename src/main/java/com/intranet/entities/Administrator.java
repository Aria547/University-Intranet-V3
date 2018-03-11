package com.intranet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_administratorId;
	private String name;
	private String login;
	private String password;
	
	public Administrator() {super();}
	public Administrator(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
