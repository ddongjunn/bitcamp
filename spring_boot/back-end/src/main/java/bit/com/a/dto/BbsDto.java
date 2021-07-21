package bit.com.a.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsDto implements Serializable{
	private int seq;
	private String id;	// 작성자
	
	private int ref;	// 그룹번호
	private int step;	// 행번호
	private int depth;	// 깊이
	
	private String title;
	private String content;
	private String wdate;
	
	private int del;		// 삭제
	private int readcount;	// 조회수
	
}