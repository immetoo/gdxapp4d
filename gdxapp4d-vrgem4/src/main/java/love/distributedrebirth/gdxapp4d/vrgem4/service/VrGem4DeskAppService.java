package love.distributedrebirth.gdxapp4d.vrgem4.service;



import java.util.List;

import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

public interface VrGem4DeskAppService {

	List<DeskAppLauncher> getLaunchers();
	
	void registrateDeskApp(DeskAppLauncher launcher);
}
