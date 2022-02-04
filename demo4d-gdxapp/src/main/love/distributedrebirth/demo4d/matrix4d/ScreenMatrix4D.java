package love.distributedrebirth.demo4d.matrix4d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.Demo4DMainAdapter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenMatrix4D extends Demo4DMainAdapter {
	public Environment environment;
	public PerspectiveCamera cam;
	public CameraInputController camController;
	public Shader shader;
	public ModelBatch modelBatch;
	private Model grid;
	private Model model;
	public Array<ModelInstance> modelInstances = new Array<ModelInstance>();
	//endregion

	//region Text rendering
	public BitmapFont font;
	public BitmapFontCache fontCache;

	public final ScreenViewport uiViewport = new ScreenViewport();
	public SpriteBatch spriteBatch;

	/** World-space position of the text. (Corner of the cube.) */
	public Vector3 textPosition = new Vector3(2.5f, 2.5f, 2.5f);
	//endregion
	
	private float colorDeltaTime = 0f;
	private float colorFade = 0f;
	private boolean colorPositive = true;
	
	public ScreenMatrix4D(final Demo4DMain main) {
		super(main);
		this.create();
	}
	
	private void create() {
		//region 3D Objects
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();

		ModelBuilder modelBuilder = new ModelBuilder();
		
		Material mat = new Material(ColorAttribute.createDiffuse(1f,1f,1f,.1f));
		grid = modelBuilder.createLineGrid(33, 33, 1f, 1f, mat, Usage.Position | Usage.Normal);
		
		model = modelBuilder.createBox(.3f, .3f, .3f,
				new Material(ColorAttribute.createDiffuse(.1f,.1f,.1f,.1f),
						new BlendingAttribute(.1f)
				//new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
						),
				Usage.Position | Usage.Normal);
		
		//Matrix4 model1Offset = new Matrix4(new Vector3(5f,0f,0f), new Quaternion(0f,0f,0f,0f),new Vector3(1f,1f,1f));
		
		Attribute bend = new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		for (int x = -4; x < 6; x++) {
			for (int y = 1; y < 11; y++) {
				for (int z = -4; z < 7; z++) {
					ModelInstance instance = new ModelInstance(model, x, y, z);
					instance.materials.get(0).set(bend);
					modelInstances.add(instance);
				}
			}
		}
		
		ModelInstance instance = new ModelInstance(grid, 0, 0, 0);
		//instance.materials.get(0).set(bend);
		modelInstances.add(instance);
		
		shader = new UserColorShader();
		shader.init();

		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
		//endregion

		//region Text rendering
		font = new BitmapFont();
		fontCache = new BitmapFontCache(font, false);
		spriteBatch = new SpriteBatch();
		//endregion
	}
	
	/**
	 * Multiply 4x4 matrix {@code m} and 4D vector {$code (v, vW)} together.
	 * Store result {@code (x/w, y/w, z/w)} back in {@code v} and return {@code w}.
	 */
	private static float multiplyProjective(Matrix4 m, Vector3 v, float vW) {
		final float[] mat = m.val;
		final float x = v.x * mat[Matrix4.M00] + v.y * mat[Matrix4.M01] + v.z * mat[Matrix4.M02] + vW * mat[Matrix4.M03];
		final float y = v.x * mat[Matrix4.M10] + v.y * mat[Matrix4.M11] + v.z * mat[Matrix4.M12] + vW * mat[Matrix4.M13];
		final float z = v.x * mat[Matrix4.M20] + v.y * mat[Matrix4.M21] + v.z * mat[Matrix4.M22] + vW * mat[Matrix4.M23];
		final float w = v.x * mat[Matrix4.M30] + v.y * mat[Matrix4.M31] + v.z * mat[Matrix4.M32] + vW * mat[Matrix4.M33];
		final float iw = 1f / w;
		v.set(x * iw, y * iw, z * iw);
		return w;
	}
	
	@Override
	public void render(float delta) {
		colorDeltaTime += delta;
		if (colorDeltaTime > 0.04f) {
			colorDeltaTime = 0f;
			if (colorPositive) {
				colorFade += delta;
			} else {
				colorFade -= delta;
			}
			if (colorFade > 1f) {
				colorPositive = false;
			} else if (colorFade < .5f) {
				colorPositive = true;
			}
		}
		
		int i=0;
		for (int x = -4; x < 6; x++) {
			for (int y = 1; y < 11; y++) {
				for (int z = -4; z < 7; z++) {
					float red = .1f;
					float green = (y+2f)/10f*colorFade;
					float blue = .1f;
					if (x == 3 || y == 1 || z == -1) {
						red = (y+2f)/10f*colorFade;
						green = 0f;
					}
					if (x == -1 || y == 10 || z == 5) {
						green = 0f;
						blue = (y+2f)/10f*colorFade;
					}
					
					ModelInstance instance = modelInstances.get(i++);
					ColorAttribute attr = ColorAttribute.createDiffuse(red, green, blue, .2f);
					instance.materials.get(0).set(attr);
				}
			}
		}
		
		//region 3D Objects
		camController.update();

		Gdx.gl.glViewport(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		for (ModelInstance instance : modelInstances) {
			modelBatch.render(instance, shader);
		}
		modelBatch.end();
		//endregion

		//region Text rendering

		// Multiply vector with world-space position with 3D projection-view matrix
		final Vector3 clipSpacePos = new Vector3(textPosition);
		final float w = multiplyProjective(cam.combined, clipSpacePos, 1f);

		// Do not render the text if it is behind the camera or too far away
		if (clipSpacePos.z >= -1f && clipSpacePos.z <= 1f) {
			// Calculate the position on screen (clip space is [-1,1], we need [-size/2, size/2], but this depends on your viewport)
			final float textPosX = clipSpacePos.x * Gdx.graphics.getWidth() * 0.5f;
			final float textPosY = clipSpacePos.y * Gdx.graphics.getHeight() * 0.5f;

			// Set the text normally. The position must be 0, otherwise the scaling won't work.
			// If you don't want perspective scaling, you can set x,y to textPosX,textPosY directly and skip the next part.
			fontCache.setText("Now in 3D", 0f, 0, 0f, Align.center, false);

			// Size of the text in the world
			final float fontSize = 5f;
			// Scaling factor
			final float fontScale = fontSize / w;
			// Go through prepared vertices of the font cache and do necessary transformation
			final int regionCount = font.getRegions().size;
			for (int page = 0; page < regionCount; page++) {
				final int vertexCount = fontCache.getVertexCount(page);
				final float[] vertices = fontCache.getVertices(page);
				for (int v = 0; v < vertexCount; v += 5) {
					// This is why the text position must be 0 - otherwise the scaling would move the text
					vertices[v] = vertices[v] * fontScale + textPosX;
					vertices[v + 1] = vertices[v + 1] * fontScale + textPosY;
				}
			}

			// Standard viewport update
			uiViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
			spriteBatch.setProjectionMatrix(uiViewport.getCamera().projection);
			// Draw the text normally
			spriteBatch.begin();
			fontCache.draw(spriteBatch);
			spriteBatch.end();
		}
		//endregion
		
		
		ImGui.setNextWindowPos(300, 300, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(320, 240, ImGuiCond.FirstUseEver);
		ImGui.begin("Legends");
		
		ImGui.text("ComputerNode: XCV 330");
		ImGui.text("ComputerMatrix: 100 crew and 850 passengers");
		ImGui.separator();
		ImGui.textColored(255, 1, 1, 255, "Red is absolute line.");
		ImGui.textColored(10, 1, 255, 255, "Blue is absolute line.");
		ImGui.textColored(255, 1, 255, 255, "Pink is absolute node.");
		ImGui.textColored(1, 255, 1, 255, "Green is relative node.");
		ImGui.textColored(200, 200, 5, 255, "Yellow is I/O node.");
		ImGui.textColored(1, 1, 1, 255, "White is dipavali route.");
		ImGui.end();
	}
	
	@Override
	public void dispose() {
		shader.dispose();
		modelBatch.dispose();
		model.dispose();
	}
}
