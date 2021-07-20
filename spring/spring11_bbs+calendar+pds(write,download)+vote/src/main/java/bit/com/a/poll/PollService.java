package bit.com.a.poll;

import java.util.List;

public interface PollService {
	public List<PollDto> getPollAllList(String id); 
	//왜? id? 로그인한 사람이 이미 진행한 투표는 투표를 진행하지 못하도록 막아줘야 한다.
	//투표를 했느냐 안했느냐에 따라서 다르게 결과를 줘야 한다.
	//이걸 판정해주는 변수가 PollDto의 vote 변수다.
	
	public void makePoll(PollBean pbean);
}
