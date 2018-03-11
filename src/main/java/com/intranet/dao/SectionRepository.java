package com.intranet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intranet.entities.Section;

public interface SectionRepository  extends JpaRepository<Section, Long> {
	@Query(value = "SELECT * FROM INTRANETV2.section;", nativeQuery=true)
	public List<Section> getSectionList(); 
	
	@Query(value = "SELECT * FROM INTRANETV2.section WHERE INTRANETV2.section.name=:sectionName LIMIT 1;", nativeQuery=true)
	public Section getSectionFromName(@Param("sectionName") String sectionName); 
}
