package love.distributedrebirth.demo4d;

import com.badlogic.gdx.Gdx;

import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt1;

/**
 * Create and shutdown of ImGui and font activations.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class ImGuiSetup {
	public static final ImGuiImplGlfw imGuiImp = new ImGuiImplGlfw();
	public static final ImGuiImplGl3 imGuiGlImp = new ImGuiImplGl3();
	private static final short[] glyphRangesHebrew = new short[]{0x0590, 0x05F4};
	private static final short[] glyphRangesArabic = new short[]{0x0600, 0x06FF};
	private static final short[] glyphRangesSubSuper0 = new short[]{0x00B2, 0x00B9};
	private static final short[] glyphRangesSubSuper1 = new short[]{0x2070, 0x209F};
	
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

		ImFontGlyphRangesBuilder rangesBuilder = new ImFontGlyphRangesBuilder();
		rangesBuilder.addRanges(io.getFonts().getGlyphRangesDefault());
		rangesBuilder.addRanges(io.getFonts().getGlyphRangesCyrillic());
		rangesBuilder.addRanges(io.getFonts().getGlyphRangesJapanese());
		rangesBuilder.addRanges(io.getFonts().getGlyphRangesChineseFull());
		rangesBuilder.addRanges(glyphRangesHebrew);
		rangesBuilder.addRanges(glyphRangesArabic);
		rangesBuilder.addRanges(glyphRangesSubSuper0);
		rangesBuilder.addRanges(glyphRangesSubSuper1);
		rangesBuilder.addText("@Ω\u4ed9⁴ ˧꜏⋇꜊꜔ ⁴ﷲΩ@");
		rangesBuilder.addText("©Δ∞ \u4ed9\u4e0a\u4e3b\u5929");
		
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BasePart part:BasePartFactory.buildBasePartsByBase(base)) {
				rangesBuilder.addText(part.getIdentifierTone());
				rangesBuilder.addText(part.getIdentifierLetter());
				rangesBuilder.addText(part.getChinaKey());
				if (part instanceof BasePartAlt1) {
					rangesBuilder.addText(BasePartAlt1.class.cast(part).getAlt1Value());
				}
			}
		}

		ImFontConfig fontConfig = new ImFontConfig();
		fontConfig.setMergeMode(true);

		final short[] glyphRanges = rangesBuilder.buildRanges();
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/NotoSansCJKjp-Medium.otf").readBytes(), 14, fontConfig, glyphRanges);
		io.getFonts().addFontFromMemoryTTF(Gdx.files.internal("font/FreeSans.ttf").readBytes(), 14, fontConfig, glyphRanges);
		
		fontConfig.destroy();
	}
	
	public static void dispose() {
		imGuiImp.dispose();
		imGuiGlImp.dispose();
		ImGui.destroyContext();
	}
}
