package entity;

import logic.airport.Sound;

public class Aircraft extends Plane {
	private int seatings;// сидения
	private int luggage;// багаж

	public Aircraft(String name, int range, int fuel, int stuffSeatings,
			int seatings, int luggage) {
		super(name, range, fuel, stuffSeatings);
		if (seatings <= 0) {
			throw new IllegalArgumentException(
					"seatings <= 0. its impossible to create such plane. ");
		}
		if (luggage < 0) {
			throw new IllegalArgumentException(
					"luggage < 0. its impossible to create such plane. ");
		}
		this.setCapacity(this.getCapacity() + seatings);
		this.luggage = luggage;
		this.setWeight(luggage);

	}

	public void fly() {
		Sound.playSound("1.wav").join();
	}

	public int getSeatings() {
		return seatings;
	}

	public void setSeatings(int seatings) {
		this.seatings = seatings;
	}

	public int getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}

}
