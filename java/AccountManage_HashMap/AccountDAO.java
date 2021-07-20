import java.util.*;

public class AccountDAO {
	private HashMap<Calendar, AccountDTO> map;
	private Calendar cal;
	//private DataProcess dp;
	Scanner scan = new Scanner(System.in);

	//추가
	public AccountDAO() {
		map = new HashMap<Calendar, AccountDTO>();
//		dp = new DataProcess("datas");
//		dp.createFile();
//
//		dataLoad();
	}
	public void insert() {
		pln("< 추가 >");
		p("날짜입력 -> ");
		String dateTime = scan.next();
		
		p("수입/지출 -> ");
		String classify = scan.next();
		
		p("용도 -> ");
		String use = scan.next();
		
		p("금액 -> ");
		int money = scan.nextInt();
		
		p("메모 -> ");
		scan.nextLine();
		String memo = scan.nextLine();
				
		map.put(cal = Calendar.getInstance(),new AccountDTO(dateTime, use, classify, money, memo));
		
	}
	//삭제
	public void delete() {
		pln("< 삭제 >");
		p("날짜입력 -> ");
		String dateTime = scan.nextLine();

		int index = 0;
		TreeMap<Calendar, AccountDTO> uMap = new TreeMap<Calendar, AccountDTO>();
		for( Calendar key : map.keySet() ){
			if(map.get(key).getDateTime().equals(dateTime)) {
				uMap.put(key, map.get(key));
			}
		}

		if(uMap.size() == 0) {
			System.out.println("입력하신 날짜 데이터가 없습니다.");
			return;
		}

		String[] keys = new String[uMap.size()];

		int i=0;
		for(Calendar key : uMap.keySet()) {
			//p("key="+key.get(Calendar.HOUR_OF_DAY)+"/"+key.get(Calendar.MINUTE)+"/"+key.get(Calendar.SECOND));
			pln("["+(i+1)+"] "+uMap.get(key));
			keys[i] = key.get(Calendar.DATE)+"/"+key.get(Calendar.HOUR_OF_DAY)+"/"+key.get(Calendar.MINUTE)+"/"+key.get(Calendar.SECOND); //시,분,초,일 키값 저장
			i++;
		}

		p("삭제할 데이터 번호 -> ");
		int deleteNum = scan.nextInt();

		if(deleteNum > i+1) {
			pln("번호 범위를 잘못입력하셨습니다.");
			return;
		}

		String keyCompare[] = keys[deleteNum-1].split("/");

		for(Calendar key : map.keySet()) {
			if(key.get(Calendar.DATE)==Integer.parseInt(keyCompare[0]) && key.get(Calendar.HOUR_OF_DAY)==Integer.parseInt(keyCompare[1])
					&& key.get(Calendar.MINUTE)==Integer.parseInt(keyCompare[2]) && key.get(Calendar.SECOND)==Integer.parseInt(keyCompare[3])) {
				map.remove(key);
				break;
			}
		}
		pln("데이터 삭제 완료");
		pln("");
	}
	public void dateSelete() { //1)연도 월 일 -> 날짜별 수입/지출 내역	-> 연도 월 일 ~ 연도 월 일
		pln("< 기간별 검색 >");
		p("시작 날짜 -> ");
		String firstDateTime = scan.next();
		int startDate = dateToInt(firstDateTime);

		p("마지막 날짜 -> ");
		String lastDateTime = scan.next();
		int endDate = dateToInt(lastDateTime);

		TreeMap<Integer, AccountDTO> dateSortMap = new TreeMap<Integer, AccountDTO>();
		for( Calendar key : map.keySet() ){
			int valueDate = dateToInt(map.get(key).getDateTime());
           if(startDate <= valueDate && endDate >= valueDate ){
           	dateSortMap.put(valueDate, map.get(key));
		   }
        }
		if(dateSortMap.isEmpty()){
			pln("해당 데이터가 없습니다.");
			pln("");
			return;
		}
		pln("");

		int index = 1;
		for( Integer i : dateSortMap.keySet()){
			pln(index+") "+dateSortMap.get(i));
			index++;
		}
		pln("");
	}
	public void classifySelete() { //2)지출/수입 ->	연도 월 일	
		pln("< 지출/수입 검색 >");
		p("지출/수입 입력 -> ");
		String classify = scan.next();
		
		p("날짜입력 -> ");
		String dateTime = scan.next();
		
		int index = 0;
		for( Calendar key : map.keySet() ){
			System.out.println(map.get(key).getUse());
           if(map.get(key).getClassify().equals(classify) && map.get(key).getDateTime().contains(dateTime)) {
			   pln((index + 1) + ") " + map.get(key).toString());
			   index++;
		   }
        }
		pln("");
		if(index < 1){
			pln("해당 데이터가 없습니다.");
			pln("");
			return;
		}
	}
	public void memoSelete() { //3)내용 -> 데이트
		pln("");
		pln("< 메모검색 >");
		p("메모 -> ");
		String memo = scan.next();
		int index = 0;

		for( Calendar key : map.keySet() ){
            if(map.get(key).getMemo().contains(memo)){
            	pln((index+1)+") "+map.get(key).toString());
            	index++;
            }
        }
		pln("");
		if(index < 1){
			pln("해당 데이터가 없습니다.");
			pln("");
			return;
		}
	}
	public void update() {
		pln("< 수정 >");
		p("날짜입력 -> ");
		String dateTime = scan.nextLine();
		
		int index = 0;
		TreeMap<Calendar, AccountDTO> uMap = new TreeMap<Calendar, AccountDTO>();
		for( Calendar key : map.keySet() ){
            if(map.get(key).getDateTime().equals(dateTime)) {
            	uMap.put(key, map.get(key));
            }
        }
		
		if(uMap.size() == 0) {
			System.out.println("입력하신 날짜 데이터가 없습니다.");
			return;
		}
		
		String[] keys = new String[uMap.size()];
		
		int i=0;
		for(Calendar key : uMap.keySet()) {
			//p("key="+key.get(Calendar.HOUR_OF_DAY)+"/"+key.get(Calendar.MINUTE)+"/"+key.get(Calendar.SECOND));
			pln("["+(i+1)+"] "+uMap.get(key));
			keys[i] = key.get(Calendar.DATE)+"/"+key.get(Calendar.HOUR_OF_DAY)+"/"+key.get(Calendar.MINUTE)+"/"+key.get(Calendar.SECOND); //시,분,초,일 키값 저장
			i++;
		}
		
		p("수정할 데이터 번호 -> ");
		int updateNum = scan.nextInt();
		
		if(updateNum > i+1) {
			pln("index 범위를 잘못입력하셨습니다.");
			return;
		}
			
		pln("");
		pln("1)용도");
		pln("2)금액");
		p("메뉴번호 -> ");
		int menuNum = scan.nextInt();
		
		String keyCompare[] = keys[updateNum-1].split("/");
		
		for(Calendar key : map.keySet()) {
			if(key.get(Calendar.DATE)==Integer.parseInt(keyCompare[0]) && key.get(Calendar.HOUR_OF_DAY)==Integer.parseInt(keyCompare[1]) 
			   && key.get(Calendar.MINUTE)==Integer.parseInt(keyCompare[2]) && key.get(Calendar.SECOND)==Integer.parseInt(keyCompare[3])) {
				if(menuNum == 1) {
					p("용도 -> ");
					String use = scan.next();
					String nowDateTime = map.get(key).getDateTime();
					String nowClassify = map.get(key).getClassify();
					int nowMoney = map.get(key).getMoney();
					String nowMemo = map.get(key).getMemo();
					map.put(key, new AccountDTO(nowDateTime, use, nowClassify, nowMoney, nowMemo));
					break;
				}else if(menuNum == 2) {
					p("금액 -> ");
					int money = scan.nextInt();
					String nowUse = map.get(key).getUse();
					String nowDateTime = map.get(key).getDateTime();
					String nowClassify = map.get(key).getClassify();
					String nowMemo = map.get(key).getMemo();
					map.put(key, new AccountDTO(nowDateTime, nowUse, nowClassify, money, nowMemo));
					break;
				}
			}
		}
		pln("데이터 수정 완료");
		pln("");
						
	}
	public void allPrint() {
		TreeMap<Integer, AccountDTO> sortMap = new TreeMap<Integer, AccountDTO>();
		int valueDate = 0;
		for( Calendar key : map.keySet() ){
				valueDate = dateToInt(map.get(key).getDateTime());
				sortMap.put(valueDate, map.get(key));
		}

		Iterator<Integer> itKey = sortMap.keySet().iterator();
		while(itKey.hasNext()) {
			Integer i = itKey.next();
			AccountDTO val = sortMap.get(i);
			System.out.println(val);
		}
	}
	
	public void pln(String str) {
		System.out.println(str);
	}
	public void p(String str) {
		System.out.print(str);
	}
	public int dateToInt(String dateTime){
		String dt[] = dateTime.split("/");
		String date = dt[0]+dt[1]+dt[2];
		int dateI = Integer.parseInt(date);
		return dateI;
	}
//	public void dataSave(){
//		if(map.isEmpty()){
//			System.out.println("저장할 데이터가 없습니다.");
//			return;
//		}
//
//		String datas[] = new String[map.size()];
//
//		int i = 0;
//		for(Calendar key : map.keySet()) {
//			datas[i] = map.keySet().toString()+";"+map.get(key).getDateTime()+"-"+
//												   map.get(key).getUse()+"-"+
//												   map.get(key).getClassify()+"-"+
//												   map.get(key).getMoney()+"-"+
//												   map.get(key).getMemo();
//			i++;
//		}
//		dp.fileSave(datas);
//	}
//	public void dataLoad(){
//		String datas[] = dp.fileLoad();
//		for(int i = 0; i<datas.length; i++){
//			String kv[] = datas[i].split(";");
//			String value[] = kv[1].split("-");
//			AccountDTO ad = new AccountDTO(value[0],value[1],value[2],Integer.parseInt(value[3]),value[4]);
//
//			map.put(kv[0],ad);
//		}
//	}

}
