package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.GDXAppMainAdapter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractScrollScreen extends GDXAppMainAdapter {
	private static final int LINE_HEIGHT = 16;
	private float scrollDeltaTime = 0f;
	private String scrollText = "";
	private int scrollIndex = 0;
	private int scrollLine = LINE_HEIGHT;
	private final Texture backgroundImage;
	
	public AbstractScrollScreen(final GDXAppMain main, String background) {
		super(main);
		backgroundImage = new Texture(Gdx.files.internal(background));
	}
	
	abstract protected String getScrollText();
	
	abstract protected Class<? extends Screen> getNextScreen(GDXAppMain main);
	
	@Override
	public final void render(float delta) {
		ScreenUtils.clear(0f, 0f, 0f, 1f);
		main.batch.begin();
		main.batch.draw(backgroundImage, 0, 0, main.viewWidth, main.viewHeight);
		
		scrollDeltaTime += delta;
		if (scrollDeltaTime > 0.04f) {
			scrollDeltaTime = 0f;
			scrollLine++;
			if (scrollLine > LINE_HEIGHT && scrollIndex != -1) {
				scrollIndex = getScrollText().indexOf("\n", scrollIndex+1);
				if (scrollIndex > 0) {
					scrollText = getScrollText().substring(0, scrollIndex);
					scrollLine = 0;
				}
			}
		}
		
		int drawLine = 0;
		String[] lines = scrollText.split("\n");
		for (int i=lines.length;i>0;i--) {
			String line = lines[i-1];
			main.font.draw(main.batch, line, 100, scrollLine + (drawLine*LINE_HEIGHT));
			drawLine++;
		}
		main.batch.end();
		
		if (scrollText.length() >= 33) {
			if (scrollLine >= main.viewHeight || Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER) || Gdx.input.isKeyPressed(Keys.SPACE)) {
				main.selectScreen(getNextScreen(main));
			}
		}
	}
	
	@Override
	public final void show() {
		showScroll();
	}
	
	protected void showScroll() {
	}
	
	@Override
	public final void hide() {
		scrollText = "";
		scrollIndex = 0;
		scrollLine = LINE_HEIGHT;
		hideScroll();
	}
	
	protected void hideScroll() {
	}
	
	@Override
	public final void dispose() {
		backgroundImage.dispose();
		disposeScroll();
	}
	
	protected void disposeScroll() {
	}
}
