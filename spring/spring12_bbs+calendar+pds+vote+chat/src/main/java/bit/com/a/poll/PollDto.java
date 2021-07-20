package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DROP TABLE POLL
CASCADE CONSTRAINTS ;

DROP SEQUENCE POLL_SEQ;

CREATE TABLE POLL(
    POLLID NUMBER NOT NULL,
    ID VARCHAR2(50) NOT NULL,
    QUESTION VARCHAR2(1000) NOT NULL,
    SDATE DATE NOT NULL,
    EDATE DATE NOT NULL,
    ITEMCOUNT NUMBER NOT NULL,
    POLLTOTAL NUMBER NOT NULL,
    REGDATE DATE NOT NULL,
    CONSTRAINT POLL_PK PRIMARY KEY (POLLID)
);

CREATE SEQUENCE POLL_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLL
ADD CONSTRAINT POLL_FK FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
*/

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//투표 주제(질의)
public class PollDto implements Serializable{
	
	private int pollid; 		//sequence 투표 번호
	private String id; 			//투표 만든 사람
	private String question; 	//투표 질문 -> 좋아 하는 과일은?
	private Date sdate; 		//투표시작일
	private Date edate;			//투표종료일
	private Date regdate; 		//투표 만든날
	
	private int itemcount;	//보기수 -> 2 ~ 10
	private int polltotal; 	//이 투표에 투표를 한 사람 수
	
	private boolean vote;	//현재 로그인한 멤버가 이 투표에 투표를 했는지?

	//외부에서 들어오는 것들
	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}
	
	
}
