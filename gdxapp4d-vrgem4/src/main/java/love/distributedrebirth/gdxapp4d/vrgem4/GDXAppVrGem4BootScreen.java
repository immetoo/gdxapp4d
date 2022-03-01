package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GDXAppVrGem4BootScreen extends ScreenAdapter implements GDXAppVrGem4BootListener {

	private BitmapFont font;
	private SpriteBatch batch;
	private Texture backgroundImage;
	private List<String> messages = new ArrayList<>();
	
	public GDXAppVrGem4BootScreen() {
	}
	
	public void create() {
		batch = new SpriteBatch();
		backgroundImage = new Texture(Gdx.files.internal("background/temple-os.png"));
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta) {
		int textX = 40;
		int textY = Gdx.graphics.getHeight();
		int textYStep = 20;
		batch.begin();
		synchronized (messages) {
			for (String message:messages) { 
				font.draw(batch, message, textX, textY-=textYStep);
			}
			batch.draw(backgroundImage, 200, textY, Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - textY);
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
