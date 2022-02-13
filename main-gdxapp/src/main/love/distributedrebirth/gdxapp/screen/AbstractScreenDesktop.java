package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

import love.distributedrebirth.gdxapp.GDXAppScreen;
import love.distributedrebirth.gdxapp.desktop.DeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppScreen;
import love.distributedrebirth.gdxapp.desktop.DeskAppScreenListener;
import love.distributedrebirth.gdxapp.desktop.FilteringInputProcessor;

public abstract class AbstractScreenDesktop extends ScreenAdapter implements GDXAppScreen {
	
	private final DeskAppScreen deskAppScreen;
	private PerspectiveCamera cam;
	private FirstPersonCameraController camController;
	private FilteringInputProcessor inputFilter;
	private ModelBatch modelBatch;
	private Array<ModelInstance> modelInstances = new Array<ModelInstance>();
	
	public AbstractScreenDesktop(String name) {
		this.create();
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
	
	private void create() {
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
		
		inputFilter = new FilteringInputProcessor(camController);
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
		modelBatch.dispose();
		disposeDesktop();
	}
	
	protected void disposeDesktop() {
	}
	
	@Override
	public final void render(float delta) {
		camController.update();
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		renderDesktop(delta, modelBatch, cam, modelInstances);
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
