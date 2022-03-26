package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppVrGem4BootScreen extends ScreenAdapter implements GDXAppVrGem4BootListener {

	private final BitmapFont font;
	private SpriteBatch batch;
	private Texture backgroundImage;
	private List<String> messages = new ArrayList<>();
	
	public GDXAppVrGem4BootScreen(BitmapFont font) {
		this.font = font;
	}
	
	public void create() {
		batch = new SpriteBatch();
		backgroundImage = new Texture(Gdx.files.internal("background/gdxapp-loading.png"));
	}
	
	@Override
	public void render(float delta) {
		int textX = 40;
		int textY = Gdx.graphics.getHeight();
		int textYStep = 20;
		batch.begin();
		batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		synchronized (messages) {
			int start = 0;
			if (messages.size() > 33) {
				start = messages.size() - 33;
			}
			List<String> part = messages.subList(start, messages.size());
			for (String message:part) {
				font.draw(batch, message, textX, textY-=textYStep);
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		backgroundImage.dispose();
		font.dispose();
	}

	@Override
	public void bootLine(String message) {
		synchronized (messages) {
			messages.add(message);
		}
	}
}
