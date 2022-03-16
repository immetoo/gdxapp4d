package love.distributedrebirth.gdxapp4d.app.glyphdemo.apps;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt3ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt4ʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DemoNumberPartDeskApp extends AbstractDeskApp implements DeskAppRenderer {

	private final ResourceBundle bundle;
	private ImInt selectedBasePart = new ImInt();
	private final ImBoolean showBase10 = new ImBoolean(false);
	private final ImBoolean showBase16 = new ImBoolean(false);
	private final ImBoolean showBase27 = new ImBoolean(false);
	
	public DemoNumberPartDeskApp(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	private String getTxt(String key) {
		return bundle.getString(DemoNumberPartDeskApp.class.getSimpleName()+"."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}

	@Override
	public void render() {
		List<String> bases = new ArrayList<>();
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			bases.add(Integer.toString(base));
		}
		String[] items = new String[bases.size()];
		items = bases.toArray(items);
		String selectedItem = items[selectedBasePart.get()];
		Integer baseNumber = Integer.valueOf(selectedItem);
		BãßBȍőnPartʸᴰ<?>[] baseParts = Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(baseNumber);
		
		ImGui.combo(getTxt("selectBase"), selectedBasePart, items);
		
		ImGui.text(getTxt("selectName"));
		ImGui.sameLine();
		ImGui.text(baseParts[0].BãßClassNaam());
		
		ImGui.text(getTxt("selectPurpose"));
		ImGui.sameLine();
		ImGui.text(baseParts[0].BãßClassPurpose());
		
		ImGui.checkbox(getTxt("showBase10"), showBase10);
		ImGui.checkbox(getTxt("showBase16"), showBase16);
		ImGui.checkbox(getTxt("showBase27"), showBase27);
		
		int columns = 10;
		if (showBase10.get()) {
			columns += 4;
		}
		if (showBase16.get()) {
			columns += 4;
		}
		if (showBase27.get()) {
			columns += 5;
		}
		
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("base-part", columns, flags);
		ImGui.tableSetupColumn("BȍőnNaam");
		ImGui.tableSetupColumn("TelNul");
		ImGui.tableSetupColumn("TelEen");
		ImGui.tableSetupColumn("Tone");
		if (showBase10.get()) {
			ImGui.tableSetupColumn("10Tone");
			ImGui.tableSetupColumn("10Kor");
			ImGui.tableSetupColumn("10Beng");
			ImGui.tableSetupColumn("10Arab");
		}
		if (showBase16.get()) {
			ImGui.tableSetupColumn("16Tone");
			ImGui.tableSetupColumn("16Kor");
			ImGui.tableSetupColumn("16Runi");
			ImGui.tableSetupColumn("16LatB");
		}
		if (showBase27.get()) {
			ImGui.tableSetupColumn("27Tone");
			ImGui.tableSetupColumn("27Kor");
			ImGui.tableSetupColumn("27LatB");
			ImGui.tableSetupColumn("27Gre");
			ImGui.tableSetupColumn("27Mala");
		}
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
			ImGui.text(part.BȍőnDialTone());
			if (showBase10.get()) {
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber10(BaseGlyphSet.TONE_SCRIPT));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber10(BaseGlyphSet.KOREAN));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber10(BaseGlyphSet.BENGALI));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber10(BaseGlyphSet.ARABIC));
			}
			if (showBase16.get()) {
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber16(BaseGlyphSet.TONE_SCRIPT));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber16(BaseGlyphSet.KOREAN));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber16(BaseGlyphSet.RUNIC));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber16(BaseGlyphSet.LATIN_BASIC));
			}
			if (showBase27.get()) {
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber27(BaseGlyphSet.TONE_SCRIPT));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber27(BaseGlyphSet.KOREAN));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber27(BaseGlyphSet.LATIN_BASIC));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber27(BaseGlyphSet.GREEK));
				ImGui.tableNextColumn();
				ImGui.text(part.BȍőnPrintGlyphSetNumber27(BaseGlyphSet.MALAYALAM));
			}
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
	}
}
