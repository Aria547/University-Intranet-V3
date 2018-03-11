package com.intranet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_studentId;
	private String name;
	private String login;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="fk_sectionId")
	private Section sectionStudent;
	
	@OneToMany(mappedBy = "student")
	private Collection<Evaluation> evaluationCollection;
	
	public Student() {super();}
	public Student(String name, String login, String password, Section section) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.sectionStudent = section;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {this.evaluationCollection = evaluationCollection;}
	public Collection<Evaluation> getEvaluationCollection(){return this.evaluationCollection;}
	public void setSection(Section section) {this.sectionStudent = section;}
	public Section getSection() {return this.sectionStudent;}
}
