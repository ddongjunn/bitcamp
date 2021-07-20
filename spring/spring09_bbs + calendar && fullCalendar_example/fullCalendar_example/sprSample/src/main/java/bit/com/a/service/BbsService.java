package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;

public interface BbsService {
	public List<BbsDto> getBbs();
	
	public boolean writeBbs(BbsDto dto);
	
	public BbsDto getBbsOne(int seq);
	
	public boolean updateBbs(BbsDto dto);
	
	public boolean deleteBbs(int seq);
}
