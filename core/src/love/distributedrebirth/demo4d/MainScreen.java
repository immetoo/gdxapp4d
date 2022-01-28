package love.distributedrebirth.demo4d;

import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

public class MainScreen extends ApplicationAdapter {
	private List<String> args;
	public NativeFileChooser fileChooser;
	SpriteBatch batch;
	BitmapFont font;
	
	public MainScreen(List<String> args, NativeFileChooser fileChooser) {
		this.args = args;
		this.fileChooser = fileChooser;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		font.draw(batch, "Hello World.", 33, 33);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
