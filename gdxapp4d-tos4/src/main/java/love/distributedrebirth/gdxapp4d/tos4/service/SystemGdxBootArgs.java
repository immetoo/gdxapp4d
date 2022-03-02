package love.distributedrebirth.gdxapp4d.tos4.service;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemGdxBootArgs {
	
	boolean isWarpCoreNoLock();
	
	int getWindowWidth();
	
	int getWindowHeight();
	
	NativeFileChooser getFileChooser();
}
