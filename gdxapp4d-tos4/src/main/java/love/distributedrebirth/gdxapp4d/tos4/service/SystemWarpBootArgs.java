package love.distributedrebirth.gdxapp4d.tos4.service;

import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemWarpBootArgs {

	List<String> getBootArgs();
	
	int getBootWindowWidth();
	
	int getBootWindowHeight();
	
	NativeFileChooser getFileChooser();
}
