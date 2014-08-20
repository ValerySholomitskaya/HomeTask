package logic.comparator;

import java.util.Collections;
import java.util.List;
import entity.Plane;

public class Comparator {

	public List<Plane> compareByRange(List<Plane> planes) {
		try {
			Collections.sort(planes, ComparatorByRange.class.newInstance());
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		}
		return planes;
	}

	public List<Plane> compareByFuel(List<Plane> planes) {
		try {
			Collections.sort(planes, ComparatorByFuel.class.newInstance());
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		}
		return planes;
	}
}
