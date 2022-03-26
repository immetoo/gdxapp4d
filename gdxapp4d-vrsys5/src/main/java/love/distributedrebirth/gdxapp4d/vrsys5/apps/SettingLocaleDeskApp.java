package love.distributedrebirth.gdxapp4d.vrsys5.apps;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SettingLocaleDeskApp extends AbstractDeskApp implements DeskAppRenderer {
	
	private final VrGem4LocaleService localeService;
	private ImInt selectedLocale = new ImInt();
	private String[] localeItems;
	
	public SettingLocaleDeskApp(VrGem4LocaleService localeService) {
		this.localeService = localeService;
	}
	
	public void create() {
		getContours().setTitle("Locale Settings");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
		
		List<String> bases = new ArrayList<>();
		bases.add("en");
		bases.add("hiero");
		localeItems = new String[bases.size()];
		localeItems = bases.toArray(localeItems);
		
		int selected = bases.indexOf(localeService.getTextLocaleI18n());
		if (selected != -1) {
			selectedLocale.set(selected);
		}
	}

	@Override
	public void render() {
		ImGui.text("Select the locale to use;");
		
		boolean changedLoc = ImGui.combo("TextLocale", selectedLocale, localeItems);
		if (changedLoc) {
			String newLoc = localeItems[selectedLocale.get()];
			localeService.setTextLocaleI18n(newLoc);
		}
	}
}
