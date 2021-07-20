package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

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

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		return session.selectList(ns + "bbsList", param);
	}

	@Override
	public int getBbsCount(BbsParam param) {
		int count = session.selectOne(ns + "getBbsCount", param);
		
		return count;
	}
	
	
	
	
}
	