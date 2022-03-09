package love.distributedrebirth.gdxapp4d.vrgem4.service;

import java.util.Locale;

public interface VrGem4LocaleService {
	
	void setTextLocaleI18n(String isoCode);
	
	String getTextLocaleI18n();
	
	Locale getTextLocale();
}
