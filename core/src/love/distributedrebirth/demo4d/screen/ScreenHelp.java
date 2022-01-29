package love.distributedrebirth.demo4d.screen;

import com.badlogic.gdx.Screen;

import love.distributedrebirth.demo4d.Demo4DMain;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class ScreenHelp extends ScrollScreenAdapter {
	private final String creditsText = String.join("\n",
			"Genesis 11",
			" ",
			"1 And the whole earth was of one language, and of one speech.",
			" ",
			"2 And it came to pass, as they journeyed from the east,",
			"   that they found a plain in the land of Shinar;",
			"   and they dwelt there.",
			" ",
			"3 And they said one to another, Go to, let us make brick,",
			"   and burn them thoroughly. And they had brick for stone,",
			"   and slime had they for mortar.",
			" ",
			"4 And they said, Go to, let us build us a city, and a tower,",
			"   whose top may reach unto heaven; and let us make us a name,",
			"   lest we be scattered abroad upon the face of the whole earth.",
			" ",
			"5 And the LORD came down to see the city and the tower,",
			"   which the children of men builded.",
			" ",
			"6 And the LORD said, Behold, the people is one,",
			"   and they have all one language; and this they begin to do:",
			"   and now nothing will be restrained from them,",
			"   which they have imagined to do.",
			" ",
			"7 Go to, let us go down, and there confound their language,",
			"   that they may not understand one another's speech.",
			" ",
			"8 So the LORD scattered them abroad from thence upon the face",
			"   of all the earth: and they left off to build the city.",
			" ",
			"9 Therefore is the name of it called Babel; because the LORD",
			"   did there confound the language of all the earth: and from",
			"   thence did the LORD scatter them abroad upon",
			"   the face of all the earth.",
			" "
			);
	
	public ScreenHelp(final Demo4DMain main) {
		super(main, "background/terrydavis-nose.png");
	}

	@Override
	protected String getScrollText() {
		return creditsText;
	}

	@Override
	protected Class<? extends Screen> getNextScreen(Demo4DMain main) {
		return ScreenDefault.class;
	}
}
