package com.kai.kioskserver.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import entity.Test;


@NoRepositoryBean 
public interface TestRepository extends CrudRepository<Test, Long> {

//	List<Test> findById(long id);
//	
//	@Query("select Test from Test where id=:id")
//	List<Test> findByIdUsingSql(@Param("id") long id);
//	
//	List<Test> findByIdAndCreate_dtLessThanOrderByAgeDesc(String name, Timestamp create_dt);
}