package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiWindowFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.gdxapp4d.vrgem4.ImGuiSetup;
import love.distributedrebirth.gdxapp4d.vrgem4.VrGem4DeskAppServiceImpl;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.gdxapp4d.vrgem4.view.DeskAppController;
import love.distributedrebirth.gdxapp4d.vrgem4.view.DeskAppSelectionListener;
import love.distributedrebirth.gdxapp4d.vrgem4.view.DeskAppInputProcessor;
import love.distributedrebirth.gdxapp4d.vrgem4.view.DeskTopScreen;
import love.distributedrebirth.gdxapp4d.vrgem4.view.DeskTopScreenMenu;
import love.distributedrebirth.unicode4d.draw.ImCharacter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public abstract class AbstractScreenDesktop extends ScreenAdapter implements DeskTopScreen {
	
	protected SpriteBatch batch;
	protected BitmapFont font;
	protected OrthographicCamera camera;
	private final DeskTopScreenMenu screenMenu;
	private final DeskAppController deskAppScreen;
	private PerspectiveCamera cam;
	private FirstPersonCameraController camController;
	private DeskAppInputProcessor inputFilter;
	private Environment environment;
	private ModelBatch modelBatch;
	private Array<ModelInstance> modelInstances = new Array<ModelInstance>();
	
	public AbstractScreenDesktop(String name, SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		this.create();
		screenMenu = new DeskTopScreenMenu(bootArgs, terminal, deskAppService);
		deskAppScreen = new DeskAppController(name);
		deskAppScreen.addDeskAppListener(new DeskAppSelectionListener() {
			
			@Override
			public void selectDeskApp(DeskApp deskApp) {
				if (deskApp == null) {
					inputFilter.setFiltering(false);
				} else {
					inputFilter.setFiltering(true);
				}
			}
		});
	}
	
	protected void createModel(ModelBuilder modelBuilder, Array<ModelInstance> modelInstances) {
	}
	
	private void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, .4f, .4f, .4f, 1f));
		environment.add(new DirectionalLight().set(1, 1, 1, -.2f, -.7f, -.1f));
		
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(-20f, 30f, 0f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		
		ModelBuilder modelBuilder = new ModelBuilder();
		createModel(modelBuilder, modelInstances);
		
		camController = new FirstPersonCameraController(cam);
		//camController = new CameraInputController(cam);
		
		inputFilter = new DeskAppInputProcessor(camController);
	}
	
	@Override
	public final void show() {
		Gdx.input.setInputProcessor(inputFilter);
		showDesktop();
	}
	
	protected void showDesktop() {
	}
	
	@Override
	public final void hide() {
		Gdx.input.setInputProcessor(null);
		hideDesktop();
	}
	
	protected void hideDesktop() {
	}
	
	@Override
	public final void dispose() {
		batch.dispose();
		font.dispose();
		modelBatch.dispose();
		disposeDesktop();
	}
	
	protected void disposeDesktop() {
	}
	
	@Override
	public final void render(float delta) {
		ScreenUtils.clear(0f, 0f, 0f, 1f, true);
		ImGuiSetup.imGuiImp.newFrame();
		ImGui.newFrame();
		
		DeskTopScreen appScreen = this;
		screenMenu.renderMenu(appScreen);
		if (appScreen != null && appScreen.getDeskAppController().getCurrentDeskApp() != null) {
			int sizeFlags = ImGuiCond.Always;
			float sizeMenu = ImCharacter.HEIGHT+ImCharacter.MARGIN_MENUBAR;
			ImGui.setNextWindowPos(0, sizeMenu, sizeFlags);
			ImGui.setNextWindowSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - sizeMenu, sizeFlags);
			int windowFlags = ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoResize | ImGuiWindowFlags.NoTitleBar;
			if (ImGui.begin(appScreen.getDeskAppController().getCurrentDeskApp().getContours().getTitle(), windowFlags)) {
				DeskAppRenderer renderer = appScreen.getDeskAppController().getCurrentDeskApp().getContours().getContour(DeskAppContourSection.MAIN);
				if (renderer != null) {
					renderer.render();
				}
			}
			ImGui.end();
		}
		
		camController.update();
		renderDesktop(delta, modelBatch, cam, modelInstances);
		
		ImGui.render();
		ImGuiSetup.imGuiGlImp.renderDrawData(ImGui.getDrawData());
	}
	
	protected void renderDesktop(float delta, ModelBatch modelBatch, PerspectiveCamera cam, Array<ModelInstance> modelInstances) {
		modelBatch.begin(cam);
		for (ModelInstance instance : modelInstances) {
			modelBatch.render(instance, environment);
		}
		modelBatch.end();
	}
	
	@Override
	public DeskAppController getDeskAppController() {
		return deskAppScreen;
	}
}
