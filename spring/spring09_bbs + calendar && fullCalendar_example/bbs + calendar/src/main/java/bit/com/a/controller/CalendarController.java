package bit.com.a.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.CalendarService;
import bit.com.a.util.CalendarUtil;

@Controller
public class CalendarController {

	@Autowired
	CalendarService service;
	
	@RequestMapping(value = "calendarlist.do", method = RequestMethod.GET)
	public String calendarlist(Model model, CalendarParam param, HttpSession session) {
		model.addAttribute("doc_title", "일정목록");
		
		Calendar cal = Calendar.getInstance();
		
		int year = param.getYear();
		int month = param.getMonth();
		int day = param.getDay();
			
		
		if(month == 0) {
			year--;
			month = 12;
		}
		else if(month == 13) {
			year++;
			month = 1;
		}
		else if(month < 0) {	// 처음 들어 온경우 여기서 날짜 셋팅..
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1; //month는 0부터 시작하니까 +1을 해준다.
			day = cal.get(Calendar.DATE);	
		}
		cal.set(year, month - 1, 1); //인스턴스 cal을 위에서 설정한 현재 날짜로 set 
		//달력이 1일부터 말일까지 다 출력되야 하니까 1부터 넣어준다. 
				
		// 요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //리스트 뿌려주기 위해서 1일.. 그달의 1일이 무슨요일인지 구하는것!
		
		// 마지막 날짜
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		param.setYear(year);
		param.setMonth(month);
		param.setDay(day);
		param.setDayOfWeek(dayOfWeek);
		param.setLastDay(lastDay);
		
		//CalendarParam(year=2021, month=7, day=14, lastDay=31, dayOfWeek=5, hour=0, min=0)
		//dayOfWeek는 그 달의 1일의 요일출력
		
		// 로그인 정보 : 로그인한 사람의 일정만 보기 위해서 
		String id = ((MemberDto)session.getAttribute("login")).getId();
		// 날짜 취득
		String yyyymm = CalendarUtil.yyyymm(param.getYear(), param.getMonth());
		
		// DB로부터 그 달의 정보를 취득
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);   
			
		List<CalendarDto> list = service.getCalendar(fcal); 
		/* ID와 yyymm으로 최근일정 5개만 가져온다.
		 * WHERE RNUM BETWEEN 1 AND 5
		 */
		
		model.addAttribute("flist", list);	// 일정목록
		model.addAttribute("cal", param);	// 날짜
		
		return "calendarlist.tiles";		
	}

	@RequestMapping(value = "calwrite.do", method = RequestMethod.GET)
	public String calwrite(Model model, CalendarParam param) {
		model.addAttribute("doc_title", "일정추가");
		
		model.addAttribute("param", param);
		
		return "calwrite.tiles";
	}
	
	@RequestMapping(value = "calwriteAf.do", method = RequestMethod.POST)
	public String calwriteAf(CalendarDto dto) {
		
		service.writeCal(dto);
		
		return "redirect:/calendarlist.do";
	}
	
	@RequestMapping(value = "caldetail.do", method = RequestMethod.GET)
	public String caldetail(Model model, int seq) {
		model.addAttribute("doc_title", "일정확인");
		
		CalendarDto dto = service.getCal(seq);
		model.addAttribute("dto", dto);
		
		return "caldetail.tiles";
	}
	
	@RequestMapping(value = "calupdate.do", method = RequestMethod.GET)
	public String calupdate(Model model, int seq) {
		model.addAttribute("doc_title", "일정수정");
		
		CalendarDto dto = service.getCal(seq);
		model.addAttribute("dto", dto);
		
		int year = Integer.parseInt(dto.getRdate().substring(0,4));
		int month = Integer.parseInt(dto.getRdate().substring(4,6));
		int day = Integer.parseInt(dto.getRdate().substring(6,8));
		int hour = Integer.parseInt(dto.getRdate().substring(8,10));
		int min = Integer.parseInt(dto.getRdate().substring(10,12));
		CalendarParam param = new CalendarParam(year, month, day, hour, min); //셋팅되어있는 날짜 보내기
		
		model.addAttribute("param", param);
		
		return "calupdate.tiles";
	}
	
	@RequestMapping(value = "calupdateAf.do", method = RequestMethod.POST)
	public String calupdateAf(CalendarDto dto) {
		
		service.updateCal(dto);
		
		return "redirect:/calendarlist.do";
	}
	
	
	@RequestMapping(value = "caldel.do", method = RequestMethod.GET)
	public String caldel(int seq) {
		
		service.deleteCal(seq);
		
		return "redirect:/calendarlist.do";
	}
	
	@RequestMapping(value = "callist.do", method = RequestMethod.GET)
	public String callist(Model model, CalendarParam param) {
		
		String title = param.getYear() + "년" + " " + param.getMonth() + "월" + " " + param.getDay() + "일";
		model.addAttribute("doc_title", title);

		String year = CalendarUtil.two(param.getYear() + "");
		String month = CalendarUtil.two(param.getMonth() + "");
		String day = CalendarUtil.two(param.getDay() + "");
		String date = year + month + day;
		
		List<CalendarDto> list = service.getDayList(date);

		model.addAttribute("list", list);
		
		return "callist.tiles";
	}
	
}












