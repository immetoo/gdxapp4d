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
	private String value = "";
	private String valueLoc = "";
	private String valueArg = "";
	private Operation operation = Operation.NONE;
	private ImInt selectedNumberGlyph = new ImInt();
	
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
		ImGui.combo(getTxt("selectedNumberGlyph"), selectedNumberGlyph, items);
		String selectedItem = items[selectedNumberGlyph.get()];
		BaseGlyphSet baseNumber = BaseGlyphSet.valueOf(selectedItem);
		
		ImGui.text("Value:");
		ImGui.sameLine();
		ImGui.text(valueLoc);
		ImGui.separator();
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(0))) {
			value+="0";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(0);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(1))) {
			value+="1";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(1);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(2))) {
			value+="2";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(2);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(3))) {
			value+="3";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(3);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(4))) {
			value+="4";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(4);
		}
		
		
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(5))) {
			value+="5";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(5);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(6))) {
			value+="6";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(6);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(7))) {
			value+="7";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(7);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(8))) {
			value+="8";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(8);
		}
		ImGui.sameLine();
		if (ImGui.button(baseNumber.BȍőnNumber10().BȍőnCharFor(9))) {
			value+="9";
			valueLoc+=baseNumber.BȍőnNumber10().BȍőnCharFor(9);
		}

		
		if (ImGui.button("C")) {
			value="";
			valueLoc="";
			valueArg="";
			operation = Operation.NONE;
		}
		if (ImGui.button("+")) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.PLUS;
		}
		ImGui.sameLine();
		if (ImGui.button("-")) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.MINUS;
		}
		ImGui.sameLine();
		if (ImGui.button("*")) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.MULTIPLY;
		}
		ImGui.sameLine();
		if (ImGui.button("/")) {
			valueArg=value;
			value="";
			valueLoc="";
			operation = Operation.DIVIDE;
		}
		if (ImGui.button("=")) {
			if (value.isEmpty()) {
				return;
			}
			int v2 = Integer.parseInt(value);
			if (valueArg.isEmpty()) {
				valueLoc = baseNumber.BȍőnPrintNumber10(v2, 9999999);;
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
			value = "" + result;
			valueLoc = baseNumber.BȍőnPrintNumber10(result, 9999999);;
		}
	}
}
