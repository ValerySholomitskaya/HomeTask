package entity;

import constant.namesOfSounds;
import utils.SoundCreator;

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

	public void soundOfFly() {
		SoundCreator sound = new SoundCreator();
		sound.playSound(namesOfSounds.aircraft_sound.getPath());
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

	@Override
	public String toString() {
		return "Aircraft [seatings=" + seatings + ", luggage=" + luggage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + luggage;
		result = prime * result + seatings;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aircraft other = (Aircraft) obj;
		if (luggage != other.luggage)
			return false;
		if (seatings != other.seatings)
			return false;
		return true;
	}

}
