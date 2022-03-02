package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.vrgem4.ImGuiSetup;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppRenderer;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppScreen;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppScreenListener;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskTopInputProcessor;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskTopScreen;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskTopScreenMenu;

public abstract class AbstractScreenDesktop extends ScreenAdapter implements DeskTopScreen {
	
	protected SpriteBatch batch;
	protected BitmapFont font;
	protected OrthographicCamera camera;
	protected ImBoolean showImGuiDemo = new ImBoolean(false);
	private DeskTopScreenMenu screenMenu;
	private final DeskAppScreen deskAppScreen;
	private PerspectiveCamera cam;
	private FirstPersonCameraController camController;
	private DeskTopInputProcessor inputFilter;
	private ModelBatch modelBatch;
	private Array<ModelInstance> modelInstances = new Array<ModelInstance>();
	
	public AbstractScreenDesktop(String name, SystemGdxBootArgs bootArgs) {
		this.create(bootArgs);
		deskAppScreen = new DeskAppScreen(name);
		deskAppScreen.addDeskAppListener(new DeskAppScreenListener() {
			
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
	
	private void create(SystemGdxBootArgs bootArgs) {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		screenMenu = new DeskTopScreenMenu(bootArgs);
		
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		
		ModelBuilder modelBuilder = new ModelBuilder();
		createModel(modelBuilder, modelInstances);
		
		camController = new FirstPersonCameraController(cam);
		//camController = new CameraInputController(cam);
		
		inputFilter = new DeskTopInputProcessor(camController);
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
		if (showImGuiDemo.get()) {
			ImGui.showDemoWindow(showImGuiDemo);
		}
		if (appScreen != null && appScreen.getDeskAppScreen().getCurrentDeskApp() != null) {
			int sizeFlags = ImGuiCond.Always;
			ImGui.setNextWindowPos(0, 28, sizeFlags);
			ImGui.setNextWindowSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - 28, sizeFlags);
			int windowFlags = ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoResize | ImGuiWindowFlags.NoTitleBar;
			if (ImGui.begin(appScreen.getDeskAppScreen().getCurrentDeskApp().getTitle(), windowFlags)) {
				DeskAppRenderer renderer = appScreen.getDeskAppScreen().getCurrentDeskApp().getContours().getContour(DeskAppContourSection.MAIN);
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
		//Gdx.gl.glViewport(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}
	
	protected void renderDesktop(float delta, ModelBatch modelBatch, PerspectiveCamera cam, Array<ModelInstance> modelInstances) {
		modelBatch.begin(cam);
		for (ModelInstance instance : modelInstances) {
			modelBatch.render(instance);
		}
		modelBatch.end();
	}
	
	@Override
	public DeskAppScreen getDeskAppScreen() {
		return deskAppScreen;
	}
}
