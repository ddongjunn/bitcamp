package bit.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;
	String ns = "Member.";
	
	
	@Override
	public int getId(MemberDto dto) {
		int count = session.selectOne(ns + "getId", dto.getId());
		return count;
	}


	@Override
	public boolean addMember(MemberDto dto) {
		int result = session.insert(ns + "addMember", dto);
		return result > 0;
	}


	@Override
	public MemberDto login(MemberDto dto) {
		return session.selectOne(ns + "login", dto);
	}
	
	
	
	
}
