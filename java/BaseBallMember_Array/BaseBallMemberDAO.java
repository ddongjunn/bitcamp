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
			System.out.println("<�������>");
			System.out.println("1) ����");
			System.out.println("2) Ÿ��");
			System.out.print("�޴���ȣ �Է� -> ");
			int menuNum = scan.nextInt();

			System.out.print("�����̸� -> ");
			String name = scan.next();

			System.out.print("�������� -> ");
			int age = scan.nextInt();

			System.out.print("�������� -> ");
			int tall = scan.nextInt();

			if (menuNum == 1) {

				System.out.print("�¸�Ƚ�� -> ");
				int win = scan.nextInt();

				System.out.print("�й�Ƚ�� -> ");
				int lose = scan.nextInt();

				System.out.print("����� -> ");
				double era = scan.nextDouble();

				arrPlayer[seq] = new Pitcher(pitcherNum, name, age, tall, win, lose, era);
				pitcherNum++;
			} else if (menuNum == 2) {
				System.out.print("Ÿ�� -> ");
				int ab = scan.nextInt();

				System.out.print("��Ÿ�� -> ");
				int hits = scan.nextInt();

				System.out.print("Ÿ�� -> ");
				double avg = scan.nextDouble();

				arrPlayer[seq] = new Batter(batterNum, name, age, tall, ab, hits, avg);
			} else {
				System.out.println("�޴���ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				continue;
			}

			System.out.println(name + "������ ��ϿϷ�");
			seq++;
			break;
		}
	}
	public void select() {
		while(true) {
			System.out.println();
			System.out.println("<�����˻�>");
			System.out.print("�����̸� -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.println("���������͸� ã�� �� �����ϴ�.");
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
			System.out.println("<��������>");
			System.out.print("�����̸� -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.print("���������͸� ã�� �� �����ϴ�.");
				return;
			}

			if (arrPlayer[index] instanceof Pitcher) {
				Pitcher p = (Pitcher) arrPlayer[index];
				System.out.println("1.�¸�");
				System.out.println("2.�й�");
				System.out.println("3.�����");
				System.out.print("�޴���ȣ �Է� -> ");
				int menuNum = scan.nextInt();
				System.out.println();
				if (menuNum == 1) {
					System.out.print("�¸� -> ");
					int win = scan.nextInt();
					int oldWin = p.getWin();
					p.setWin(win);
					System.out.println("�¸�Ƚ�� " + oldWin + " -> " + win + " ����");

				} else if (menuNum == 2) {
					System.out.print("�й� -> ");
					int lose = scan.nextInt();
					int oldLose = p.getLose();
					p.setLose(lose);
					System.out.println("�й�Ƚ�� " + oldLose + " -> " + lose + "�� ����Ϸ�");

				} else if (menuNum == 3) {
					System.out.print("����� -> ");
					double era = scan.nextDouble();
					double oldEra = p.getEra();
					p.setEra(era);
					System.out.println("����� " + oldEra + " -> " + era + "�� ����Ϸ�");

				} else {
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					return;
				}
			} else {
				Batter b = (Batter) arrPlayer[index];
				System.out.println("1.Ÿ��");
				System.out.println("2.��Ÿ��");
				System.out.println("3.Ÿ��");
				System.out.print("�޴���ȣ �Է� -> ");
				int menuNum = scan.nextInt();
				System.out.println();
				if (menuNum == 1) {
					System.out.print("Ÿ�� -> ");
					int ab = scan.nextInt();
					int oldAb = b.getAb();
					b.setAb(ab);
					System.out.println("Ÿ�� " + oldAb + " -> " + ab + "�� ����Ϸ�");

				} else if (menuNum == 2) {
					System.out.print("��Ÿ�� -> ");
					int hits = scan.nextInt();
					int oldHits = b.getHits();
					b.setHits(hits);
					System.out.println("��Ÿ�� " + oldHits + " -> " + hits + "�� ����Ϸ�");

				} else if (menuNum == 3) {
					System.out.print("Ÿ�� -> ");
					double avg = scan.nextDouble();
					double oldAvg = b.getAvg();
					b.setAvg(avg);
					System.out.println("Ÿ�� " + oldAvg + " -> " + avg + "�� ����Ϸ�");
				} else {
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					return;
				}
			}
	}
	public void delete() {
			System.out.println("<��������>");
			System.out.print("�����̸� -> ");
			String name = scan.next();

			int index = search(name);

			if (index == -1) {
				System.out.println("���������͸� ã�� �� �����ϴ�.");
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

			System.out.println(name + "���� ������ ����");
	}
	public void allPrint() {
		System.out.println();
		System.out.println("<����");
		for(int i=0; i<seq; i++) {
			if(arrPlayer[i] instanceof Pitcher){
				System.out.println(arrPlayer[i].toString());
			}else{
				System.out.println(arrPlayer[i].toString());
			}
		}
	}
}
