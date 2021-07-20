package bit.com.a.poll;

import java.util.List;

public interface PollDao {

	public List<PollDto> getPollAllList();
	public int isVote(Voter voter);
	
	public void makePoll(PollDto poll);
	public void makePollSub(PollSubDto pollsub);
}
