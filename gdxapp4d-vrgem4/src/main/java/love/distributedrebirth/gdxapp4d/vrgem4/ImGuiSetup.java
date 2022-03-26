package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.Gdx;

import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImGuiStyle;
import imgui.flag.ImGuiBackendFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.unicode4d.draw.ImCharacter;

/**
 * Create and shutdown of ImGui and font activations.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImGuiSetup {
	public final static ImGuiImplGlfw imGuiImp = new ImGuiImplGlfw();
	public final static ImGuiImplGl3 imGuiGlImp = new ImGuiImplGl3();
	
	public void init(List<File> fonts, Consumer<String> logger) {
		long windowHandle = -1;
		try {
			Object window = Gdx.graphics.getClass().getMethod("getWindow").invoke(Gdx.graphics);
			windowHandle = (Long)window.getClass().getMethod("getWindowHandle").invoke(window);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ImGui.createContext();
		initFonts(ImGui.getIO(), fonts, logger);
		imGuiImp.init(windowHandle, true);
		imGuiGlImp.init("#version 140");
		ImGui.getIO().setIniFilename(null);
		ImGui.getIO().setBackendFlags(ImGuiBackendFlags.RendererHasVtxOffset);
		ImGui.init();
		initStyle();
	}
	
	private void initStyle() {
		ImGui.styleColorsDark();
		ImGuiStyle style = ImGui.getStyle();
		style.setWindowRounding(0f);
		style.setWindowBorderSize(0f);
		style.setWindowPadding(6f, 6f);
		style.setScrollbarSize(22f);
	}
	
	private void initFonts(final ImGuiIO io, List<File> fonts, Consumer<String> logger) {
		ImFontConfig fontConfig = new ImFontConfig();
		ImFontGlyphRangesBuilder fontBuilder = new ImFontGlyphRangesBuilder();
		addRangeUnicodePlane0(fontBuilder);
		final short[] glyphRanges = fontBuilder.buildRanges();
		
		float fontSize = ImCharacter.HEIGHT;
		boolean first = true;
		for (File font: fonts) {
			logger.accept("Load font: "+font);
			io.getFonts().addFontFromMemoryTTF(Gdx.files.absolute(font.getAbsolutePath()).readBytes(), fontSize, fontConfig, glyphRanges);
			if (first) {
				fontConfig.setMergeMode(true);
				first = false;
			}
		}
		fontConfig.destroy();
	}
	
	private void addRangeUnicodePlane0(ImFontGlyphRangesBuilder fontBuilder) {
		for (int c=0x0001;c<=0xFFEF;c++) {
			StringBuilder buf = new StringBuilder();
			buf.append(""+(char)c);
			fontBuilder.addText(buf.toString());
		}
	}
	
	public void dispose() {
		imGuiImp.dispose();
		imGuiGlImp.dispose();
		ImGui.destroyContext();
	}
}
