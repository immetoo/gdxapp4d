package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.vrgem4.VrGem4DeskAppServiceImpl;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDesktop1 extends AbstractScreenDesktop {
	private Model grid;
	
	public ScreenDesktop1(SystemGdxBootArgs bootArgs, VrGem4DeskAppServiceImpl deskAppService) {
		super("Desktop1", bootArgs, deskAppService);
		//backgroundImage = new Texture(Gdx.files.internal("background/terrydavis-front.png"));
	}
	
	protected void createModel(ModelBuilder modelBuilder, Array<ModelInstance> modelInstances) {
		grid = modelBuilder.createLineGrid(33, 33, 1f, 1f, new Material(ColorAttribute.createDiffuse(1f,1f,1f,.1f)), Usage.Position | Usage.Normal);
		modelInstances.add(new ModelInstance(grid, 0, 0, 0));
	}
	
	@Override
	protected void disposeDesktop() {
		grid.dispose();
	}
}
