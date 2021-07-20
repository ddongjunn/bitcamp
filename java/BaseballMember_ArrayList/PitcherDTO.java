package bitcamp3.day08.BaseBallManageList;

public class PitcherDTO extends HumanDTO {

	private int win;
	private int lose;
	private double era;
	
	public PitcherDTO() {
	}

	public PitcherDTO(int number, String name, int age, double height, int win, int lose, double era) {
		super(number, name, age, height);
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
		return super.toString() + win + "-" + lose + "-" + era;
	}
}
