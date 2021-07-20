package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;
	
	@Override
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}

	@Override
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return dao.writeBbs(dto);
	}

}
