
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BaseBallMemberDAO bmd = new BaseBallMemberDAO();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("== J team manage==");			
			System.out.println("1.선수추가");
			System.out.println("2.선수삭제");
			System.out.println("3.선수검색");
			System.out.println("4.선수수정");
			System.out.println("5.모든선수출력");
			System.out.println("6.프로그램종료");
			System.out.print("메뉴번호 입력 -> ");
			int menuNum = scan.nextInt();
			
			switch(menuNum) {
				case 1:
					bmd.create();
					break;
				case 2:
					bmd.delete();
					break;
				case 3:
					bmd.select();					
					break;
				case 4:
					bmd.update();
					break;
				case 5:
					bmd.allPrint();
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("메뉴번호를 잘못 입력하셨습니다.");
					break;
			}
		}
	}

}
