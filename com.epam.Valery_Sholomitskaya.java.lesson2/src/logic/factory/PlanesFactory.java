package logic.factory;

import entity.Aircraft;
import entity.Freighter;
import entity.Plane;

public class PlanesFactory {
	private enum formsOfPlane {
		FREIGHT, AIRCRAFT
	}

	public static Plane getClassFromFactory(String id, String name, int range,
			int fuel, int stuffSeatings, int freight) {
		formsOfPlane formOfPlane = formsOfPlane.valueOf(id.toUpperCase());
		switch (formOfPlane) {
		case FREIGHT:
			return new Freighter(name, range, fuel, stuffSeatings, freight);
		case AIRCRAFT:
			throw new IllegalArgumentException("incorrect number of parameters");
		default:
			throw new EnumConstantNotPresentException(formsOfPlane.class,
					formOfPlane.name());
		}
	}

	public static Plane getClassFromFactory(String id, String name, int range,
			int fuel, int stuffSeatings, int seatings, int luggage) {
		formsOfPlane formOfPlane = formsOfPlane.valueOf(id.toUpperCase());
		switch (formOfPlane) {
		case FREIGHT:
			throw new IllegalArgumentException("incorrect number of parameters");

		case AIRCRAFT:
			return new Aircraft(name, range, fuel, stuffSeatings, seatings,
					luggage);

		default:
			throw new EnumConstantNotPresentException(formsOfPlane.class,
					formOfPlane.name());
		}
	}

}
