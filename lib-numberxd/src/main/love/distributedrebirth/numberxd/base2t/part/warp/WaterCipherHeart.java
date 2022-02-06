package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterCipherHeart {
	
	private Integer bass;
	private List<WaterCipherHeartTone> heartTones;
	
	public WaterCipherHeart() {
		heartTones = new ArrayList<>();
	}
	
	public Integer getBass() {
		return bass;
	}
	
	public void setBass(Integer bass) {
		this.bass = bass;
	}
	
	public List<WaterCipherHeartTone> getHeartTones() {
		return heartTones;
	}
	
	public void addHeartTone(WaterCipherHeartTone heartTone) {
		heartTones.add(heartTone);
	}
	
	public void setHeartTones(List<WaterCipherHeartTone> heartTones) {
		this.heartTones = heartTones;
	}
}
