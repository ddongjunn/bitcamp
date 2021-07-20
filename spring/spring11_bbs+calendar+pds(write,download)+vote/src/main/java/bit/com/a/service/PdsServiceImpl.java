package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;

@Service
public class PdsServiceImpl implements PdsService{

	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> getPdsList() {
		return dao.getPdsList();
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		return dao.uploadPds(dto);
	}
	
}
