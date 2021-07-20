package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {
	public List<BbsDto> getBbsList(BbsParam param);
	public int getBbsCount(BbsParam param); 
	
	public boolean writeBbs(BbsDto dto);
	
	public BbsDto getBbsOne(int seq);
	
	public boolean updateBbs(BbsDto dto);
	
	public boolean deleteBbs(int seq);
}
