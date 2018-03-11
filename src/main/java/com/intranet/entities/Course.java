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
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer pk_courseId;
	private String name;
	private Integer duration;
	
	@ManyToOne
	@JoinColumn(name="fk_teacherId")
	private Teacher teacher;
	@ManyToOne()
	@JoinColumn(name="fk_sectionId")
	private Section sectionCourse;
	
	@OneToMany(mappedBy = "course")
	private Collection<Evaluation> evaluationCollection;	
	
	public Course() {super();}
	public Course(String name, Integer duration,  Teacher teacher, Section section) {
		this.name = name;
		this.duration = duration;
		this.teacher = teacher;
		this.sectionCourse = section;
	}
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	public void setDuration(Integer duration) {this.duration = duration;}
	public Integer getDuration() {return this.duration;}
	public void setTeacher(Teacher teacher) {this.teacher = teacher;}
	public Teacher getTeacher() {return this.teacher;}
	public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {this.evaluationCollection = evaluationCollection;}
	public Collection<Evaluation> getEvaluationCollection(){return this.evaluationCollection;}
	public Section getsection() {return sectionCourse;}
	public void setSection(Section section) {this.sectionCourse = section;}
}
