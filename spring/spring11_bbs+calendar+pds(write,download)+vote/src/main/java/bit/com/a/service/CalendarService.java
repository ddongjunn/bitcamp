package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.CalendarDto;

public interface CalendarService {
	public List<CalendarDto> getCalendar(CalendarDto cal);
	
	public void writeCal(CalendarDto cal);
	
	public CalendarDto getCal(int seq);
	
	public void deleteCal(int seq);
	
	public void updateCal(CalendarDto dto);
	
	public List<CalendarDto> getDayList(String date);
}
