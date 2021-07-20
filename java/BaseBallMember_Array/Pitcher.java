
public class Pitcher extends Human{
	private int win;
	private int lose;
	private double era;
	
	Pitcher(int number, String name, int age, int tall, int win, int lose, double era) {
		super(number, name, age, tall);
		this.win = win;
		this.lose = lose;
		this.era = era;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	@Override
	public String toString() {
		return super.toString()+", "+"승리=" + win + ", 패배=" + lose + ", 방어율=" + era + "]";
	}
	
	
}
