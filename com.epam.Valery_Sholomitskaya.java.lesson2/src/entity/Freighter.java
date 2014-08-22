package entity;

import constant.namesOfSounds;
import utils.SoundCreator;

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

	public void soundOfFly() {
		SoundCreator sound = new SoundCreator();
		sound.playSound(namesOfSounds.freighter_sound.getPath());
	}

	public int getFreight() {
		return freight;
	}

	public void setFreight(int freight) {
		this.freight = freight;
	}

	@Override
	public String toString() {
		return "Freighter [freight=" + freight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + freight;
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
		Freighter other = (Freighter) obj;
		if (freight != other.freight)
			return false;
		return true;
	}

}
