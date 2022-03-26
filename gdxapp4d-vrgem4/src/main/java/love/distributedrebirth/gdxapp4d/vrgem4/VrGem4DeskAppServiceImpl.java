package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class VrGem4DeskAppServiceImpl implements VrGem4DeskAppService {
	
	private Map<DeskAppMenuSection, List<DeskAppLauncher>> menu = new HashMap<>();
	
	public List<DeskAppLauncher> getMenuSection(DeskAppMenuSection section) {
		List<DeskAppLauncher> result = menu.get(section);
		if (result == null) {
			result = new ArrayList<>();
			menu.put(section, result);
		}
		return result;
	}
	
	@Override
	public void installDeskApp(DeskAppLauncher launcher) {
		getMenuSection(launcher.getMenuSection()).add(launcher);
	}

	@Override
	public void removeDeskApp(DeskAppLauncher launcher) {
		getMenuSection(launcher.getMenuSection()).remove(launcher);
	}
}
