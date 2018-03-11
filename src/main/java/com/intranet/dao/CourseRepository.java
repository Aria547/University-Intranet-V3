package com.intranet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intranet.entities.Course;
import com.intranet.entities.Section;

public interface CourseRepository extends JpaRepository<Course, Long>{
	@Query(value = "SELECT INTRANETV2.course.pk_course_id, INTRANETV2.course.duration, INTRANETV2.course.name, INTRANETV2.course.fk_section_id, INTRANETV2.course.fk_teacher_id "
			+ "FROM INTRANETV2.course "
			+ "INNER JOIN INTRANETV2.section ON INTRANETV2.course.fk_section_id = INTRANETV2.section.pk_section_id "
			+ "INNER JOIN INTRANETV2.student ON INTRANETV2.section.pk_section_id = INTRANETV2.student.fk_section_id "
			+ "WHERE INTRANETV2.student.name=:studentName "
			+ "ORDER BY INTRANETV2.course.name;", nativeQuery=true)
	public List<Course> getCourseFromStudentName(@Param("studentName") String studentName);
	
	@Query(value = "SELECT * FROM INTRANETV2.course WHERE INTRANETV2.course.name=:courseName LIMIT 1;", nativeQuery=true)
	public Course getCourseFromName(@Param("courseName") String courseName); 
}
