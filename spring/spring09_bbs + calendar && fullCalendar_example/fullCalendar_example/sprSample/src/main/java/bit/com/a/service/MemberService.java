package bit.com.a.service;

import bit.com.a.dto.MemberDto;

public interface MemberService {

	public boolean checkId(String id);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login (MemberDto dto);
}
