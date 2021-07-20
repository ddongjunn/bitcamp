package bit.com.a.dao;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	
	public int getId(MemberDto dto);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
}
