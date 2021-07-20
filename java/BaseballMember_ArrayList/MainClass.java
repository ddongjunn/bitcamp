package bitcamp3.day08.BaseBallManageList;

import java.util.Scanner;


public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BaseballDAO dao = new BaseballDAO();
		
		while(true) {
			System.out.println("메뉴 >>>>>>>>>>>>>>>");		
			System.out.println("1. 선수추가");
			System.out.println("2. 선수삭제");
			System.out.println("3. 선수검색");
			System.out.println("4. 선수수정");
			System.out.println("5. 선수모두출력");
			System.out.println("6. 저장하기");
						
			System.out.print("입력 >> ");
			int number = sc.nextInt();
						
			switch( number ) {
				case 1:
					dao.create();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allPrint();
					break;
				case 6:
					
					break;
			}
		}		
	}
}