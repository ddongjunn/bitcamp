
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BaseBallMemberDAO bmd = new BaseBallMemberDAO();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("== J team manage==");			
			System.out.println("1.�����߰�");
			System.out.println("2.��������");
			System.out.println("3.�����˻�");
			System.out.println("4.��������");
			System.out.println("5.��缱�����");
			System.out.println("6.���α׷�����");
			System.out.print("�޴���ȣ �Է� -> ");
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
					System.out.println("�޴���ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					break;
			}
		}
	}

}
