package love.distributedrebirth.gdxapp.desktop;

import java.util.HashMap;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskAppContour {
	
	private final Map<DeskAppContourSection, DeskAppRenderer> renderers;
	
	public DeskAppContour() {
		this.renderers = new HashMap<>();
	}
	
	public void registrateContour(DeskAppContourSection section, DeskAppRenderer renderer) {
		renderers.put(section, renderer);
	}
	
	public DeskAppRenderer getContour(DeskAppContourSection section) {
		return renderers.get(section);
	}
}
