package bit.com.a.util;

import java.util.Calendar;
import java.util.Date;

public class PollUtil {
	//달력의 날짜를 20210719 형식으로 만들기
	public static String stringCal(Calendar dd) {
		String s = "";
		int year = dd.get(Calendar.YEAR);
		int month = dd.get(Calendar.MONTH) + 1;
		int day = dd.get(Calendar.DATE);
		
		s = year + "" + CalendarUtil.two(month + "") + CalendarUtil.two(day + "");
		
		return s;
	}
	
	//연월일을 비교.
	//투표가 끝났는지? 알아야 한다.. 
	//오늘 > 종료일 -> 기간만료
    public static boolean isEnd(Date d) {
    	
    	//매개변수로 넘어온 날짜 (투표 종료일)
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(d);
    	
    	//오늘 날짜
    	Calendar now = Calendar.getInstance();
    	
    	//오늘날짜 > 지정된 날짜(종료일)
    	boolean b = Integer.parseInt(stringCal(now)) > Integer.parseInt(stringCal(c));
    	
    	//true 투표 불가능 / false 투표 기간이 남음 
    	return b;
    }
    
    //투표 종료의 판별
    public static String pollState(Date d) {
    	String s1 = "<div style='color:RED'>[종료]</div>";
    	String s2 = "<div style='color:BLUE'>[진행중]</div>";
    	
    	return isEnd(d)?s1:s2;
    }
}
