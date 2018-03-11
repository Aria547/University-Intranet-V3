package com.intranet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intranet.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value = "SELECT * FROM INTRANETV2.student;", nativeQuery=true)
	public List<Student> getStudentList(); 
	
	@Query(value = "SELECT * FROM INTRANETV2.student WHERE INTRANETV2.student.name=:studentName LIMIT 1;", nativeQuery=true)
	public Student getStudentFromName(@Param("studentName") String studentName); 
	
	@Query(value = "SELECT INTRANETV2.student.pk_student_id, INTRANETV2.student.login, INTRANETV2.student.password, INTRANETV2.student.name, INTRANETV2.student.fk_section_id, INTRANETV2.section.name FROM INTRANETV2.student INNER JOIN INTRANETV2.section ON INTRANETV2.student.fk_section_id = INTRANETV2.section.pk_section_id;", nativeQuery = true)
	public List<Student> getStudentListWithSectionName();
}
