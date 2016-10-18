package org.wonny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.wonny.domain.MemberVO;
import org.wonny.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public MemberVO read(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
