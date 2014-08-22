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

	public abstract void soundOfFly();

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

	@Override
	public String toString() {
		return "Plane [name=" + name + ", range=" + range + ", fuel=" + fuel
				+ ", stuffSeatings=" + stuffSeatings + ", capacity=" + capacity
				+ ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + fuel;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + range;
		result = prime * result + stuffSeatings;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (capacity != other.capacity)
			return false;
		if (fuel != other.fuel)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (range != other.range)
			return false;
		if (stuffSeatings != other.stuffSeatings)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}
