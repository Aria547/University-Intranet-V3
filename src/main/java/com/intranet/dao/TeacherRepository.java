package com.intranet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intranet.entities.Teacher;;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	@Query(value = "SELECT * FROM INTRANETV2.teacher WHERE INTRANETV2.teacher.name=:teacherName LIMIT 1;", nativeQuery=true)
	public Teacher getTeacherFromName(@Param("teacherName") String teacherName); 
}
