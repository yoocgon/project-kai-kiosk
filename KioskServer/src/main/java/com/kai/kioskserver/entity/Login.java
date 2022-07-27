package com.kai.kioskserver.entity;

import lombok.*;
import java.sql.Timestamp;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

//
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Login")
@Table(name = "tb_login_history")
public class Login {

    @Id
    @JsonProperty("id")
    @GeneratedValue
    private Integer id;
	
	@Column(name = "kiosk_id")
	@JsonProperty("kiosk_id")
	private String kiosk_id;

	@Column(name = "employee_id")
	@JsonProperty("employee_id")
	private String employee_id;

	@Column(name = "ip_addr")
	@JsonProperty("ip_addr")
	private String ip_addr;

	@Column(name = "device_id")
	@JsonProperty("device_id")
	private String device_id;

	@Column(name = "login_dt")
	@JsonProperty("create_dt")
	private Timestamp login_dt;

	@Column(name = "deleted")
	@JsonProperty("deleted")
	private Boolean deleted;

	@Column(name = "create_dt")
	@JsonProperty("create_dt")
	private Timestamp create_dt;

	@Column(name = "update_dt")
	@JsonProperty("update_dt")
	private Timestamp update_dt;

	@Column(name = "delete_dt")
	@JsonProperty("delete_dt")
	private Timestamp delete_dt;
}
