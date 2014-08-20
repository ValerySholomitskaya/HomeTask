package entity;

public abstract class Plane {

	private String name;// имя самолета
	private int range;// топливо
	private int fuel;// дальность полета
	private int stuffSeatings;//
	private int capacity;// вместимость
	private int weight;// грузоподьемность

	public Plane(String name, int range, int fuel, int stuffSeatings) {

		if (stuffSeatings < 0) {
			throw new IllegalArgumentException(
					"stuffSeatings<0. its impossible to create such plane. ");
		}
		if (range <= 0) {
			throw new IllegalArgumentException(
					"range <= 0. its impossible to create such plane. ");
		}
		if (fuel <= 0) {
			throw new IllegalArgumentException(
					"fuel <= 0. its impossible to create such plane. ");
		}
		this.name = name;
		this.stuffSeatings = stuffSeatings;
		this.range = range;
		this.fuel = fuel;
		this.capacity = stuffSeatings;
		this.weight = 0;
	}

	public abstract void fly();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getStuffSeatings() {
		return stuffSeatings;
	}

	public void setStuffSeatings(int stuffSeatings) {
		this.stuffSeatings = stuffSeatings;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
