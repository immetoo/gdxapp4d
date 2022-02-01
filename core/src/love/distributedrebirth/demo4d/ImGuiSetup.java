package love.distributedrebirth.demo4d;

import com.badlogic.gdx.Gdx;

import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;

/**
 * Create and shutdown of ImGui and font activations.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
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
		imGuiGlImp.init("#version 150");
		ImGui.init();
		
		ImGui.styleColorsLight();
	}
	
	private static void initFonts(final ImGuiIO io) {
		io.getFonts().addFontDefault();
		ImFontConfig fontConfig = new ImFontConfig();
		fontConfig.setMergeMode(true);
		ImFontGlyphRangesBuilder fontBuilder = new ImFontGlyphRangesBuilder();
		addRangeUnicodePlane0(fontBuilder);
		final short[] glyphRanges = fontBuilder.buildRanges();
		
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/NotoSansCJKjp-Medium.otf").readBytes(), 14, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/FreeSans.ttf").readBytes(), 14, fontConfig, glyphRanges);
		
		fontConfig.destroy();
	}
	
	private static void addRangeUnicodePlane0(ImFontGlyphRangesBuilder fontBuilder) {
		for (int c=0x0100;c<=0xFFEF;c++) {
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
