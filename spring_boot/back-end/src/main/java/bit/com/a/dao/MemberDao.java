package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	public boolean login(MemberDto dto);
	
	public boolean idCheck(String id);
	
	public int addMember(MemberDto dto);
	
	/* 강사님 */
	// public int getId(MemberDto dto); 
}
