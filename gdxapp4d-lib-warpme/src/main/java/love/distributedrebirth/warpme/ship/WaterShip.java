package love.distributedrebirth.warpme.ship;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterShip {

	private String name;
	private String engine;
	private List<WaterShipOcean> shipOceans = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public List<WaterShipOcean> getShipOceans() {
		return shipOceans;
	}
	
	public void setShipOcean(List<WaterShipOcean> shipOceans) {
		for (WaterShipOcean shipOcean:shipOceans) {
			addShipOcean(shipOcean);
		}
	}
	
	public void addShipOcean(WaterShipOcean shipSea) {
		shipOceans.add(shipSea);
	}
}
