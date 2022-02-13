package love.distributedrebirth.gdxapp.desktop;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;

public class DeskAppScreen {

	private final String name;
	private final List<DeskApp> deskApps;
	private DeskApp currentDeskApp;
	private final List<DeskAppScreenListener> deskAppListeners;
	
	public DeskAppScreen(String name) {
		this.name = name;
		this.deskApps = new ArrayList<>();
		this.deskAppListeners = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void addDeskApp(DeskApp deskApp) {
		deskApps.add(deskApp);
		setCurrentDeskApp(deskApp);
	}
	
	public void removeDeskApp(DeskApp deskApp) {
		deskApps.remove(deskApp);
	}
	
	public List<DeskApp> getDeskApps() {
		return deskApps;
	}
	
	public DeskApp getCurrentDeskApp() {
		return currentDeskApp;
	}
	
	public void setCurrentDeskApp(DeskApp currentDeskApp) {
		this.currentDeskApp = currentDeskApp;
		for (DeskAppScreenListener listener: deskAppListeners) {
			listener.selectDeskApp(currentDeskApp);
		}
	}
	
	public void addDeskAppListener(DeskAppScreenListener listener) {
		deskAppListeners.add(listener);
	}
	
	public final void renderMenu() {
		for (DeskApp app: deskApps) {
			if (ImGui.menuItem(app.getName())) {
				//selectScreen(....class);
			}
		}
	}
	
	public final void render(float delta) {
		for (DeskApp app: deskApps) {
			DeskAppRenderer appMain = app.getContours().getContour(DeskAppContourSection.MAIN);
			if (appMain != null) {
				appMain.render();
			}
		}
		renderBackground();
	}
	
	protected void renderBackground() {
	}
}
