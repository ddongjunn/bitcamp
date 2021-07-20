package bit.com.a.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberDto implements Serializable {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int auth;
}
