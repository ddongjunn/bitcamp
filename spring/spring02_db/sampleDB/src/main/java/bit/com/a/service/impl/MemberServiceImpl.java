package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired //��ü �ڵ����� 	DI( Dependcy(������) Injection(����) ) 
	MemberDao dao;	// = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> allMember(){
		return dao.allMember();
	}
}
