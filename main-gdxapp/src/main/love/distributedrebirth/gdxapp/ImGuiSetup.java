package love.distributedrebirth.gdxapp;

import com.badlogic.gdx.Gdx;

import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Create and shutdown of ImGui and font activations.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImGuiSetup {
	public static final ImGuiImplGlfw imGuiImp = new ImGuiImplGlfw();
	public static final ImGuiImplGl3 imGuiGlImp = new ImGuiImplGl3();
	
	public static void init() {
		long windowHandle = -1;
		try {
			Object window = Gdx.graphics.getClass().getMethod("getWindow").invoke(Gdx.graphics);
			windowHandle = (Long)window.getClass().getMethod("getWindowHandle").invoke(window);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ImGui.createContext();
		initFonts(ImGui.getIO());
		imGuiImp.init(windowHandle, true);
		imGuiGlImp.init("#version 140");
		ImGui.init();
		
		ImGui.styleColorsLight();
	}
	
	private static void initFonts(final ImGuiIO io) {
		ImFontConfig fontConfig = new ImFontConfig();
		ImFontGlyphRangesBuilder fontBuilder = new ImFontGlyphRangesBuilder();
		addRangeUnicodePlane0(fontBuilder);
		final short[] glyphRanges = fontBuilder.buildRanges();
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/code2000.ttf").readBytes(), 24, fontConfig, glyphRanges);
		fontConfig.setMergeMode(true);
		// note: merges 148 chars, just for 3 sub chars for SUBHEX, but still missing 2 chars from T12 alt1 clock
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/free-sans.ttf").readBytes(), 24, fontConfig, glyphRanges);
		fontConfig.destroy();
	}
	
	private static void addRangeUnicodePlane0(ImFontGlyphRangesBuilder fontBuilder) {
		for (int c=0x0001;c<=0xFFEF;c++) {
			StringBuilder buf = new StringBuilder();
			buf.append(""+(char)c);
			fontBuilder.addText(buf.toString());
		}
	}
	
	public static void dispose() {
		imGuiImp.dispose();
		imGuiGlImp.dispose();
		ImGui.destroyContext();
	}
}
