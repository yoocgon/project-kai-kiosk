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
@Entity(name = "Tag")
@Table(name = "tb_tag_history")
public class Tag {

    @Id
    @JsonProperty("id")
    @GeneratedValue
    private Integer id;
	
	@Column(name = "kiosk_id")
	@JsonProperty("kiosk_id")
	private String kiosk_id;

	@Column(name = "ip_addr")
	@JsonProperty("ip_addr")
	private String ip_addr;

	@Column(name = "device_id")
	@JsonProperty("device_id")
	private String device_id;

	@Column(name = "device_type")
	@JsonProperty("device_type")
	private String device_type;

	@Column(name = "contents")
	@JsonProperty("contents")
	private String contents;
	
	@Column(name = "tag_dt")
	@JsonProperty("tag_dt")
	private Timestamp tag_dt;

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
