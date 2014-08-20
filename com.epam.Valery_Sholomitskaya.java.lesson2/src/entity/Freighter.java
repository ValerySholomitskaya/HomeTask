package entity;



import logic.airport.Sound;

public class Freighter extends Plane {

	private int freight;// груз

	public Freighter(String name, int range, int fuel, int stuffSeatings,
			int freight) {
		super(name, range, fuel, stuffSeatings);
		if (freight < 0) {
			throw new IllegalArgumentException(
					"fuel < 0. its impossible to create such plane. ");
		}
		this.setWeight(freight);
		this.freight = freight;

	}

	public void fly() {
		Sound.playSound("2.wav").join();
	}

	public int getFreight() {
		return freight;
	}

	public void setFreight(int freight) {
		this.freight = freight;
	}

}
