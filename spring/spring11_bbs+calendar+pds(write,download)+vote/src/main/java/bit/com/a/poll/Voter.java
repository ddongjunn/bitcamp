package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*DROP TABLE VOTER
CASCADE CONSTRAINTS;

DROP SEQUENCE VOTER_SEQ;

CREATE TABLE VOTER(
   VOTERID NUMBER PRIMARY KEY,
   POLLID NUMBER NOT NULL,
   POLLSUBID NUMBER NOT NULL,
   ID VARCHAR2(50) NOT NULL,
   REGDATE DATE NOT NULL
);

CREATE SEQUENCE VOTER_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE VOTER
ADD CONSTRAINT VOTER_FK
FOREIGN KEY (POLLID)
REFERENCES POLL(POLLID);

ALTER TABLE VOTER
ADD CONSTRAINT VOTER_FK2
FOREIGN KEY (POLLSUBID)
REFERENCES POLLSUB(POLLSUBID);

ALTER TABLE VOTER
ADD CONSTRAINT VOTER_FK3
FOREIGN KEY (ID)
REFERENCES MEMBER(ID);
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//투표자 주제(질의)
public class Voter implements Serializable {
	
	private int voterid;	//sequence
	private int pollid;		//투표 질문 -> 1
	private int pollsubid;	//투표 보기 -> 2    어떤 질문에 몇번을 투표했는지 확인 가능
	private String id;		//투표한 Member
	private Date regidate;	//투표 한 날
	
	public Voter(int pollid, int pollsubid, String id) {
		super();
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
	}	
}
