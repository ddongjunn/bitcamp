
public class Human {
	private int number;
	private String name;
	private int age;
	private int tall;
	
	Human(int number, String name, int age, int tall){
		this.number = number;
		this.name = name;
		this.age = age;
		this.tall = tall;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTall() {
		return tall;
	}

	public void setTall(int tall) {
		this.tall = tall;
	}

	@Override
	public String toString() {
		return this.name+"선수 상세정보"+"["+ "번호=" + number + ", 나이=" + age + ", 신장=" + tall;
	}
}
