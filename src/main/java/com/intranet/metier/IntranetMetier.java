package com.intranet.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import com.intranet.entities.*;
import com.intranet.dao.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IntranetMetier implements IntranetMetierInterface {
	@Autowired
	private StudentRepository studentRep ; 
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private SectionRepository sectionRep;
	@Autowired
	private AdministratorRepository administratorRep;
	@Autowired
	private CourseRepository courseRep;
	@Autowired
	private EvaluationRepository evaluationRep;
	@Autowired
	private NewsRepository newsRep;
	
	@Override
	public void createNews(String content, Date creationDate) {
		News news = newsRep.save(new News(content, creationDate));
	}

	@Override
	public void createCourse(String name, Integer duration, Teacher teacher, Section section) {
		Course course = courseRep.save(new Course("Vision", 2, teacher, section));
	}

	@Override
	public void createStudent(String name, String login, String password, Section section) {
		Student student = studentRep.save(new Student(name, login, password, section));
	}

	@Override
	public void createTeacher(String name, String login, String password) {
		Teacher teacher = teacherRep.save(new Teacher(name, login, password));
	}
	
	@Override
	public void createEvaluation(Student student, Course course, Integer grade) {
		Evaluation evaluation = evaluationRep.save(new Evaluation(student, course, grade));
	}
	
	@Override
	public List<Section> getSectionList() {
		return sectionRep.getSectionList();
	}
	
	@Override
	public Section getSectionFromName(String sectionName) {
		return sectionRep.getSectionFromName(sectionName);
	}

	@Override
	public List<Student> getStudentList() {
		return studentRep.getStudentList();
	}

	@Override
	public Student getStudentFromName(String studentName) {
		return studentRep.getStudentFromName(studentName);
	}

	@Override
	public List<Student> getStudentListWithSectionName() {
		return studentRep.getStudentListWithSectionName();
	}
	
	public List<Course> getCourseFromStudentName(String studentName) {
		return courseRep.getCourseFromStudentName(studentName);
	}

	@Override
	public Course getCourseFromName(String courseName) {
		return courseRep.getCourseFromName(courseName);
	}

	@Override
	public Teacher getTeacherFromName(String teacherName) {
		return teacherRep.getTeacherFromName(teacherName);
	}

	@Override
	public List<News> getActiveNewsList() {
		return newsRep.getActiveNewsList();
	}

	
}
