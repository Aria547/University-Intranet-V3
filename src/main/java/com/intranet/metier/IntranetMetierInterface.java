package com.intranet.metier;

import java.util.Date;
import java.util.List;

import com.intranet.entities.*;

public interface IntranetMetierInterface {
	// Administrator
	public void createNews(String content, Date creationDate);
	public void createCourse(String name, Integer duration, Teacher teacher, Section section);
	public void createStudent(String name, String login, String password, Section section);
	public void createTeacher(String name, String login, String password);
	
	// Teacher
	public void createEvaluation(Student student, Course course, Integer grade);
	
	//Utils
	public List<Section> getSectionList(); 
	public Section getSectionFromName(String sectionName);
	public List<Student> getStudentList();
	public List<Student> getStudentListWithSectionName();
	public Student getStudentFromName(String studentName);
	public List<Course> getCourseFromStudentName(String studentName);
	public Course getCourseFromName(String courseName);
	public Teacher getTeacherFromName(String teacherName);
	public List<News> getActiveNewsList(); 
}