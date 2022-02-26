package love.distributedrebirth.gdxapp;

import com.badlogic.gdx.Gdx;

import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImGuiStyle;
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
		initStyle();
	}
	
	private static void initStyle() {
		ImGui.styleColorsDark();
		ImGuiStyle style = ImGui.getStyle();
		style.setWindowRounding(0f);
		style.setWindowBorderSize(0f);
		style.setWindowPadding(6f, 6f);
		style.setScrollbarSize(22f);
	}
	
	private static void initFonts(final ImGuiIO io) {
		ImFontConfig fontConfig = new ImFontConfig();
		ImFontGlyphRangesBuilder fontBuilder = new ImFontGlyphRangesBuilder();
		addRangeUnicodePlane0(fontBuilder);
		final short[] glyphRanges = fontBuilder.buildRanges();
		
		// Base font has almost everything
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/code-2000.ttf").readBytes(), 22, fontConfig, glyphRanges);
		fontConfig.setMergeMode(true);
		// note: merges ~148 chars, just for 3 sub chars for SUBHEX, but still missing 2 chars from T12 alt1 clock
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/free-sans.ttf").readBytes(), 22, fontConfig, glyphRanges);
		// Egyptian hieroglyphs
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/new-gardiner-bmp.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/fa-solid-900.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-samaritan.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-sinhala.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-serif-tibetan.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-tagalog.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-tagbanwa.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-tai-le.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-tai-tham.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-batak.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-lepcha.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-balinese.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-sundanese.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-lisu.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-bamum.ttf").readBytes(), 22, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/noto-sans-glagolitic.ttf").readBytes(), 22, fontConfig, glyphRanges);
		
		// Missig plane 1++
		// - code-2001
		// - code-2002
		// - noto-sans-brahmi
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
