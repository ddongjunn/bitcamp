package bit.com.a.poll;

import java.util.List;

public interface PollDao {

	public List<PollDto> getPollAllList();
	public int isVote(Voter voter);
	
	public void makePoll(PollDto poll);
	public void makePollSub(PollSubDto pollsub);
	
	public PollDto getPoll(PollDto poll);
	public List<PollSubDto> getPollSubList(PollDto poll); 
	
	public void pollingVoter(Voter voter);
	public void pollingPoll(Voter voter);
	public void pollingSub(Voter voter);
}
