package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

public class VrGem4DeskAppServiceImpl implements VrGem4DeskAppService {
	
	private List<DeskAppLauncher> launchers = new ArrayList<>();
	
	@Override
	public List<DeskAppLauncher> getLaunchers() {
		return launchers;
	}
	
	@Override
	public void registrateDeskApp(DeskAppLauncher launcher) {
		launchers.add(launcher);
	}
}
