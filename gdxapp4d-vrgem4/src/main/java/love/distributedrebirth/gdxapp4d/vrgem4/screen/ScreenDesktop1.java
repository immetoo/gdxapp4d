package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.gdxapp4d.vrgem4.VrGem4DeskAppServiceImpl;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDesktop1 extends AbstractScreenDesktop {
	private Texture backgroundImage;
	private Model background;
	private Model grid;
	private Texture pyramidImage;
	private Model pyramid1;
	
	public ScreenDesktop1(SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		super("Desktop1", bootArgs, terminal, deskAppService);
		
	}
	
	protected void createModel(ModelBuilder modelBuilder, Array<ModelInstance> modelInstances) {
		backgroundImage = new Texture(Gdx.files.internal("background/temple-os.png"));
		int attr = VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;
		Material material = new Material(TextureAttribute.createDiffuse(backgroundImage));
		modelBuilder.begin();
		MeshPartBuilder mpb = modelBuilder.part("floor", GL20.GL_TRIANGLES, attr, material);
		mpb.rect(-20f,-1f,-20f, -20f,-1f,20f,  20f,-1f,20f, 20f,-1f,-20f, 0,1,0);
		background = modelBuilder.end();
		
		pyramidImage = new Texture(Gdx.files.internal("background/doom-credits.png"));
		//material = new Material(ColorAttribute.createDiffuse(.2f,.2f,.7f,1f));
		material = new Material(TextureAttribute.createDiffuse(pyramidImage));
		modelBuilder.begin();
		mpb = modelBuilder.part("pyramid1", GL20.GL_TRIANGLES, attr, material);
		mpb.setUVRange(new TextureRegion(pyramidImage));
		mpb.triangle(new Vector3(-3,0, 3), new Vector3(3,0, 3), new Vector3(0, 3, 0));
		mpb.triangle(new Vector3(3,0, 3), new Vector3(3,0, -3), new Vector3(0, 3, 0));
		mpb.triangle(new Vector3(3,0, -3), new Vector3(-3,0, -3), new Vector3(0, 3, 0));
		mpb.triangle(new Vector3(-3,0, -3), new Vector3(-3,0, 3), new Vector3(0, 3, 0));
		pyramid1 = modelBuilder.end();
		
		grid = modelBuilder.createLineGrid(33, 33, 1f, 1f, new Material(ColorAttribute.createDiffuse(.2f,.2f,.2f,1f)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		modelInstances.add(new ModelInstance(background, 0, 0, 0));
		modelInstances.add(new ModelInstance(grid, 0, 0, 0));
		modelInstances.add(new ModelInstance(pyramid1, -8, 0, 8));
	}
	
	@Override
	protected void disposeDesktop() {
		backgroundImage.dispose();
		background.dispose();
		pyramidImage.dispose();
		pyramid1.dispose();
		grid.dispose();
	}
}
