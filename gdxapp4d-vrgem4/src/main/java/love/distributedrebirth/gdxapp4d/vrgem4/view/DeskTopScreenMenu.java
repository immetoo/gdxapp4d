package love.distributedrebirth.gdxapp4d.vrgem4.view;

import java.util.List;

import com.badlogic.gdx.Gdx;

import imgui.ImGui;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.gdxapp4d.vrgem4.FontAwesomeIcons;
import love.distributedrebirth.gdxapp4d.vrgem4.VrGem4DeskAppServiceImpl;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenCredits;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenHelp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskTopScreenMenu {
	
	private SystemGdxBootArgs bootArgs;
	private SystemGdxTerminal terminal;
	private VrGem4DeskAppServiceImpl deskAppService;
	private ImBoolean fileMinimizeSelected = new ImBoolean(false);
	private ImBoolean fileCloseSelected = new ImBoolean(false);
	private ImBoolean tosSelfSelected = new ImBoolean(false);
	
	public DeskTopScreenMenu(SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		this.bootArgs = bootArgs; 
		this.terminal = terminal;
		this.deskAppService = deskAppService;
	}

	public void renderMenu(DeskTopScreen appScreen) {
		DeskApp deskApp = appScreen.getDeskAppController().getCurrentDeskApp();
		
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
		if (ImGui.beginMenu(deskApp.getContours().getTitle())) {;
			if (ImGui.menuItem(FontAwesomeIcons.FolderMinus + " Minimize", "", fileMinimizeSelected, deskApp != null )) {
				fileMinimizeSelected.set(false);
				if (deskApp != null) {
					appScreen.getDeskAppController().setCurrentDeskApp(null);
				}
			}
			if (ImGui.menuItem(FontAwesomeIcons.WindowClose + " Exit", "", fileCloseSelected, deskApp != null)) {
				fileCloseSelected.set(false);
				if (deskApp != null) {
					appScreen.getDeskAppController().removeDeskApp(deskApp);
					appScreen.getDeskAppController().setCurrentDeskApp(null);
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
			if (ImGui.menuItem(FontAwesomeIcons.Camera + " Main reality", "", tosSelfSelected, appScreen.getDeskAppController().getCurrentDeskApp() != null)) {
				appScreen.getDeskAppController().setCurrentDeskApp(null);
				tosSelfSelected.set(false);
			}
			for (DeskApp app: appScreen.getDeskAppController().getDeskApps()) {
				boolean enabled = true;
				if (appScreen.getDeskAppController().getCurrentDeskApp() == app) {
					enabled = false;
				}
				if (ImGui.menuItem(app.getContours().getTitle(), "", tosSelfSelected, enabled)) {
					appScreen.getDeskAppController().setCurrentDeskApp(app);
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
				terminal.selectScreen(ScreenDesktop1.class);
			}
			if (ImGui.menuItem(infix2+"Desktop2")) {
				terminal.selectScreen(ScreenDesktop2.class);
			}
			if (ImGui.menuItem(infix3+"Desktop3")) {
				terminal.selectScreen(ScreenDesktop3.class);
			}
			if (ImGui.menuItem(infix4+"Desktop4")) {
				terminal.selectScreen(ScreenDesktop4.class);
			}
			ImGui.separator();
			if (ImGui.beginMenu(FontAwesomeIcons.PlusSquare + " Start App")) {
				for (DeskAppMenuSection section: DeskAppMenuSection.values()) {
					if (section.isSystem()) {
						continue;
					}
					List<DeskAppLauncher> menu = deskAppService.getMenuSection(section);
					if (menu.isEmpty()) {
						continue;
					}
					if (ImGui.beginMenu(section.name())) {
						for (DeskAppLauncher launcher: menu) {
							if (ImGui.menuItem(launcher.getName())) {
								DeskApp controller = launcher.getLauncher().get();
								controller.create();
								appScreen.getDeskAppController().addDeskApp(controller);
							}
						}
						ImGui.endMenu();
					}
				}
				ImGui.endMenu();
			}
			if (ImGui.menuItem(FontAwesomeIcons.Terminal + " Run App")) {
			}
			ImGui.separator();
			if (Gdx.graphics.isFullscreen()) {
				if (ImGui.menuItem(FontAwesomeIcons.Wheelchair + " Window Mode")) {
					Gdx.graphics.setWindowedMode(bootArgs.getWindowWidth(), bootArgs.getWindowHeight());
				}
			} else {
				if (ImGui.menuItem(FontAwesomeIcons.FighterJet + " Full Screen")) {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			}
			
			ImGui.separator();
			List<DeskAppLauncher> menu = deskAppService.getMenuSection(DeskAppMenuSection.SYSTEM);
			if (!menu.isEmpty()) {
				if (ImGui.beginMenu(DeskAppMenuSection.SYSTEM.name())) {
					for (DeskAppLauncher launcher: menu) {
						if (ImGui.menuItem(launcher.getName())) {
							DeskApp controller = launcher.getLauncher().get();
							controller.create();
							appScreen.getDeskAppController().addDeskApp(controller);
						}
					}
					ImGui.endMenu();
				}
			}
			if (ImGui.menuItem(FontAwesomeIcons.CreditCard + " Credits")) {
				terminal.selectScreen(ScreenCredits.class);
			}
			if (ImGui.menuItem(FontAwesomeIcons.HandsHelping + " Help")) {
				terminal.selectScreen(ScreenHelp.class);
			}
			ImGui.separator();
			if (ImGui.menuItem(FontAwesomeIcons.PowerOff + " Shutdown")) {
				bootArgs.shutdown();
			}
			ImGui.endMenu();
		}
	}
}
