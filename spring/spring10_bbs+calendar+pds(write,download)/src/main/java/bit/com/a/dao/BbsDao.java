package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {

	public List<BbsDto> getBbsList(BbsParam bbs);
	
	public int getBbsCount(BbsParam bbs);
	
	public BbsDto getBbs(int seq);
	
	public boolean writeBbs(BbsDto dto);
	
	public boolean updateBbs(BbsDto dto);
	
	public boolean deleteBbs(int seq);
	
	public void readCount(int seq);
	
	public boolean replyBbsUpdate(BbsDto bbs);
	public boolean replyBbsInsert(BbsDto bbs);
	
}
