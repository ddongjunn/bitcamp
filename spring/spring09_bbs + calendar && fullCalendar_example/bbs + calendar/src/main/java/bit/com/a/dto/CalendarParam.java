package bit.com.a.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CalendarParam implements Serializable{
	private int year = -1; //cal.get이 0부터 시작하기 때문에 -1로 초기값 설정
	private int month = -1;
	private int day = -1;
	private int lastDay; //28 39 30 31
	private int dayOfWeek; //요일
	
	private int hour = 0;
	private int min = 0;
	
	public CalendarParam() {
		
	}
	
	public CalendarParam(int year, int month, int day, int hour, int min){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}

}
