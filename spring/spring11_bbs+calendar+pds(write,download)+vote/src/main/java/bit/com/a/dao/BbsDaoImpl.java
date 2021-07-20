package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	private SqlSession session;
	private String ns = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		return session.selectList(ns + "getBbsList", param);
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

	@Override
	public boolean updateBbs(BbsDto dto) {
		int result = session.update(ns + "updateBbs", dto); 
		return result > 0;
	}

	@Override
	public boolean deleteBbs(int seq) {
		int result = session.delete(ns + "deleteBbs", seq);
		return result > 0;
	}

	@Override
	public int getBbsCount(BbsParam bbs) {
		return session.selectOne(ns + "getBbsCount", bbs);
	}

	@Override
	public boolean replyBbsUpdate(BbsDto bbs) {
		int result = session.update(ns + "replyBbsUpdate", bbs); 
		return result > 0 ;
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) {
		int result = session.insert(ns + "replyBbsInsert", bbs);
		return result > 0;
	}

	@Override
	public void readCount(int seq) {
		session.update(ns + "readCount", seq);
	}

}
