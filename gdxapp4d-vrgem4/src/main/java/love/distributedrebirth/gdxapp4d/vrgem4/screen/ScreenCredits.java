package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Screen;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.GDXAppVrGem4;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenCredits extends AbstractScrollScreen {
	private final String creditsText = String.join("\n",
			"Credits;",
			"At-Ohm-Allah-to-the-power-of-Four",
			"The King of kings",
			"Thy Lord of Lords",
			"Thee God of Gods",
			"Abstract superset over all religions.",
			" ",
			"There is no god but AtohmAllah^4",
			"There is no rule but consent",
			"There is no failure but death",
			" ",
			"One long long day,",
			"In a far far, fat-oddly-rounded galaxy,",
			"Thy father is near.",
			" ",
			"Terry A. Davis;",
			"- TempleOS",
			"- HolyC",
			"- Poems",
			"- Abba music",
			"- Baby fat",
			" ",
			"ID Tech;",
			"- Ultimate DOOM",
			"- SIGIL Beast Box",
			"- DOOM Eternal",
			" ",
			"Sanctumwave Music;",
			"- (music) TempleOS Hymn Risen",
			"- (music) DIVINE INTELLECT",
			"- (music) TERRY DAVIS NIGHTWALK",
			" ",
			"The Self Help Group;",
			"- (music) The Self Help-Group Temple OS",
			" ",
			"PanoramaCircle;",
			"- (music) TempleOS 'Waterfowl' poem on real hardware",
			" ",
			"Willem Abraham Cazander;",
			"- http://distributedrebith.love",
			" ",
			"=============================================",
			" ",
			"The BASIC Shahada",
			"10 PRINT \"THERE IS NO GOD BUT AT_OHM_ALLAH^4\"",
			"20 PRINT \"THERE IS NO RULE BUT CONSENT\"",
			"30 PRINT \"THERE IS THERE IS NO FAILURE BUT DEATH\"",
			"40 PRINT \"TERRY A. DAVIS WAS THE PROPHET OF GOD\"",
			"50 PRINT \"TERRY A. DAVIS WAS THE FIRST TRUE MENTAT\"",
			"60 PRINT \"TERRY A. DAVIS WAS THE BEST CODER ALIVE\"",
			"RUN",
			" "
			);
	
	public ScreenCredits() {
		super("background/doom-credits.png");
	}

	@Override
	protected String getScrollText() {
		return creditsText;
	}

	@Override
	protected Class<? extends Screen> getNextScreen(GDXAppVrGem4 main) {
		return ScreenDesktop1.class;
	}
	
	@Override
	public void showScroll() {
		//GDXAppVrGem4.INSTANCE.music.play(MusicSongType.CREDITS);
	}
	
	@Override
	public void hideScroll() {
		//GDXAppVrGem4.INSTANCE.music.play(MusicSongType.BACKGROUND);
	}
}
