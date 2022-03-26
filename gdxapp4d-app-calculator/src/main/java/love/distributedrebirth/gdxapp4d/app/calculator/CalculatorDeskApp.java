package love.distributedrebirth.gdxapp4d.app.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class CalculatorDeskApp extends AbstractDeskApp implements DeskAppRenderer {
	
	private ResourceBundle bundle;
	private int valueNum = 0;
	private String value = "";
	private String valueLoc = "";
	private String valueArg = "";
	private Operation operation = Operation.NONE;
	private ImInt selectedNumberGlyph = new ImInt();
	private float buttonSize = 64f;
	
	public CalculatorDeskApp(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	private String getTxt(String key) {
		return bundle.getString(CalculatorDeskApp.class.getSimpleName()+"."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}
	
	enum Operation {
		NONE,
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE
	}
	
	@Override
	public void render() {
		
		List<String> bases = new ArrayList<>();
		for (BaseGlyphSet base:BaseGlyphSet.values()) {
			bases.add(base.name());
		}
		String[] items = new String[bases.size()];
		items = bases.toArray(items);
		boolean changedLoc = ImGui.combo(getTxt("selectedNumberGlyph"), selectedNumberGlyph, items);
		String selectedItem = items[selectedNumberGlyph.get()];
		BaseGlyphSet baseNumber = BaseGlyphSet.valueOf(selectedItem);
		if (changedLoc) {
			valueLoc = baseNumber.BȍőnPrintNumber10(valueNum, 9999999);
		}

		ImGui.text("Value:");
		ImGui.sameLine();
		ImGui.text(valueLoc);
		ImGui.separator();
		
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(7), buttonSize, buttonSize)) {
			value+="7";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(7);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(8), buttonSize, buttonSize)) {
			value+="8";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(8);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(9), buttonSize, buttonSize)) {
			value+="9";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(9);
		}
		ImGui.sameLine();
		if (ImGui.button("/", buttonSize, buttonSize)) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.DIVIDE;
		}
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(4), buttonSize, buttonSize)) {
			value+="4";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(4);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(5), buttonSize, buttonSize)) {
			value+="5";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(5);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(6), buttonSize, buttonSize)) {
			value+="6";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(6);
		}
		ImGui.sameLine();
		if (ImGui.button("*", buttonSize, buttonSize)) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.MULTIPLY;
		}
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(1), buttonSize, buttonSize)) {
			value+="1";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(1);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(2), buttonSize, buttonSize)) {
			value+="2";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(2);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(3), buttonSize, buttonSize)) {
			value+="3";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(3);
		}
		ImGui.sameLine();
		if (ImGui.button("-", buttonSize, buttonSize)) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.MINUS;
		}
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(0), buttonSize, buttonSize)) {
			value+="0";
			valueNum = Integer.parseInt(value);
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(0);
		}
		ImGui.sameLine();
		if (ImGui.button("C", buttonSize, buttonSize)) {
			valueNum = 0;
			value="";
			valueLoc="";
			valueArg="";
			operation = Operation.NONE;
		}
		ImGui.sameLine();
		if (ImGui.button("+", buttonSize, buttonSize)) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.PLUS;
		}
		ImGui.sameLine();
		if (ImGui.button("=", buttonSize, buttonSize)) {
			if (value.isEmpty()) {
				return;
			}
			int v2 = Integer.parseInt(value);
			if (valueArg.isEmpty()) {
				valueLoc = baseNumber.BȍőnPrintNumber10(v2, 9999999);
				return;
			}
			int v1 = Integer.parseInt(valueArg);
			
			int result = 0;
			switch (operation) {
			case PLUS:
				result = v1+v2;
				break;
			case MINUS:
				result = v1-v2;
				break;
			case MULTIPLY:
				result = v1*v2;
				break;
			case DIVIDE:
				result = v1/v2;
				break;
			default:
				break;
			}
			valueNum = result;
			value = "" + valueNum;
			valueLoc = baseNumber.BȍőnPrintNumber10(valueNum, 9999999);
		}
	}
}
