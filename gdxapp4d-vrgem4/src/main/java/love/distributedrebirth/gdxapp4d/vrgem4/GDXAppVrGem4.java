package love.distributedrebirth.gdxapp4d.vrgem4;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;


@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "GDXAppMain", purpose = "Main loop render dispatcher and bootup.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.gdxapp")
public enum GDXAppVrGem4 implements DefaultEnumInstanceᴶᴹˣ<GDXAppVrGem4,GDXAppVrGem4Keyʸᴰ> {
	
	INSTANCE;
	
	public SystemGdxTerminal terminal;
	//public MusicManager music;
	//public FontAtlas basePlane;
	private final BãßBȍőnCoffinOpenʸᴰ<GDXAppVrGem4Keyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<GDXAppVrGem4Keyʸᴰ> GET_BBC() { return BBC; }
	
	private GDXAppVrGem4() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(GDXAppVrGem4Keyʸᴰ.JMX);
	}
	
	public void init(SystemGdxTerminal terminal) {
		//music = new MusicManager();
		//music.init(false);
		
		this.terminal = terminal;
	}
}
