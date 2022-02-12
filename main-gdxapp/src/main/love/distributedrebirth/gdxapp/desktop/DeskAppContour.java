package love.distributedrebirth.gdxapp.desktop;

import java.util.HashMap;
import java.util.Map;

public class DeskAppContour {
	
	private final String appName;
	private final Map<DeskAppContourSection, DeskAppRenderer> renderers;
	
	public DeskAppContour(String appName) {
		this.appName = appName;
		this.renderers = new HashMap<>();
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void registrateContour(DeskAppContourSection section, DeskAppRenderer renderer) {
		renderers.put(section, renderer);
	}
	
	public DeskAppRenderer getContour(DeskAppContourSection section) {
		return renderers.get(section);
	}
}
