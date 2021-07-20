import java.util.Arrays;
import java.util.Scanner;

public class BaseBallMemberDAO {
	Scanner scan = new Scanner(System.in);
	private int seq;
	private int pitcherNum;
	private int batterNum;
	private Human arrPlayer[];

	public BaseBallMemberDAO(){
		seq = 0;
		pitcherNum = 1001;
		batterNum = 2001;
		arrPlayer = new Human[20];
	}
	public void create() {
		while(true) {
			System.out.println();
			System.out.println("<선수등록>");
			System.out.println("1) 투수");
			System.out.println("2) 타자");
			System.out.print("메뉴번호 입력 -> ");
			int menuNum = scan.nextInt();

			System.out.print("선수이름 -> ");
			String name = scan.next();

			System.out.print("선수나이 -> ");
			int age = scan.nextInt();

			System.out.print("선수신장 -> ");
			int tall = scan.nextInt();

			if (menuNum == 1) {

				System.out.print("승리횟수 -> ");
				int win = scan.nextInt();

				System.out.print("패배횟수 -> ");
				int lose = scan.nextInt();

				System.out.print("방어율 -> ");
				double era = scan.nextDouble();

				arrPlayer[seq] = new Pitcher(pitcherNum, name, age, tall, win, lose, era);
				pitcherNum++;
			} else if (menuNum == 2) {
				System.out.print("타수 -> ");
				int ab = scan.nextInt();

				System.out.print("안타수 -> ");
				int hits = scan.nextInt();

				System.out.print("타율 -> ");
				double avg = scan.nextDouble();

				arrPlayer[seq] = new Batter(batterNum, name, age, tall, ab, hits, avg);
			} else {
				System.out.println("메뉴번호를 잘못 입력하셨습니다.");
				continue;
			}

			System.out.println(name + "선수님 등록완료");
			seq++;
			break;
		}
	}
	public void select() {
		while(true) {
			System.out.println();
			System.out.println("<선수검색>");
			System.out.print("선수이름 -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.println("선수데이터를 찾을 수 없습니다.");
				continue;
			}

			System.out.println(arrPlayer[index].toString());
			break;
		}
	}
	public int search(String name) {	
		int index = -1;
		for(int i=0; i<seq; i++) {
			if(arrPlayer[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	public void update() {
			System.out.println();
			System.out.println("<선수수정>");
			System.out.print("선수이름 -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.print("선수데이터를 찾을 수 없습니다.");
				return;
			}

			if (arrPlayer[index] instanceof Pitcher) {
				Pitcher p = (Pitcher) arrPlayer[index];
				System.out.println("1.승리");
				System.out.println("2.패배");
				System.out.println("3.방어율");
				System.out.print("메뉴번호 입력 -> ");
				int menuNum = scan.nextInt();
				System.out.println();
				if (menuNum == 1) {
					System.out.print("승리 -> ");
					int win = scan.nextInt();
					int oldWin = p.getWin();
					p.setWin(win);
					System.out.println("승리횟수 " + oldWin + " -> " + win + " 변경");

				} else if (menuNum == 2) {
					System.out.print("패배 -> ");
					int lose = scan.nextInt();
					int oldLose = p.getLose();
					p.setLose(lose);
					System.out.println("패배횟수 " + oldLose + " -> " + lose + "로 변경완료");

				} else if (menuNum == 3) {
					System.out.print("방어율 -> ");
					double era = scan.nextDouble();
					double oldEra = p.getEra();
					p.setEra(era);
					System.out.println("방어율 " + oldEra + " -> " + era + "로 변경완료");

				} else {
					System.out.println("번호를 잘못 입력하셨습니다.");
					return;
				}
			} else {
				Batter b = (Batter) arrPlayer[index];
				System.out.println("1.타수");
				System.out.println("2.안타수");
				System.out.println("3.타율");
				System.out.print("메뉴번호 입력 -> ");
				int menuNum = scan.nextInt();
				System.out.println();
				if (menuNum == 1) {
					System.out.print("타수 -> ");
					int ab = scan.nextInt();
					int oldAb = b.getAb();
					b.setAb(ab);
					System.out.println("타수 " + oldAb + " -> " + ab + "로 변경완료");

				} else if (menuNum == 2) {
					System.out.print("안타수 -> ");
					int hits = scan.nextInt();
					int oldHits = b.getHits();
					b.setHits(hits);
					System.out.println("안타수 " + oldHits + " -> " + hits + "로 변경완료");

				} else if (menuNum == 3) {
					System.out.print("타율 -> ");
					double avg = scan.nextDouble();
					double oldAvg = b.getAvg();
					b.setAvg(avg);
					System.out.println("타율 " + oldAvg + " -> " + avg + "로 변경완료");
				} else {
					System.out.println("번호를 잘못 입력하셨습니다.");
					return;
				}
			}
	}
	public void delete() {
			System.out.println("<선수삭제>");
			System.out.print("선수이름 -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.println("선수데이터를 찾을 수 없습니다.");
				return;
			}

			arrPlayer[index].setNumber(0);
			arrPlayer[index].setName("0");
			arrPlayer[index].setAge(0);
			arrPlayer[index].setTall(0);

			if (arrPlayer[index] instanceof Pitcher) {
				Pitcher p = (Pitcher) arrPlayer[index];
				p.setWin(0);
				p.setLose(0);
				p.setEra(0);
			} else {
				Batter b = (Batter) arrPlayer[index];
				b.setAb(0);
				b.setHits(0);
				b.setAvg(0);
			}

			System.out.println(name + "선수 데이터 삭제");
	}
	public void allPrint() {
		System.out.println();
		System.out.println("<선수");
		for(int i=0; i<seq; i++) {
			if(arrPlayer[i] instanceof Pitcher){
				System.out.println(arrPlayer[i].toString());
			}else{
				System.out.println(arrPlayer[i].toString());
			}
		}
	}
}
