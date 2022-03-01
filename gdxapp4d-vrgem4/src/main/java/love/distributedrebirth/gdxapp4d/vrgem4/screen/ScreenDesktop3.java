package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDesktop3 extends AbstractScreenDesktop {
	private Model grid;
	
	public ScreenDesktop3() {
		super("Desktop3");
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
