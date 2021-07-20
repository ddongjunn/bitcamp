package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession session;
	
	String ns = "Member.";

	@Override
	public boolean checkId(String id) {
		int count = session.selectOne(ns + "checkid", id);
		return count > 0;
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
