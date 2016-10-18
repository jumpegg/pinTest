package org.wonny.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.wonny.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.wonny.mappers.memberMapper";
	
	@Override
	public List<MemberVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}

	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".createMember", vo);
	}

	@Override
	public MemberVO read(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", id);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateMember", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteMember", id);
	}


}
