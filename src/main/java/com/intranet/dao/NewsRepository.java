package com.intranet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intranet.entities.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	@Query(value = "SELECT * FROM INTRANETV2.news", nativeQuery=true)
	public List<News> getActiveNewsList(); 
}
