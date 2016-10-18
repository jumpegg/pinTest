package org.wonny.service;

import java.util.List;

import org.wonny.domain.MemberVO;

public interface MemberService {
	
	public List<MemberVO> listAll() throws Exception;

	public void create(MemberVO vo) throws Exception;
	
	public MemberVO read(Integer id) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
}
