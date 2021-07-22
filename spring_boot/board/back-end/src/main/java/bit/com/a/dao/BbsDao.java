package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;

@Mapper
@Repository
public interface BbsDao {

	public List<BbsDto> getAllBbsList();
	
	public BbsDto getBbs(int seq);
}
