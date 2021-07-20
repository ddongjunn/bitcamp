package bitcamp3.day08.BaseBallManageList;


public class BatterDTO extends HumanDTO {

	private int ab;
	private int hits;
	private double avg;
	
	public BatterDTO() {
	}

	public BatterDTO(int number, String name, int age, double height, int ab, int hits, double avg) {
		super(number, name, age, height);
		this.ab = ab;
		this.hits = hits;
		this.avg = avg;
	}



	public int getAb() {
		return ab;
	}

	public void setAb(int ab) {
		this.ab = ab;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return super.toString() + ab + "-" + hits + "-" + avg;
	}
	
}
