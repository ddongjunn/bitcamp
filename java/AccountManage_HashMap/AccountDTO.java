public class AccountDTO {
	private String dateTime;
	private String use;		 //용도 -> 제목   :쇼핑,가방구매,과자구매...
	private String classify; 		//수입/지출
	private int	money;			//금액
	private String memo;		//메모 -> 내용(contents) (공백이여도 상관없다) 
	
	public AccountDTO(String dateTime, String use, String classify, int money, String memo) {
		super();
		this.dateTime = dateTime;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}
		
	public String getUse() {
		return use;
	}
	
	public void setUse(String use) {
		this.use = use;
	}
	
	public String getClassify() {
		return classify;
	}
	
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		if(this.memo.length() < 1) {
			return "["+classify+"] 날짜="+dateTime+" "+"용도="+use+" "+"금액="+money+"원";
		}else {
			return "["+classify+"] 날짜="+dateTime+" "+"용도="+use+" "+"금액="+money+"원"+" "+"메모="+memo;
		}

	}


	
	
	
	
}

