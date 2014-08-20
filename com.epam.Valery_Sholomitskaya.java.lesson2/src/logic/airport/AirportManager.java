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

	private List<Plane> copyList() {
		List<Plane> copySet = new ArrayList<Plane>();
		copySet.addAll(airport.getPlanes());
		return copySet;
	}

	private List<Plane> compareByFuel() {
		Comparator compare = new Comparator();
		return compare.compareByFuel(copyList());

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
		return compare.compareByRange(copyList());
	}

	// функция нахождения самолетов по диапазону горючего
	public List<Plane> findByFuel(int firstFuel, int lastFuel) {
		if ((firstFuel < 0) || (lastFuel < 0)) {
			throw new IllegalArgumentException(
					"boundary of fuel<0. its impossible.fuel must be more zero ");
		}
		List<Plane> ListByFuel = new ArrayList<Plane>();
		int first = 0;
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
		for (int i = first; i < compareByFuel().size(); i++) {
			if (compareByFuel().get(i).getFuel() <= lastFuel) {
				ListByFuel.add(compareByFuel().get(i));
			}
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
	public void flyAllPlanes() {
		for (Plane ob : airport.getPlanes()) {

			ob.fly();
		}
	}

//функция полета грузового самолета	
	public void flyFreighterPlanes() {
		for (Plane ob : airport.getPlanes()) {
			if (ob.getClass() == Freighter.class){
			ob.fly();
			break;
			}
		}
	}
	
	//функция полета пасажирского самолета	
		public void flyAircraftPlanes() {
			for (Plane ob : airport.getPlanes()) {
				if (ob.getClass() == Aircraft.class){
				ob.fly();
				break;
				}
			}
		}
}
