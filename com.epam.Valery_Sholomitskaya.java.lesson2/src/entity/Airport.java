package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airport {
	private List<Plane> planes=new ArrayList<Plane>() ;

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}

	public List<Plane> getPlanes() {
		return Collections.unmodifiableList(planes);
	}
	
	public void addPlanes(Plane plane) {
		this.planes.add(plane);
	}

}
