package bit.com.a.dao;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	public boolean checkId(String id);
	
	public boolean addMember(MemberDto dto);
}
