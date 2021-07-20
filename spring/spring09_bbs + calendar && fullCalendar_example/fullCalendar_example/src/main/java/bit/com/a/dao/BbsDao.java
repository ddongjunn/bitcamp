package bit.com.a.dao;

import java.util.List;
import java.util.concurrent.Flow.Publisher;

import bit.com.a.dto.BbsDto;

public interface BbsDao {
	public List<BbsDto> getBbs();
	
	public boolean writeBbs(BbsDto dto);
	
	public BbsDto getBbsOne(int seq);
	
	public boolean updateBbs(BbsDto dto);
	
	public boolean deleteBbs(int seq);
}
