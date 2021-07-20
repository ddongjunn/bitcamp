package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;
import oracle.net.ns.SessionAtts;

public class MainClass {

	public static void main(String[] args)throws Exception {
		
		/* 기본설정 */
		
		// mybatis에 설정파일을 읽어 들인다.
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// sqlSessionFactory 객체를 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		/* 기본설정 */
		
		// SqlSession 객체를 취득
		//실제 접근을 해서 사용하는 곳
		SqlSession session = factory.openSession();
		
		
		/* 
		 insert 
		 
		//MemberDto dto = new MemberDto("aaa", "111", "a1@naver.com");
		//MemberDto dto = new MemberDto("bbb", "222", "b1@naver.com");
		//MemberDto dto = new MemberDto("ccc", "333", "c1@naver.com");
		
		int count = session.insert("add", dto); //return int.. 몇개가 추가가 되었는지
		if(count > 0) {
			session.commit();
			System.out.println("추가 성공");
		}else {
			session.rollback();
			System.out.println("추가 실패");
		}
		*/
		
		
		/* 
		update 
		
		String id = "aaa";
		MemberDto dto = new MemberDto(id, "200", "admin@gmail.com");
		int count = session.update("update", dto);
		if(count > 0) {
			session.commit();
			System.out.println("수정 성공");
		}else {
			session.rollback();
			System.out.println("수정 실패");
		}
		*/
		
		/* delete */
		
//		String id = "bbb";
//		int count = session.delete("remove", id);
//		if(count > 0) {
//			session.commit();
//			System.out.println("삭제 성공");
//		}else {
//			session.rollback();
//			System.out.println("삭제 실패");
//		}
		
//		MemberDto dto = new MemberDto("ccc", "333", null);
//		int count = session.delete("removeObj", dto);
//		if(count > 0) {
//			session.commit();
//			System.out.println("삭제 성공");
//		}else {
//			session.rollback();
//			System.out.println("삭제 실패");
//		}
		
		/* 
		selectOne 
		
		String id = "aaa";
		MemberDto dto = session.selectOne("search", id);
		if(dto != null) {
			System.out.println("검색 성공");
			System.out.println(dto.toString());
		}else {
			System.out.println("검색 실패");
		}
		*/
		
		/*
		 select
		List<MemberDto> list = session.selectList("allData");
		for(MemberDto mem : list) {
			System.out.println(mem.toString());
		}
		*/
		
		BbsParam param = new BbsParam("content", "12");
		List<BbsDto> list = session.selectList("bbsSearch", param);
		for(BbsDto bbs : list) {
			System.out.println(bbs.toString());
		}
		
	}

}
