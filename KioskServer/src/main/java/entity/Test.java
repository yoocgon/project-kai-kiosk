package entity;

import lombok.*;
import java.sql.Timestamp;
// import java.text.SimpleDateFormat;
import javax.persistence.*;


@Data
@Entity(name="tb_test")
public class Test {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String message;
    
    @Column
    private Timestamp create_dt;
    
    @Column
    private Timestamp update_dt;
     
    @Builder
    public Test(long id, String message, Timestamp create_dt, Timestamp update_dt) {
        this.id = id;
        this.message = message;
        this.create_dt = create_dt;
        this.update_dt = update_dt; 
    }

//	public Test(long id, String message) {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//       this.id = id;
//       this.message = message;
//       this.create_dt = timestamp;
//       this.update_dt = timestamp; 
//	}
//    
//    public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public Timestamp getCreate_dt() {
//		return create_dt;
//	}
//
//	public void setCreate_dt(Timestamp create_dt) {
//		this.create_dt = create_dt;
//	}
//
//	public Timestamp getUpdate_dt() {
//		return update_dt;
//	}
//
//	public void setUpdate_dt(Timestamp update_dt) {
//		this.update_dt = update_dt;
//	}
}
