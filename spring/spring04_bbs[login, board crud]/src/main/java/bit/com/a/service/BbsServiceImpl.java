package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;

@Service
public class BbsServiceImpl  implements BbsService {

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> getBbs() {
		return dao.getBbs();
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return dao.writeBbs(dto);
	}

	@Override
	public BbsDto getBbsOne(int seq) {
		return dao.getBbsOne(seq);
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
