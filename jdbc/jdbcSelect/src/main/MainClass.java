package main;

import java.util.List;

import db.DBConnection;
import dto.UserDto;
import jdbc.SelectTest;

public class MainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();
		
		SelectTest st = new SelectTest();
		String id = "bbb";
		UserDto user = st.search(id);
		if(user != null) {
			System.out.println(user.toString());
		}
		
		boolean b = st.userUpdate("이동준", 18);
		if(b) {
			System.out.println("정보가 변경되었습니다.");
		}
		
		List<UserDto> list = st.getUserList();
		for(UserDto u : list) {
			System.out.println(u.toString());
		}
		
	}

}
