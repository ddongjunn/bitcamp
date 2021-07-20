import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountDAO ad = new AccountDAO();
		//추가
		
		//삭제
		
		//검색
			//1)연도 월 일 -> 날짜별 수입/지출 내역	-> 연도 월 일 ~ 연도 월 일
			//2)지출/수입 ->	연도 월 일			
			//3)내용 -> 데이트
		
		//수정
		
		//모든 데이터 출력
		
		//저장
		while(true) {
			ad.pln("가계부 프로그램");
			ad.pln("1.입력");
			ad.pln("2.삭제");
			ad.pln("3.검색");
			ad.pln("4.수정");
			ad.pln("5.출력");
			ad.pln("6.종료");
			ad.p("메뉴번호 -> ");
			int menuNum = scan.nextInt();
			
			switch(menuNum) {
			case 1:
				ad.insert();
				break;
			case 2:
				ad.delete();
				break;
			case 3:
				ad.pln("");
				ad.pln("1)기간별 조회");
				ad.pln("2)수입/지출 조회");
				ad.pln("3)메모 조회");
				ad.p("메뉴번호 -> ");
				int num = scan.nextInt();
				switch(num) {
					case 1:
						ad.dateSelete();
						break;
					case 2:
						ad.classifySelete();
						break;
					case 3:
						ad.memoSelete();
						break;
					default:
						ad.pln("메뉴번호를 잘못 입력하셨습니다.");
				}
				break;
			case 4:
				ad.update();
				break;
			case 5:
				ad.allPrint();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("메뉴번호를 잘못 입력하셨습니다.");
				break;
			
			}
		}
	}
}
