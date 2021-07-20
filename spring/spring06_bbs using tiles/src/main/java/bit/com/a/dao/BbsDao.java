package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;

public interface BbsDao {

	public List<BbsDto> getBbsList();
	
	public BbsDto getBbs(int seq);
	
	public boolean writeBbs(BbsDto dto);
}
