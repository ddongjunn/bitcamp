package bit.com.a.poll;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 DROP TABLE POLLSUB
CASCADE CONSTRAINTS;

DROP SEQUENCE POLLSUB_SEQ;

CREATE TABLE POLLSUB(
    POLLSUBID NUMBER NOT NULL,
    POLLID NUMBER NOT NULL,
    ANSWER VARCHAR2(1000) NOT NULL,
    ACOUNT NUMBER NOT NULL,
    CONSTRAINT POLLSUB_PK PRIMARY KEY(POLLSUBID)
);

CREATE SEQUENCE POLLSUB_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLLSUB
ADD CONSTRAINT POLLSUB_FK
FOREIGN KEY (POLLID)
REFERENCES POLL(POLLID);
*/

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PollSubDto implements Serializable {

	private int pollsubid;	//보기 번호
	private int pollid; 	//질문 번호 <- 외래키
	private String answer;	//보기명 <- 사과, 배, 바나나
	private int acount;		//이 보기를 선택한 사람 수

}
