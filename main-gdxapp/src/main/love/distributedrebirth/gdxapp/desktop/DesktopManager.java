package love.distributedrebirth.gdxapp.desktop;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.MBeanStoreKeyᴶᴹˣ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BaseGlyphSet", purpose = "The encoded base scripts.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum DesktopManager implements DefaultEnumInstanceᴶᴹˣ<DesktopManager,MBeanStoreKeyᴶᴹˣ>  {

	INSTANCE;
	
	private List<DesktopScreen> screens = new ArrayList<>();
	private DesktopScreen currentScreen = null;
	private final BãßBȍőnCoffinOpenʸᴰ<MBeanStoreKeyᴶᴹˣ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<MBeanStoreKeyᴶᴹˣ> GET_BBC() { return BBC; }
	
	public void BãßAddScreen(DesktopScreen screen) {
		screens.add(screen);
	}
	
	public int BãßScreensLength() {
		return screens.size();
	}
	
	public DesktopScreen BãßScreenByIndex(int index) {
		return screens.get(index);
	}
	
	public void BãßSelectScreenByIndex(int index) {
		BãßSelectScreen(BãßScreenByIndex(index));
	}
	
	public void BãßSelectScreen(DesktopScreen screen) {
		currentScreen = screen;
	}
	
	public DesktopScreen BãßCurrentScreen() {
		return currentScreen;
	}
}
