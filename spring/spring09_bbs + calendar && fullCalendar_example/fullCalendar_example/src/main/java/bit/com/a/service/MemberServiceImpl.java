package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired 			/* �쓽議댁꽦 二쇱엯 */
	MemberDao dao;

	@Override
	public boolean checkId(String id) {
		return dao.checkId(id);
	}

	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
}
