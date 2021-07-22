package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public boolean login(MemberDto dto) {
		return dao.login(dto);
	}
	
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}
	
	public boolean addMember(MemberDto dto) {
		int result = dao.addMember(dto);
		return result > 0;
	}
	
	//강사님
	/*
	 * public boolean getId(MemberDto dto) { int n = dao.getId(dto); return n > 0; }
	 */
}
