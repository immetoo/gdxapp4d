package love.distributedrebirth.unicode4d.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class UnicodePlane {

	private Map<String, UnicodePlaneBase> planes = new HashMap<>();
	
	public UnicodePlane() {
	}
	
	public UnicodePlaneBase getPlaneByName(String name) {
		return planes.get(name);
	}
	
	public  Collection<UnicodePlaneBase> getPlanes() {
		return planes.values();
	}
	
	public void setPlanes(List<UnicodePlaneBase> planes) {
		for (UnicodePlaneBase plane:planes) {
			addPlane(plane);
		}
	}
	
	public void addPlane(UnicodePlaneBase plane) { 
		this.planes.put(plane.getName(), plane);
	}
}
