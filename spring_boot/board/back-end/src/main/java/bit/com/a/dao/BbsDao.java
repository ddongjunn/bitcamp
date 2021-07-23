package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {

	public List<BbsDto> getBbsList(BbsParam param);
	
	public BbsDto getBbs(int seq);
	
	public int writeBbs(BbsDto dto);
	
	public void deleteBbs(int seq);
	
	public void updateBbs(BbsDto dto);
	
	public int countBbs(BbsParam param);
}
