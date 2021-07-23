package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsList(BbsParam param){
		return dao.getBbsList(param);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n > 0;
	}
	
	public void deleteBbs(int seq) {
		dao.deleteBbs(seq);
	}
	
	public void updateBbs(BbsDto dto) {
		dao.updateBbs(dto);
	}
	
	public int countBbs(BbsParam param) {
		return dao.countBbs(param);
	}
	
	
}
