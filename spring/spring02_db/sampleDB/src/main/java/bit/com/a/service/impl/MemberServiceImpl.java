package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired //객체 자동생성 	DI( Dependcy(의존성) Injection(주입) ) 
	MemberDao dao;	// = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> allMember(){
		return dao.allMember();
	}
}
