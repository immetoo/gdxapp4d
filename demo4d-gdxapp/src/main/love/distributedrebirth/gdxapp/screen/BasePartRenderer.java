package love.distributedrebirth.gdxapp.screen;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.Demo4DMain;
import love.distributedrebirth.gdxapp.ImGuiRendererMain;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
import love.distributedrebirth.numberxd.base2t.glyph.BaseGlyphSet;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt3ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt4ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BasePartRenderer extends ImGuiRendererMain {

	private ImInt selectedBasePart = new ImInt();
	
	public BasePartRenderer(Demo4DMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		ImGui.begin("Base part", widgetOpen);
		
		List<String> bases = new ArrayList<>();
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			bases.add(Integer.toString(base));
		}
		String[] items = new String[bases.size()];
		items = bases.toArray(items);
		String selectedItem = items[selectedBasePart.get()];
		Integer baseNumber = Integer.valueOf(selectedItem);
		BãßBȍőnPartʸᴰ<?>[] baseParts = BasePartFactory.INSTANCE.BãßBuildPartsByBase(baseNumber);
		
		ImGui.text("Base:");
		ImGui.sameLine();
		ImGui.text(baseParts[0].BãßClassNaam());
		ImGui.sameLine();
		ImGui.combo("Type", selectedBasePart, items);
		
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("base-part", 23, flags);
		ImGui.tableSetupColumn("BȍőnNaam");
		ImGui.tableSetupColumn("TelNul");
		ImGui.tableSetupColumn("TelEen");
		ImGui.tableSetupColumn("Tone");
		ImGui.tableSetupColumn("10Tone");
		ImGui.tableSetupColumn("10Kor");
		ImGui.tableSetupColumn("10DTMF");
		ImGui.tableSetupColumn("10Ben");
		ImGui.tableSetupColumn("16Tone");
		ImGui.tableSetupColumn("16Kor");
		ImGui.tableSetupColumn("16LatB");
		ImGui.tableSetupColumn("16Gre");
		ImGui.tableSetupColumn("36Tone");
		ImGui.tableSetupColumn("36Kor");
		ImGui.tableSetupColumn("36LatB");
		ImGui.tableSetupColumn("36Gre");
		ImGui.tableSetupColumn("36Heb");
		ImGui.tableSetupColumn("prcK");
		ImGui.tableSetupColumn("prcV");
		ImGui.tableSetupColumn("Alt1");
		ImGui.tableSetupColumn("Alt2");
		ImGui.tableSetupColumn("Alt3");
		ImGui.tableSetupColumn("Alt4");
		ImGui.tableHeadersRow();
		
		for (BãßBȍőnPartʸᴰ<?> part:baseParts) {
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnNaam());
			ImGui.tableNextColumn();
			ImGui.text(Integer.toString(part.BȍőnRangTelNul()));
			ImGui.tableNextColumn();
			ImGui.text(Integer.toString(part.BȍőnRangTelEen()));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnIdentifierTone());
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber10(BaseGlyphSet.TONE_LETTER));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber10(BaseGlyphSet.KOREAN));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber10(BaseGlyphSet.LATIN_DTMF));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber10(BaseGlyphSet.BENGALI));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber16(BaseGlyphSet.TONE_LETTER));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber16(BaseGlyphSet.KOREAN));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber16(BaseGlyphSet.LATIN_BASIC));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber16(BaseGlyphSet.GREEK));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber36(BaseGlyphSet.TONE_LETTER));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber36(BaseGlyphSet.KOREAN));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber36(BaseGlyphSet.LATIN_BASIC));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber36(BaseGlyphSet.GREEK));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnGlyphSetNumber36(BaseGlyphSet.HEBREW));
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnChinaKey());
			ImGui.tableNextColumn();
			ImGui.text(part.BȍőnChinaValue());
			
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt1ʸᴰ) {
				ImGui.text(BãßBȍőnPartAlt1ʸᴰ.class.cast(part).BȍőnAlt1Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt2ʸᴰ) {
				ImGui.text(BãßBȍőnPartAlt2ʸᴰ.class.cast(part).BȍőnAlt2Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt3ʸᴰ) {
				ImGui.text(BãßBȍőnPartAlt3ʸᴰ.class.cast(part).BȍőnAlt3Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt4ʸᴰ) {
				ImGui.text(BãßBȍőnPartAlt4ʸᴰ.class.cast(part).BȍőnAlt4Value());
			} else {
				ImGui.text("");
			}
		}
		
		ImGui.endTable();
		
		ImGui.end();
	}
}
