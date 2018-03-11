package com.intranet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intranet.entities.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

}
