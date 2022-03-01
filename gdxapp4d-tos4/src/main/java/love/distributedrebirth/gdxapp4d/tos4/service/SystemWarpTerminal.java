package love.distributedrebirth.gdxapp4d.tos4.service;

import com.badlogic.gdx.Screen;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemWarpTerminal {

	void registrateScreen(Screen screen);
	
	void disposeScreen(Screen screen);
	
	void selectScreen(Class<? extends Screen> screenClass);
}
