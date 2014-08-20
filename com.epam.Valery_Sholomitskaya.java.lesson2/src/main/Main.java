package main;

import java.util.List;

import entity.Plane;
import logic.airport.AirportManager;

import logic.factory.PlanesFactory;

public class Main {
	public static void lookAllPlanes(List<Plane> planes) {
		if (planes.size() == 0) {
			System.out.println("Airport has no planes");
		} else {
			for (Plane element : planes) {
				System.out.println(element.getName());
			}
		}
	}

	public static void main(String[] args) {
		AirportManager airportManager = new AirportManager();
		Plane fr1 = PlanesFactory.getClassFromFactory("FREIGHT", "fr1", 1, 2,
				3, 4);
		Plane fr2 = PlanesFactory.getClassFromFactory("FREIGHT", "fr2", 6, 7,
				8, 9);
		Plane ar1 = PlanesFactory.getClassFromFactory("AIRCRAFT", "ar1", 10,
				11, 12, 13, 14);
		Plane ar2 = PlanesFactory.getClassFromFactory("AIRCRAFT", "ar2", 5, 6,
				7, 8, 9);
		airportManager.addPlane(fr1);
		airportManager.addPlane(ar1);
		airportManager.addPlane(fr2);
		airportManager.addPlane(ar2);
		System.out
				.println("Total Capacity = " + airportManager.totalCapacity());
		System.out.println("Total Weight = " + airportManager.totalWeight());
		System.out.println("Planes Sorted By Range: ");
		lookAllPlanes(airportManager.compareByRange());
		System.out.println("Planes lies in range by fuel: ");
		lookAllPlanes(airportManager.findByFuel(1, 13));
		airportManager.flyAllPlanes();
		airportManager.flyAircraftPlanes();
		airportManager.flyFreighterPlanes();

	}

}
