package bit.com.a.poll;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PollDaoImpl implements PollDao {

	@Autowired
	SqlSession session;
	
	String ns = "Poll.";

	@Override
	public List<PollDto> getPollAllList() {
		return session.selectList(ns + "getPollAllList");
	}

	@Override
	public int isVote(Voter voter) {
		return session.selectOne(ns + "isVote", voter); 
	}

	@Override
	public void makePoll(PollDto poll) {
		session.insert(ns + "makePoll", poll);
	}

	@Override
	public void makePollSub(PollSubDto pollsub) {
		session.insert(ns + "makePollSub", pollsub);
	}
}
