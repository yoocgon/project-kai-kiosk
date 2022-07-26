package com.kai.kioskserver.repository;

//
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kai.kioskserver.entity.Login;

//
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	//
	@Query(value = "SELECT * FROM db_kai_kiosk.public.tb_login", nativeQuery = true)
	public List<Login> selectAllUsingSql();

	//
	@Query(value = "SELECT * FROM db_kai_kiosk.public.tb_login where ip_addr == :ip_addr", nativeQuery = true)
	public List<Login> selectAllWhereIpUsingSql(@Param(value = "ip_addr") String ip_addr);

	//
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO public.tb_login("
			+ "kiosk_id, employee_id, nfc_id, ip_addr, login_dt, create_dt, update_dt)" + "VALUES("
			+ ":kiosk_id, :employee_id, :nfc_id, :ip_addr, now(), now(), now())", nativeQuery = true)
	public int insertUsingSql(@Param(value = "kiosk_id") String kiosk_id,
			@Param(value = "employee_id") String employee_id, @Param(value = "nfc_id") String nfc_id,
			@Param(value = "ip_addr") String ip_addr);
}
