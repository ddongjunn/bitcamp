package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;

@Service
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired
	CalendarDao dao;

	@Override
	public List<CalendarDto> getCalendar(CalendarDto cal) {
		return dao.getCalendar(cal);
	}

	@Override
	public void writeCal(CalendarDto cal) {
		dao.writeCal(cal);
	}

	@Override
	public CalendarDto getCal(int seq) {
		return dao.getCal(seq);
	}

	@Override
	public void deleteCal(int seq) {
		dao.deleteCal(seq);
	}

	@Override
	public void updateCal(CalendarDto dto) {
		dao.updateCal(dto);
	}

	@Override
	public List<CalendarDto> getDayList(String date) {
		return dao.getDayList(date);
	}

}
