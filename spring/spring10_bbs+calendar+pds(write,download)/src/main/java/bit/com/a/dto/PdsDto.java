package bit.com.a.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
DROP TABLE PDS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_PDS;

CREATE TABLE PDS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000),
	FILENAME VARCHAR2(50) NOT NULL,      //파일명의 크기는 여유있게 수정해야한다.
	NEWFILENAME VARCHAR2(50) NOT NULL,   //파일명의 크기는 여유있게 수정해야한다.
	READCOUNT NUMBER(8) NOT NULL,
	DOWNCOUNT NUMBER(8) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_PDS
START WITH 1 INCREMENT BY 1;

ALTER TABLE PDS
ADD CONSTRAINT FK_PDS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
*/
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PdsDto implements Serializable{

	private int seq;
	private String id;
	private String title;
	private String content;
	private String filename;		// 원본 파일명	abc.txt
	private String newfilename;		// 변환 파일명 3242423423.txt	
	private int readcount;
	private int downcount;
	private String regdate;	
	
	public PdsDto(int seq, String id, String title, String content, String filename, String newfilename, int readcount,
			int downcount, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}

	public PdsDto(String id, String title, String content, String filename, String newfilename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
	}

	
}




