package com.kai.kioskserver.entity;

import lombok.*;
import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
import javax.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Test")
@Table(name = "tb_test")
public class Test {
	
    @Id
    @JsonProperty("id")
    @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(name="message")
	@JsonProperty("message")
    private String message;
    
    @Column(name="create_dt")
    @JsonProperty("create_dt")
    private Timestamp create_dt;
    
    @Column(name="update_dt")
    @JsonProperty("update_dt")
    private Timestamp update_dt;
//
//    @Builder
//    public Test(Integer id, String message, Timestamp create_dt, Timestamp update_dt) {
//        this.id = id;
//        this.message = message;
//        this.create_dt = create_dt;
//        this.update_dt = update_dt; 
//    }
//
//	public String toStringDefault() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
//    }
//    
//    public String toStringJson() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }    
//    
//    public String toStringMultiline() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//    }
//    
//    public String toStringNoClass() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
//    }    
//    
//    public String toStringNoFieldName() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_FIELD_NAMES_STYLE);
//    }
//    
//    public String toStringShortPrefix() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//    }    
//    
//    public String toStringSimple() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
//    }        
//    
//    @Override
//    public String toString() {
//        return String.format("[id] %d [message] %s [create_dt] %s [update_dt] %s", id, message, create_dt, update_dt);
//    }

}
