
public class Batter extends Human{
	private int ab;
	private int hits;
	private double avg;
	
	Batter(int number, String name, int age, int tall, int ab, int hits, double avg) {
		super(number, name, age, tall);
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
		return super.toString()+", "+"타수=" + ab + ", 안타수=" + hits + ", 타율=" + avg + "]";
	}
	
}
