package com.intranet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.intranet.entities.Course;

@Entity
public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_teacherId;
	private String name;
	private String login;
	private String password;
	
	@OneToMany(mappedBy = "teacher")
	private Collection<Course> courseCollection;
	
	
	public Teacher() {super();}
	public Teacher(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public Collection<Course> getCourseCollection() {return this.courseCollection;}
	public void setCourseCollection(Collection<Course> courseCollection) {this.courseCollection = courseCollection;}
	
	
}
