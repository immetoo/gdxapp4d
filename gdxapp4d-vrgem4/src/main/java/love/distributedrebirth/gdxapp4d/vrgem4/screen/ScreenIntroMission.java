package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Screen;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenIntroMission extends AbstractScrollScreen {
	private final String missionText = String.join("\n",
			"To a Waterfowl",
			"    -- by William Cullen Bryant --",
			" ",
			"Whither, 'midst falling dew,",
			"While glow the heavens with the last steps of day,",
			"Far, through their rosy depths, dost thou pursue",
			"Thy solitary way?",
			" ",
			"Vainly the fowler's eye",
			"Might mark thy distant flight to do thee wrong,",
			"As, darkly painted on the crimson sky,",
			"Thy figure floats along.",
			" ",
			"Seek'st thou the plashy brink",
			"Of weedy lake, or marge of river wide,",
			"Or where the rocking billows rise and sink",
			"On the chafed ocean side?",
			" ",
			"There is a Power whose care",
			"Teaches thy way along that pathless coast,--",
			"The desert and illimitable air,--",
			"Lone wandering, but not lost.",
			" ",
			"All day thy wings have fann'd",
			"At that far height, the cold thin atmosphere:",
			"Yet stoop not, weary, to the welcome land,",
			"Though the dark night is near.",
			" ",
			"And soon that toil shall end,",
			"Soon shalt thou find a summer home, and rest,",
			"And scream among thy fellows; reed shall bend",
			"Soon o'er thy sheltered nest.",
			" ",
			"Thou'rt gone, the abyss of heaven",
			"Hath swallowed up thy form; yet, on my heart",
			"Deeply hath sunk the lesson thou hast given,",
			"And shall not soon depart.",
			" ",
			"He, who, from zone to zone,",
			"Guides through the boundless sky thy certain flight,",
			"In the long way that I must tread alone,",
			"Will lead my steps aright.",
			" "
			);
	

	
	public ScreenIntroMission(SystemGdxTerminal terminal) {
		super(terminal, "background/terrydavis-nose.png");
	}
	
	@Override
	protected String getScrollText() {
		return missionText;
	}

	@Override
	protected Class<? extends Screen> getNextScreen() {
		return ScreenDesktop1.class;
	}
	
	@Override
	public void hideScroll() {
		//GDXAppVrGem4.INSTANCE.music.play(MusicSongType.BACKGROUND);
	}
}
