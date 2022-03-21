package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
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
	private Model pyramid1_1;
	private Model pyramid1_2;
	private Model pyramid1_3;
	private Model pyramid2;
	private Model pyramid3;
	private Model pyramid3_1;
	private Model pyramid3_2;
	private Model pyramid3_3;
	
	public ScreenDesktop1(SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		super("Desktop1", bootArgs, terminal, deskAppService);
		
	}
	
	protected void createModel(ModelBuilder modelBuilder, Array<ModelInstance> modelInstances) {
		backgroundImage = new Texture(Gdx.files.internal("background/temple-os.png"));
		int attr = VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;
		Material materialBackground = new Material(TextureAttribute.createDiffuse(backgroundImage));
		modelBuilder.begin();
		MeshPartBuilder mpb = modelBuilder.part("floor", GL20.GL_TRIANGLES, attr, materialBackground);
		mpb.rect(-20f,-1f,-20f, -20f,-1f,20f,  20f,-1f,20f, 20f,-1f,-20f, 0,1,0);
		background = modelBuilder.end();
		
		pyramidImage = new Texture(Gdx.files.internal("background/amalia-kiss-reflex.png"));
		//Material material2 = new Material(ColorAttribute.createDiffuse(.2f,.2f,.7f,1f));
		Material material = new Material(TextureAttribute.createDiffuse(pyramidImage));
		
		pyramid1 = buildPyramid(modelBuilder, attr, material, "pyramid1",  2.3f, 2.92f);
		pyramid2 = buildPyramid(modelBuilder, attr, material, "pyramid2", 2.16f, 2.86f);
		pyramid3 = buildPyramid(modelBuilder, attr, material, "pyramid3", 1.09f, 1.33f);
		pyramid1_1 = buildPyramid(modelBuilder, attr, material, "pyramid1_1",  0.36f, 0.5f);
		pyramid1_2 = buildPyramid(modelBuilder, attr, material, "pyramid1_2",  0.36f, 0.5f);
		pyramid1_3 = buildPyramid(modelBuilder, attr, material, "pyramid1_3",  0.36f, 0.5f);
		pyramid3_1 = buildPyramid(modelBuilder, attr, material, "pyramid3_1",  0.36f, 0.5f);
		pyramid3_2 = buildPyramid(modelBuilder, attr, material, "pyramid3_2",  0.36f, 0.5f);
		pyramid3_3 = buildPyramid(modelBuilder, attr, material, "pyramid3_3",  0.36f, 0.5f);
		
		grid = modelBuilder.createLineGrid(33, 33, 1f, 1f, new Material(ColorAttribute.createDiffuse(.2f,.2f,.2f,1f)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		modelInstances.add(new ModelInstance(background, 0, 0, 0));
		modelInstances.add(new ModelInstance(grid, 0, 0, 0));
		modelInstances.add(new ModelInstance(pyramid1, -2, 0, 12));
		modelInstances.add(new ModelInstance(pyramid2, -8, 0, 6));
		modelInstances.add(new ModelInstance(pyramid3, -14, 0, 2));
		modelInstances.add(new ModelInstance(pyramid1_1, -3, 0, 15.5f));
		modelInstances.add(new ModelInstance(pyramid1_2, -4, 0, 15.5f));
		modelInstances.add(new ModelInstance(pyramid1_3, -5, 0, 15.5f));
		modelInstances.add(new ModelInstance(pyramid3_1, -16.5f, 0, 0));
		modelInstances.add(new ModelInstance(pyramid3_2, -16.5f, 0, 1));
		modelInstances.add(new ModelInstance(pyramid3_3, -16.5f, 0, 2));
	}
	
	private Model buildPyramid(ModelBuilder modelBuilder,int attr, Material material, String name, float width, float height) {
		Vector3 normal = new Vector3(1,1,1);
		VertexInfo v1 = new VertexInfo();
		VertexInfo v2 = new VertexInfo();
		VertexInfo v3 = new VertexInfo();
		
		modelBuilder.begin();
		MeshPartBuilder mpb = modelBuilder.part(name, GL20.GL_TRIANGLES, attr, material);
		v1.set(new Vector3(-width,0, width), normal, null, new Vector2(1,1));
		v2.set(new Vector3(width,0, width), normal, null, new Vector2(0,.6f));
		v3.set(new Vector3(0, height, 0), normal, null, new Vector2(1,0));
		mpb.triangle(v1, v2, v3);
		v1.set(new Vector3(width,0, width), normal, null, new Vector2(1,1));
		v2.set(new Vector3(width,0, -width), normal, null, new Vector2(0,.6f));
		v3.set(new Vector3(0, height, 0), normal, null, new Vector2(1,0));
		mpb.triangle(v1, v2, v3);
		v1.set(new Vector3(width,0, -width), normal, null, new Vector2(1,1));
		v2.set(new Vector3(-width,0, -width), normal, null, new Vector2(0,.6f));
		v3.set(new Vector3(0, height, 0), normal, null, new Vector2(1,0));
		mpb.triangle(v1, v2, v3);
		v1.set(new Vector3(-width,0, -width), normal, null, new Vector2(1,1));
		v2.set(new Vector3(-width,0, width), normal, null, new Vector2(0,.6f));
		v3.set(new Vector3(0, height, 0), normal, null, new Vector2(1,0));
		mpb.triangle(v1, v2, v3);
		return modelBuilder.end();
	}
	
	@Override
	protected void disposeDesktop() {
		backgroundImage.dispose();
		background.dispose();
		pyramidImage.dispose();
		pyramid1.dispose();
		pyramid2.dispose();
		pyramid3.dispose();
		pyramid1_1.dispose();
		pyramid1_2.dispose();
		pyramid1_3.dispose();
		pyramid3_1.dispose();
		pyramid3_2.dispose();
		pyramid3_3.dispose();
		grid.dispose();
	}
}
