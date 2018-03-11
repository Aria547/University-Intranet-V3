package com.intranet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_evaluationId;
    @ManyToOne
    @JoinColumn(name = "fk_studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "fk_courseId")
    private Course course;
    private Integer grade;
	
	
	public Evaluation () {super();}
	public Evaluation(Student student, Course course, Integer grade) {
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student = student;}
	public Course getCourse() {return course;}
	public void setCourse(Course course) {this.course = course;}
	public Integer getGrade() {return grade;}
	public void setGrade(Integer grade) {this.grade = grade;}
}
