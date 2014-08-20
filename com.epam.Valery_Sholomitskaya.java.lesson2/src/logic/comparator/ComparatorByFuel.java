package logic.comparator;

import java.util.Comparator;
import entity.Plane;

public class ComparatorByFuel implements Comparator<Plane> {
	public int compare(Plane o1, Plane o2) {
		int fuel1 = o1.getFuel();
		int fuel2 = o2.getFuel();

		if (fuel1 < fuel2) {
			return -1;
		} else if (fuel1 == fuel2) {
			return 0;
		} else {
			return 1;
		}
	}
}
