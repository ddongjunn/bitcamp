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
		
		/* �⺻���� */
		
		// mybatis�� ���������� �о� ���δ�.
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// sqlSessionFactory ��ü�� ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		/* �⺻���� */
		
		// SqlSession ��ü�� ���
		//���� ������ �ؼ� ����ϴ� ��
		SqlSession session = factory.openSession();
		
		
		/* 
		 insert 
		 
		//MemberDto dto = new MemberDto("aaa", "111", "a1@naver.com");
		//MemberDto dto = new MemberDto("bbb", "222", "b1@naver.com");
		//MemberDto dto = new MemberDto("ccc", "333", "c1@naver.com");
		
		int count = session.insert("add", dto); //return int.. ��� �߰��� �Ǿ�����
		if(count > 0) {
			session.commit();
			System.out.println("�߰� ����");
		}else {
			session.rollback();
			System.out.println("�߰� ����");
		}
		*/
		
		
		/* 
		update 
		
		String id = "aaa";
		MemberDto dto = new MemberDto(id, "200", "admin@gmail.com");
		int count = session.update("update", dto);
		if(count > 0) {
			session.commit();
			System.out.println("���� ����");
		}else {
			session.rollback();
			System.out.println("���� ����");
		}
		*/
		
		/* delete */
		
//		String id = "bbb";
//		int count = session.delete("remove", id);
//		if(count > 0) {
//			session.commit();
//			System.out.println("���� ����");
//		}else {
//			session.rollback();
//			System.out.println("���� ����");
//		}
		
//		MemberDto dto = new MemberDto("ccc", "333", null);
//		int count = session.delete("removeObj", dto);
//		if(count > 0) {
//			session.commit();
//			System.out.println("���� ����");
//		}else {
//			session.rollback();
//			System.out.println("���� ����");
//		}
		
		/* 
		selectOne 
		
		String id = "aaa";
		MemberDto dto = session.selectOne("search", id);
		if(dto != null) {
			System.out.println("�˻� ����");
			System.out.println(dto.toString());
		}else {
			System.out.println("�˻� ����");
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
