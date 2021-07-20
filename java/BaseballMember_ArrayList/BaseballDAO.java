package bitcamp3.day08.BaseBallManageList;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballDAO {
	Scanner scan = new Scanner(System.in);
	ArrayList<HumanDTO> mList;
	int memberNum;
	
	public BaseballDAO(){
		mList = new ArrayList<HumanDTO>();
		memberNum = 1001;
	}
	public void create() {
		System.out.println();
		System.out.println("1) 타자");
		System.out.println("2) 투수");
		System.out.print("메뉴번호 입력 -> ");
		int menuNum = scan.nextInt();
		
		System.out.print("선수명 >> ");
		String name = scan.next();
		
		System.out.print("나이 >> ");
		int age = scan.nextInt();
		
		System.out.print("신장 >> ");
		double height = scan.nextDouble();
		
		if(menuNum == 1) {
			System.out.print("승리 >> ");
			int win = scan.nextInt();
			
			System.out.print("패배 >> ");
			int lose = scan.nextInt();
			
			System.out.print("방어율 >> ");
			double era = scan.nextDouble();
			
			mList.add(new PitcherDTO(memberNum, name, age, height, win, lose, era));

		}else {
			System.out.print("타수 >> ");
			int ab = scan.nextInt();
			
			System.out.print("안타수 >> ");
			int hits = scan.nextInt();
			
			System.out.print("타율 >> ");
			double avg = scan.nextDouble();
			mList.add(new PitcherDTO(memberNum+1000, name, age, height, ab, hits, avg));
		}
		memberNum++;
	}
	public void select() {
		System.out.print("검색할 선수이름 -> ");
		String name = scan.next();
		
		ArrayList<HumanDTO> nameList = new ArrayList<HumanDTO>();
		for(int i=0; i<mList.size(); i++) {
			HumanDTO hd = mList.get(i);
			if(name.equals(hd.getName())) {
				nameList.add(mList.get(i));
			}
		}
		
		if(nameList.size() == 0) {
			System.out.println("선수데이터가 없습니다.");
			return;
		}
		
		for(HumanDTO hd : nameList) {
			System.out.println(hd.toString());
		}
				
	}
	public void delete() { //중복선수 제거
		System.out.print("삭제할 선수이름 -> ");
		String name = scan.next();
		
		ArrayList<HumanDTO> sList = searchList(name);
		
		if(sList.size() == 0) {
			System.out.println("선수데이터가 없습니다.");
			return;
		}else if(sList.size() == 1) {
			for(int i=0; i<mList.size(); i++) {
				HumanDTO hd = mList.get(i);
				if(mList.get(i).equals(sList.get(0))) {
					System.out.println(hd.getName()+"선수 삭제완료");
					mList.remove(i);
				}
			}
		}else {
			for(int i=0; i<sList.size(); i++) {
				System.out.println((i+1)+")"+sList.get(i));
			}
			
			System.out.print("삭제할 선수 번호 ->");
			int index = scan.nextInt();
			
			for(int i=0; i<mList.size(); i++) {
				HumanDTO hd = mList.get(i);
				if(mList.get(i).equals(sList.get(index-1))) {
					System.out.println(index+")"+hd.getName()+"선수 삭제완료");
					mList.remove(i);
					break;
				}
			}
		}
		
	}
	
	public void update() {
		System.out.print("수정할 선수이름 -> ");
		String name = scan.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("선수데이터가 없습니다");
			return;
		}
		
		if(mList.get(index) instanceof PitcherDTO) {
			System.out.print("승리 -> ");
			int win = scan.nextInt();
			
			System.out.print("패배 -> ");
			int lose = scan.nextInt();
			
			System.out.print("방어율 -> ");
			double era = scan.nextDouble();
			
			PitcherDTO p = (PitcherDTO) mList.get(index);
			p.setWin(win);
			p.setLose(lose);
			p.setEra(era);
		}else if(mList.get(index) instanceof BatterDTO){
			System.out.print("타수 -> ");
			int ab = scan.nextInt();
			
			System.out.print("안타수 -> ");
			int hits = scan.nextInt();
			
			System.out.print("타율 -> ");
			Double avg = scan.nextDouble();
			
			BatterDTO b = (BatterDTO) mList.get(index);
			b.setAb(ab);
			b.setHits(hits);
			b.setAvg(avg);
		}
	}
	public void allPrint() {
		for(int i=0; i<mList.size(); i++) {
			System.out.println((i+1)+")"+mList.get(i));
		}
	}
	public ArrayList<HumanDTO> searchList(String name){	//delete			
		ArrayList<HumanDTO> sList = new ArrayList<HumanDTO>();
		for(int i=0; i<mList.size(); i++) {
			HumanDTO hd = mList.get(i);
			if(name.equals(hd.getName())) {
				sList.add(mList.get(i));
			}
		}
		return sList; 
	}
	public int search(String name) {
		int index = -1;	
		for(int i=0; i<mList.size(); i++) {
			HumanDTO hd = mList.get(i);
			if(hd.getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	
}
