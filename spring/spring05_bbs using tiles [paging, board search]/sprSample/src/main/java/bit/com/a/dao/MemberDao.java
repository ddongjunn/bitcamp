package bit.com.a.dao;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	public boolean checkId(String id);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto); //세션에 넣어줘야 하기 때문에 MemberDto로 리턴
}
