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
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.gdxapp4d.vrgem4.VrGem4DeskAppServiceImpl;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDesktop2  extends AbstractScreenDesktop {
	private Texture backgroundImage;
	private Model background;
	private Model grid;
	
	public ScreenDesktop2(SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		super("Desktop2", bootArgs, terminal, deskAppService);
	}
	
	protected void createModel(ModelBuilder modelBuilder, Array<ModelInstance> modelInstances) {
		backgroundImage = new Texture(Gdx.files.internal("background/terrydavis-front.png"));
		int attr = VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;
		Material material = new Material(TextureAttribute.createDiffuse(backgroundImage));
		modelBuilder.begin();
		MeshPartBuilder mpb = modelBuilder.part("floor", GL20.GL_TRIANGLES, attr, material);
		mpb.rect(-20f,-1f,-20f, -20f,-1f,20f,  20f,-1f,20f, 20f,-1f,-20f, 0,1,0);
		background = modelBuilder.end();
		grid = modelBuilder.createLineGrid(33, 33, 1f, 1f, new Material(ColorAttribute.createDiffuse(.1f,.1f,.1f,1f)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		modelInstances.add(new ModelInstance(background, 0, 0, 0));
		modelInstances.add(new ModelInstance(grid, 0, 0, 0));
	}
	
	@Override
	protected void disposeDesktop() {
		backgroundImage.dispose();
		background.dispose();
		grid.dispose();
	}
}
