package love.distributedrebirth.gdxapp.desktop;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;

import imgui.ImGui;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.FontAwesomeIcons;
import love.distributedrebirth.gdxapp.GDXAppLauncher;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.desktop.apps.BasicConsoleApp;
import love.distributedrebirth.gdxapp.desktop.apps.HebrewWalletApp;
import love.distributedrebirth.gdxapp.desktop.apps.MusicPlayerApp;
import love.distributedrebirth.gdxapp.desktop.apps.SystemBaseGlyphApp;
import love.distributedrebirth.gdxapp.desktop.apps.SystemBasePartApp;
import love.distributedrebirth.gdxapp.desktop.apps.SystemBaseUnicodePlaneApp;
import love.distributedrebirth.gdxapp.desktop.apps.Unicode4DApp;
import love.distributedrebirth.gdxapp.screen.ScreenCredits;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp.screen.ScreenHelp;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskTopScreenMenu {
	
	private final DeskTopScreen desktop1;
	private final DeskTopScreen desktop2;
	private final DeskTopScreen desktop3;
	private final DeskTopScreen desktop4;
	private List<GDXAppLauncher> apps;
	private ImBoolean fileMinimizeSelected = new ImBoolean(false);
	private ImBoolean fileCloseSelected = new ImBoolean(false);
	
	public DeskTopScreenMenu(DeskTopScreen desktop1, DeskTopScreen desktop2,
			DeskTopScreen desktop3, DeskTopScreen desktop4) {
		this.desktop1 = desktop1;
		this.desktop2 = desktop2;
		this.desktop3 = desktop3;
		this.desktop4 = desktop4;
		
		apps = new ArrayList<>();
		apps.add(new GDXAppLauncher("Basic Console", () -> new BasicConsoleApp()));
		apps.add(new GDXAppLauncher("Sys Glyph Set", () -> new SystemBaseGlyphApp()));
		apps.add(new GDXAppLauncher("Sys Number Parts", () -> new SystemBasePartApp()));
		apps.add(new GDXAppLauncher("Sys Unicode", () -> new SystemBaseUnicodePlaneApp()));
		
		apps.add(new GDXAppLauncher("Hebrew Wallet", () -> new HebrewWalletApp()));
		apps.add(new GDXAppLauncher("Unicode4D", () -> new Unicode4DApp()));
		apps.add(new GDXAppLauncher("Music Player", () -> new MusicPlayerApp()));
	}

	public void renderMenu(DeskTopScreen appScreen) {
		DeskApp deskApp = appScreen.getDeskAppScreen().getCurrentDeskApp();
		
		ImGui.beginMainMenuBar();
		renderVRGEM4Menu(appScreen);
		renderTOS4Menu(appScreen);
		
		if (deskApp != null) {
			renderEditMenu(deskApp);
			renderFileMenu(deskApp);
			renderSelfMenu(appScreen, deskApp);
		}
		ImGui.endMainMenuBar();
	}
	
	private void renderSelfMenu(DeskTopScreen appScreen, DeskApp deskApp) {
		if (ImGui.beginMenu(deskApp.getTitle())) {;
			if (ImGui.menuItem(FontAwesomeIcons.FolderMinus + " Minimize", "", fileMinimizeSelected, deskApp != null )) {
				fileMinimizeSelected.set(false);
				if (deskApp != null) {
					appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				}
			}
			if (ImGui.menuItem(FontAwesomeIcons.WindowClose + " Exit", "", fileCloseSelected, deskApp != null)) {
				fileCloseSelected.set(false);
				if (deskApp != null) {
					appScreen.getDeskAppScreen().removeDeskApp(deskApp);
					appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				}
			}
			ImGui.endMenu();
		}
	}
	
	private void renderFileMenu(DeskApp deskApp) {
		DeskAppRenderer fileNew = deskApp.getContours().getContour(DeskAppContourSection.FILE_NEW);
		DeskAppRenderer fileClose = deskApp.getContours().getContour(DeskAppContourSection.FILE_CLOSE);
		DeskAppRenderer fileSave = deskApp.getContours().getContour(DeskAppContourSection.FILE_SAVE);
		DeskAppRenderer fileOption = deskApp.getContours().getContour(DeskAppContourSection.FILE_OPTION);
		DeskAppRenderer filePrint = deskApp.getContours().getContour(DeskAppContourSection.FILE_PRINT);
		if (fileNew == null && fileClose == null && fileSave == null && fileOption == null && filePrint == null) {
			return;
		}
		if (ImGui.beginMenu(FontAwesomeIcons.File + " File")) {
			if (fileNew != null) {
				fileNew.render();
				ImGui.separator();
			}
			if (fileClose != null) {
				fileClose.render();
				ImGui.separator();
			}
			if (fileSave != null) {
				fileSave.render();
				ImGui.separator();
			}
			if (fileOption != null) {
				fileOption.render();
				ImGui.separator();
			}
			if (filePrint != null) {
				filePrint.render();
			}
			ImGui.endMenu();
		}
	}
	
	private void renderEditMenu(DeskApp deskApp) {
		DeskAppRenderer editUndo = deskApp.getContours().getContour(DeskAppContourSection.EDIT_UNDO);
		DeskAppRenderer editCopy = deskApp.getContours().getContour(DeskAppContourSection.EDIT_COPY);
		DeskAppRenderer editSelect = deskApp.getContours().getContour(DeskAppContourSection.EDIT_SELECT);
		DeskAppRenderer editFind = deskApp.getContours().getContour(DeskAppContourSection.EDIT_FIND);
		DeskAppRenderer editOption = deskApp.getContours().getContour(DeskAppContourSection.EDIT_OPTION);
		if (editUndo != null || editCopy != null || editSelect != null || editFind != null || editOption != null) {
			boolean first = false;
			if (ImGui.beginMenu("Edit")) {
				if (editUndo != null) {
					editUndo.render();
					first = true;
				} 
				if (editCopy != null) {
					if (first) {
						ImGui.separator();
					}
					editCopy.render();
					first = true;
				}
				if (editSelect != null) {
					if (first) {
						ImGui.separator();
					}
					editSelect.render();
					first = true;
				}
				if (editFind != null) {
					if (first) {
						ImGui.separator();
					}
					editFind.render();
					first = true;
				}
				if (editOption != null) {
					if (first) {
						ImGui.separator();
					}
					editOption.render();
					first = true;
				}
				ImGui.endMenu();
			}
		}
	}
	
	private void renderTOS4Menu(DeskTopScreen appScreen) {
		if (ImGui.beginMenu("仙" + " TOS⁴")) {
			if (ImGui.menuItem(FontAwesomeIcons.Camera + " Main reality")) {
				appScreen.getDeskAppScreen().setCurrentDeskApp(null);
			}
			for (DeskApp app: appScreen.getDeskAppScreen().getDeskApps()) {
				String infix = "";
				if (appScreen.getDeskAppScreen().getCurrentDeskApp() == app) {
					infix = FontAwesomeIcons.Wrench + " ";;
				}
				if (ImGui.menuItem(infix + app.getTitle())) {
					appScreen.getDeskAppScreen().setCurrentDeskApp(app);
				}
			}
			ImGui.endMenu();
		}
	}
	
	private void renderVRGEM4Menu(DeskTopScreen appScreen) {
		if (ImGui.beginMenu("ﷲ" + " vrGEM⁴")) {
			String infix1 = "";
			String infix2 = "";
			String infix3 = "";
			String infix4 = "";
			if (appScreen instanceof ScreenDesktop1) {
				infix1 = FontAwesomeIcons.Eye + " ";
			}
			if (appScreen instanceof ScreenDesktop2) {
				infix2 = FontAwesomeIcons.Eye + " ";
			}
			if (appScreen instanceof ScreenDesktop3) {
				infix3 = FontAwesomeIcons.Eye + " ";
			}
			if (appScreen instanceof ScreenDesktop4) {
				infix4 = FontAwesomeIcons.Eye + " ";
			}
			if (ImGui.menuItem(infix1+"Desktop1")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenDesktop1.class);
			}
			if (ImGui.menuItem(infix2+"Desktop2")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenDesktop2.class);
			}
			if (ImGui.menuItem(infix3+"Desktop3")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenDesktop3.class);
			}
			if (ImGui.menuItem(infix4+"Desktop4")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenDesktop4.class);
			}
			ImGui.separator();
			if (ImGui.beginMenu(FontAwesomeIcons.PlusSquare + " Start App")) {
				for (GDXAppLauncher launcher: apps) {
					if (ImGui.menuItem(launcher.getName())) {
						appScreen.getDeskAppScreen().addDeskApp(launcher.getLauncher().get());
					}
				}
				ImGui.endMenu();
			}
			if (ImGui.menuItem(FontAwesomeIcons.Terminal + " Run App")) {
			}
			ImGui.separator();
			if (Gdx.graphics.isFullscreen()) {
				if (ImGui.menuItem(FontAwesomeIcons.Wheelchair + " Window Mode")) {
					Gdx.graphics.setWindowedMode(GDXAppMain.INSTANCE.viewWidth, GDXAppMain.INSTANCE.viewHeight);
				}
			} else {
				if (ImGui.menuItem(FontAwesomeIcons.FighterJet + " Full Screen")) {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			}
			
			ImGui.separator();
			if (ImGui.menuItem(FontAwesomeIcons.CreditCard + " Credits")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenCredits.class);
			}
			if (ImGui.menuItem(FontAwesomeIcons.HandsHelping + " Help")) {
				GDXAppMain.INSTANCE.selectScreen(ScreenHelp.class);
			}
			ImGui.separator();
			if (ImGui.menuItem(FontAwesomeIcons.Trademark + " ImGui Demo")) {
				GDXAppMain.INSTANCE.showImGuiDemo.set(true);
			}
			if (ImGui.menuItem(FontAwesomeIcons.PowerOff + " Shutdown")) {
				GDXAppMain.INSTANCE.dispose();
				System.exit(0);
			}
			ImGui.endMenu();
		}
	}
}
