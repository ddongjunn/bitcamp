package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	private SqlSession session;
	private String ns = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList() {
		return session.selectList(ns + "getBbsList");
	}

	@Override
	public BbsDto getBbs(int seq) {
		return session.selectOne(ns + "getBbs", seq);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		int result = session.insert(ns + "writeBbs", dto);
		return result > 0 ;
	}

}
