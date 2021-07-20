package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;

public interface BbsService {
	public List<BbsDto> getBbsList();
	
	public BbsDto getBbs(int seq);
	
	public boolean writeBbs(BbsDto dto);
}
