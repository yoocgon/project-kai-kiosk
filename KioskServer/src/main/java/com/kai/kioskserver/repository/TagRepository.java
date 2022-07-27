package com.kai.kioskserver.repository;

//
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kai.kioskserver.entity.Tag;

//
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

	//
	@Query(value = "SELECT * FROM db_kai_kiosk.public.tb_tag_history", nativeQuery = true)
	public List<Tag> selectAllUsingSql();

	//
	@Query(value = "SELECT * FROM db_kai_kiosk.public.tb_tag_history where ip_addr == :ip_addr", nativeQuery = true)
	public List<Tag> selectAllWhereIpUsingSql(@Param(value = "ip_addr") String ip_addr);

	//
	@Query(value = "TRUNCATE db_kai_kiosk.public.tb_tag_history", nativeQuery = true)
	public void truncate();
	
	//
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO public.tb_tag_history("
					+ "kiosk_id, ip_addr, device_id, device_type, contents, tag_dt, create_dt, update_dt)" 
					+ "VALUES("
					+ ":kiosk_id, :ip_addr, :device_id, :device_type, :contents, now(), now(), now())", 
					nativeQuery = true)
	public int insertUsingSql(
			@Param(value = "kiosk_id") String kiosk_id,
			@Param(value = "ip_addr") String ip_addr,
			@Param(value = "device_id") String device_id,
			@Param(value = "device_type") String device_type,
			@Param(value = "contents") String contents);
}


