package love.distributedrebirth.gdxapp4d.vrgem4.desktop;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;

import imgui.ImGui;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBootArgs;
import love.distributedrebirth.gdxapp4d.vrgem4.FontAwesomeIcons;
import love.distributedrebirth.gdxapp4d.vrgem4.GDXAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.GDXAppVrGem4;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.BasicConsoleApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.HebrewWalletApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.MusicPlayerApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.SystemBaseGlyphApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.SystemBasePartApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.SystemBaseUnicodePlaneApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps.Unicode4DApp;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenCredits;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenHelp;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskTopScreenMenu {
	
	private SystemWarpBootArgs bootArgs;
	private List<GDXAppLauncher> apps;
	private ImBoolean fileMinimizeSelected = new ImBoolean(false);
	private ImBoolean fileCloseSelected = new ImBoolean(false);
	private ImBoolean tosSelfSelected = new ImBoolean(false);
	
	public DeskTopScreenMenu(SystemWarpBootArgs bootArgs) {
		this.bootArgs = bootArgs; 
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
			if (ImGui.menuItem(FontAwesomeIcons.Camera + " Main reality", "", tosSelfSelected, appScreen.getDeskAppScreen().getCurrentDeskApp() != null)) {
				appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				tosSelfSelected.set(false);
			}
			for (DeskApp app: appScreen.getDeskAppScreen().getDeskApps()) {
				boolean enabled = true;
				if (appScreen.getDeskAppScreen().getCurrentDeskApp() == app) {
					enabled = false;
				}
				if (ImGui.menuItem(app.getTitle(), "", tosSelfSelected, enabled)) {
					appScreen.getDeskAppScreen().setCurrentDeskApp(app);
					tosSelfSelected.set(false);
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
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenDesktop1.class);
			}
			if (ImGui.menuItem(infix2+"Desktop2")) {
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenDesktop2.class);
			}
			if (ImGui.menuItem(infix3+"Desktop3")) {
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenDesktop3.class);
			}
			if (ImGui.menuItem(infix4+"Desktop4")) {
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenDesktop4.class);
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
					Gdx.graphics.setWindowedMode(bootArgs.getBootWindowWidth(), bootArgs.getBootWindowHeight());
				}
			} else {
				if (ImGui.menuItem(FontAwesomeIcons.FighterJet + " Full Screen")) {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			}
			
			ImGui.separator();
			if (ImGui.menuItem(FontAwesomeIcons.CreditCard + " Credits")) {
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenCredits.class);
			}
			if (ImGui.menuItem(FontAwesomeIcons.HandsHelping + " Help")) {
				GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenHelp.class);
			}
			ImGui.separator();
			if (ImGui.menuItem(FontAwesomeIcons.Trademark + " ImGui Demo")) {
//				GDXAppVrGem4.INSTANCE.showImGuiDemo.set(true);
			}
			if (ImGui.menuItem(FontAwesomeIcons.PowerOff + " Shutdown")) {
//				GDXAppVrGem4.INSTANCE.dispose();
				System.exit(0);
			}
			ImGui.endMenu();
		}
	}
}
