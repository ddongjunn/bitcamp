package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.CalendarDto;

@Repository
public class CalendarDaoImpl implements CalendarDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "Cal.";

	@Override
	public List<CalendarDto> getCalendar(CalendarDto cal) {
		return session.selectList(ns + "getCalendar", cal);
	}

	@Override
	public void writeCal(CalendarDto cal) {
		session.update(ns + "writeCal", cal);
	}

	@Override
	public CalendarDto getCal(int seq) {
		return session.selectOne(ns + "getCal", seq);
	}

	@Override
	public void deleteCal(int seq) {
		session.delete(ns + "deleteCal", seq);
	}

	@Override
	public void updateCal(CalendarDto dto) {
		session.update(ns + "updateCal", dto);
	}

	@Override
	public List<CalendarDto> getDayList(String date) {
		return session.selectList(ns + "getDayList", date);
	}
	
}
