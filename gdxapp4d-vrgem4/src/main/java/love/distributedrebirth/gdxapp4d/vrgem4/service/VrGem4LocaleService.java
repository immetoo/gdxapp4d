package love.distributedrebirth.gdxapp4d.vrgem4.service;

import java.util.Locale;

import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

public interface VrGem4LocaleService {
	
	void setTextLocaleI18n(String isoCode);
	
	String getTextLocaleI18n();
	
	Locale getTextLocale();
}
