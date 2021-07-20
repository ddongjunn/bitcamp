package bit.com.a.service;

import bit.com.a.dto.MemberDto;

public interface MemberService {

	public int getId(MemberDto dto);
	
	public boolean addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
}
