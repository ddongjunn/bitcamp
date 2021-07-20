package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;
	
	@Override
	public List<BbsDto> getBbsList(BbsParam param) {
		return dao.getBbsList(param);
	}
	
	@Override
	public int getBbsCount(BbsParam bbs) {
		// TODO Auto-generated method stub
		return dao.getBbsCount(bbs);
	}
	

	@Override
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return dao.writeBbs(dto);
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}


}
