package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBase;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;

@Component
public class VrGem4LocaleServiceImpl implements VrGem4LocaleService {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private SystemWarpBase warpBase;
	
	private Properties properties;
	
	enum LocaleKey {
		TEXT_LOCALE,
		NUMBER10_LOCALE,
		NUMBER16_LOCALE,
		NUMBER27_LOCALE,
	}
	
	public VrGem4LocaleServiceImpl() {
		properties = new Properties();
	}
	
	private void save() {
		File propFile = new File(warpBase.getWarpshipHome(), "etc/locale.xml");
		try {
			properties.storeToXML(new FileOutputStream(propFile), "Locales", StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		
		File etcFile = new File(warpBase.getWarpshipHome(), "etc");
		if (!etcFile.exists()) {
			etcFile.mkdir();
		}
		
		File propFile = new File(warpBase.getWarpshipHome(), "etc/locale.xml");
		if (propFile.exists()) {
			try {
				properties.loadFromXML(new FileInputStream(propFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
	}
	
	@Override
	public void setTextLocaleI18n(String isoCode) {
		properties.put(LocaleKey.TEXT_LOCALE.name(), isoCode);
		save();
	}
	
	@Override
	public String getTextLocaleI18n() {
		return properties.getProperty(LocaleKey.TEXT_LOCALE.name(), "en");
	}
	
	@Override
	public Locale getTextLocale() {
		return new Locale(getTextLocaleI18n());
	}
}
