package love.distributedrebirth.gdxapp4d.tos4.service;

import java.io.File;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.warpme.sea.WaterOcean;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemWarpSea {

	String NAME_PROPERTY = "warp.sea.name";
	
	String getWarpKey();
	
	File getWarpHome();
	
	WaterOcean getWarpSea();
}
