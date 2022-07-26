package com.kai.kioskserver.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kai.kioskserver.entity.Test;


 @Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
		//
		@Query(value = "SELECT * FROM db_kai_kiosk.public.tb_test", nativeQuery = true)
		public List<Test> selectAllUsingSql();
		//
		@Modifying
		@Transactional
		@Query(value = "INSERT INTO public.tb_test(message, create_dt, update_dt) VALUES(:message, now(), now())", 
				nativeQuery = true)
		public int insertAllUsingSql(@Param(value="message") String message);
}

