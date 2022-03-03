package love.distributedrebirth.gdxapp4d.vrgem4.view;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskAppController {

	private final String name;
	private final List<DeskApp> deskApps;
	private DeskApp currentDeskApp;
	private final List<DeskAppSelectionListener> deskAppListeners;
	
	public DeskAppController(String name) {
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
		for (DeskAppSelectionListener listener: deskAppListeners) {
			listener.selectDeskApp(currentDeskApp);
		}
	}
	
	public void addDeskAppListener(DeskAppSelectionListener listener) {
		deskAppListeners.add(listener);
	}
	
	public final void renderMenu() {
		for (DeskApp app: deskApps) {
			if (ImGui.menuItem(app.getContours().getTitle())) {
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
