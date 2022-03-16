package love.distributedrebirth.unicode4d.draw;

import java.util.ArrayList;
import java.util.List;

public class DrawGlyphPath {
	private final List<ImGlyphPathCommand> commands = new ArrayList<>();
	
	public interface ImGlyphPathCommand {
		int getX();
		int getY();
		default boolean isImGlyphMoveTo() {
			return this instanceof ImGlyphMoveTo;
		}
		default boolean isImGlyphLineTo() {
			return this instanceof ImGlyphLineTo;
		}
		default boolean isImGlyphCurveTo() {
			return this instanceof ImGlyphCurveTo;
		}
		default boolean isImGlyphQuadCurveTo() {
			return this instanceof ImGlyphQuadCurveTo;
		}
		default boolean isImGlyphClosePath() {
			return this instanceof ImGlyphClosePath;
		}
		default ImGlyphMoveTo toImGlyphMoveTo() {
			return ImGlyphMoveTo.class.cast(this);
		}
		default ImGlyphLineTo toImGlyphLineTo() {
			return ImGlyphLineTo.class.cast(this);
		}
		default ImGlyphCurveTo toImGlyphCurveTo() {
			return ImGlyphCurveTo.class.cast(this);
		}
		default ImGlyphQuadCurveTo toImGlyphQuadCurveTo() {
			return ImGlyphQuadCurveTo.class.cast(this);
		}
		default ImGlyphClosePath toImGlyphClosePath() {
			return ImGlyphClosePath.class.cast(this);
		}
	}
	
	public final class ImGlyphMoveTo implements ImGlyphPathCommand {
		private final int x;
		private final int y;
		
		public ImGlyphMoveTo(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int getX() {
			return x;
		}
		
		@Override
		public int getY() {
			return y;
		}
	}
	
	public final class ImGlyphLineTo implements ImGlyphPathCommand {
		private final int x;
		private final int y;
		
		public ImGlyphLineTo(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int getX() {
			return x;
		}
		
		@Override
		public int getY() {
			return y;
		}
	}
	
	public final class ImGlyphCurveTo implements ImGlyphPathCommand {
		private final int x1;
		private final int y1;
		private final int x2;
		private final int y2;
		private final int x;
		private final int y;
		
		public ImGlyphCurveTo(int x1, int y1,int x2, int y2,int x, int y) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int getX() {
			return x;
		}
		
		@Override
		public int getY() {
			return y;
		}
		
		public int getX1() {
			return x1;
		}
		
		public int getY1() {
			return y1;
		}
		
		public int getX2() {
			return x2;
		}
		
		public int getY2() {
			return y2;
		}
	}
	
	public final class ImGlyphQuadCurveTo implements ImGlyphPathCommand {
		private final int x1;
		private final int y1;
		private final int x;
		private final int y;
		
		public ImGlyphQuadCurveTo(int x1, int y1,int x, int y) {
			this.x1 = x1;
			this.y1 = y1;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int getX() {
			return x;
		}
		
		@Override
		public int getY() {
			return y;
		}
		
		public int getX1() {
			return x1;
		}
		
		public int getY1() {
			return y1;
		}
	}
	
	public class ImGlyphClosePath implements ImGlyphPathCommand {
		
		@Override
		public int getX() {
			return -1;
		}
		
		@Override
		public int getY() {
			return -1;
		}
	}
	
	public void moveTo(int x, int y) {
		commands.add(new ImGlyphMoveTo(x,y));
	}
	
	public void lineTo(int x, int y) {
		commands.add(new ImGlyphLineTo(x,y));
	}
	
	public void curveTo(int x1, int y1,int x2, int y2,int x, int y) {
		commands.add(new ImGlyphCurveTo(x1,y1,x2,y2,x,y));
	}
	
	public void quadCurveTo(int x1, int y1,int x, int y) {
		commands.add(new ImGlyphQuadCurveTo(x1,y1,x,y));
	}
	
	public void closePath() {
		commands.add(new ImGlyphClosePath());
	}
	
	public List<ImGlyphPathCommand> getPath() {
		return commands;
	}
}
