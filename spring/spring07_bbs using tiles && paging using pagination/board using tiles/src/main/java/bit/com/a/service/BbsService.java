package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {
	public List<BbsDto> getBbsList(BbsParam bbs);
	
	public int getBbsCount(BbsParam bbs);
	
	public BbsDto getBbs(int seq);
	
	public boolean writeBbs(BbsDto dto);
	
	public boolean updateBbs(BbsDto dto);
	
	public boolean deleteBbs(int seq);
}
