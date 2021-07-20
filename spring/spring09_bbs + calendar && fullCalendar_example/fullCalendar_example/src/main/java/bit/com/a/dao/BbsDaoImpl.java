package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> getBbs() {
		return session.selectList(ns + "getBbs");
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return 0 < session.insert(ns + "writeBbs", dto);
		
	
	}

	@Override
	public BbsDto getBbsOne(int seq) {
		return session.selectOne(ns + "getBbsOne", seq);
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		int count = session.update(ns + "updateBbs", dto);
		return count > 0?true:false;
		
	}

	
	@Override public boolean deleteBbs(int seq) { 
		return 0 < session.update(ns +"deleteBbs", seq); 
	}
	
	
}
	