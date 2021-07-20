package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

import bit.com.a.util.CalendarUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//투표상세문항을 넘겨받는 곳?
@Setter
@Getter
@ToString
@AllArgsConstructor
public class PollBean implements Serializable{
	
	private String id;
	private int syear;
	private int smonth;
	private int sday;
	
	private int eyear;
	private int emonth;
	private int eday;
	
	private Date sdate;
	private Date edate;
	
	private String question;
	private int itemcount;
	
	private String poll1;
	private String poll2;
	private String poll3;
	private String poll4;
	private String poll5;
	private String poll6;
	private String poll7;
	private String poll8;
	private String poll9;
	private String poll10;
	
	private String pollnum[] = new String[10];
	
	//보기 묶음
	public String[] getPollnum() {
		pollnum[0] = poll1;
		pollnum[1] = poll2;
		pollnum[2] = poll3;
		pollnum[3] = poll4;
		pollnum[4] = poll5;
		pollnum[5] = poll6;
		pollnum[6] = poll7;
		pollnum[7] = poll8;
		pollnum[8] = poll9;
		pollnum[9] = poll10;
	
		return pollnum;
	}
	
	public PollBean() {
		
	}
	
	public Date	getSdate() {
		return CalendarUtil.toDate(syear, smonth, sday);
	}
	public Date	getEdate() {
		return CalendarUtil.toDate(eyear, emonth, eday);
	}
	
}
