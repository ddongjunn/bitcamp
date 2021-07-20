package main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	JDBC
		  	Java DataBase Connectivity
		 */
		
		JdbcConnect jc = new JdbcConnect();
		//jc.getConnection();
		int count = jc.insertData("aaa", "홍길동", 15);
		if(count > 0) {
			System.out.println("추가되었습니다.");
		}
		
		boolean b = jc.userInsert("bbb", "이동준", 29);
		if(b) {
			System.out.println("성공적으로 추가되었습니다.");
		}
	}

}
