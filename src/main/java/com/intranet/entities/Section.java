package com.intranet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Section implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_sectionId;
	private String name;
	
	@OneToMany(mappedBy = "sectionStudent")
	private Collection<Student> studentCollection;
	@OneToMany(mappedBy = "sectionCourse")
	private Collection<Course> courseCollection;
	
	public Section () {super();}
	public Section (String name) {
		this.name = name;
	}
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	public void setCourseCollection(Collection<Course> courseCollection) {this.courseCollection = courseCollection;}
	public Collection<Course> getCourseCollection() {return this.courseCollection;}
	public void setStudentCollection(Collection<Student> studentCollection) {this.studentCollection = studentCollection;}
	public Collection<Student> getStudentCollection() {return this.studentCollection;}
}
