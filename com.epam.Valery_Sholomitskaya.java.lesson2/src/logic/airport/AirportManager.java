package logic.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logic.comparator.Comparator;
import entity.Aircraft;
import entity.Airport;
import entity.Freighter;
import entity.Plane;

public class AirportManager {
	Airport airport = new Airport();

	private List<Plane> copyAirport() {
		List<Plane> copySet = new ArrayList<Plane>();
		copySet.addAll(airport.getPlanes());
		return copySet;
	}

	private List<Plane> compareByFuel() {
		Comparator compare = new Comparator();
		return compare.compareByFuel(copyAirport());

	}

	private int totalCapacityOfFreighter() {
		int totalCapacity = 0;
		for (Plane element : airport.getPlanes()) {
			if (element.getClass() == Freighter.class) {
				totalCapacity = totalCapacity + element.getCapacity();
			}
		}
		return totalCapacity;
	}

	private int totalCapacityOfAircraft() {
		int totalCapacity = 0;
		for (Plane element : airport.getPlanes()) {
			if (element.getClass() == Aircraft.class) {
				totalCapacity = totalCapacity + element.getCapacity();
			}
		}
		return totalCapacity;
	}

	private int totalWeightOfFreighter() {
		int totalWeight = 0;
		for (Plane element : airport.getPlanes()) {
			if (element.getClass() == Freighter.class) {
				totalWeight = totalWeight + element.getWeight();
			}
		}
		return totalWeight;
	}

	private int totalWeightOfAircraft() {
		int totalWeight = 0;
		for (Plane element : airport.getPlanes()) {

			if (element.getClass() == Aircraft.class) {
				totalWeight = totalWeight + element.getWeight();
			}
		}
		return totalWeight;
	}

	// функция добавления самолета в аэропорт
	public void addPlane(Plane planeOfUser) {
		boolean result = true;
		if (airport.getPlanes().size() != 0) {
			for (Plane element : airport.getPlanes()) {
				if (planeOfUser.getName().equals(element.getName())) {
					result = false;
					throw new IllegalArgumentException(
							"such plane already exist ");
				}
			}
		} else {
			airport.addPlanes(planeOfUser);
			result = false;
		}
		if (result == true) {
			airport.addPlanes(planeOfUser);
		}
	}

	// функция сравнения самолетов по топливу
	public List<Plane> compareByRange() {
		Comparator compare = new Comparator();
		return compare.compareByRange(copyAirport());
	}

	// функция нахождения самолетов по диапазону горючего
	public List<Plane> findByFuel(int firstFuel, int lastFuel) {
		if ((firstFuel < 0) || (lastFuel < 0)) {
			throw new IllegalArgumentException(
					"boundary of fuel<0. its impossible.fuel must be more zero ");
		}
		List<Plane> ListByFuel = new ArrayList<Plane>();
		int first = 0;
		int last = 0;
		for (int i = 0; i < compareByFuel().size(); i++) {
			if (firstFuel < compareByFuel().get(0).getFuel()) {
				first = 0;
				break;
			}
			if (compareByFuel().get(i).getFuel() >= firstFuel) {
				first = i;
				break;
			}
		}
		for (int i = compareByFuel().size(); i >= 0; i--) {

			if (lastFuel > compareByFuel().get(compareByFuel().size() - 1)
					.getFuel()) {
				last = compareByFuel().size();
				break;
			}
			if (compareByFuel().get(i - 1).getFuel() <= lastFuel) {
				last = i;
				break;
			}
		}
		for (int i = first; i < last; i++) {
			ListByFuel.add(compareByFuel().get(i));
		}

		return ListByFuel;
	}

	// функция нахождения общей вместимости
	public int totalCapacity() {
		return totalCapacityOfAircraft() + totalCapacityOfFreighter();
	}

	// функция нахождения общей грузоподьемности
	public int totalWeight() {
		return totalWeightOfAircraft() + totalWeightOfFreighter();
	}

	// функция получения всех самолетов
	public List<Plane> getPlanes() {
		return Collections.unmodifiableList(airport.getPlanes());
	}

	// функция полета
	public void soundOfFlyAllPlanes() {
		for (Plane ob : airport.getPlanes()) {

			ob.soundOfFly();
		}
	}

	// функция полета грузового самолета
	public void soundOfFlyFreighterPlanes() {
		for (Plane ob : airport.getPlanes()) {
			if (ob.getClass() == Freighter.class) {
				ob.soundOfFly();
				break;
			}
		}
	}

	// функция полета пасажирского самолета
	public void soundOfFlyAircraftPlanes() {
		for (Plane ob : airport.getPlanes()) {
			if (ob.getClass() == Aircraft.class) {
				ob.soundOfFly();
				break;
			}
		}
	}
}
