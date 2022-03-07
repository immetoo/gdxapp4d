package love.distributedrebirth.gdxapp4d.app.calculator;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class CalculatorDeskApp extends AbstractDeskApp implements DeskAppRenderer {

	private String value = "";
	private String valueArg = "";
	private Operation operation = Operation.NONE;
	
	public void create() {
		getContours().setTitle("Calculator");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}
	
	enum Operation {
		NONE,
		PLUS,
		MINUS,
		MULTIPLY
	}
	
	@Override
	public void render() {
		ImGui.text("Value:");
		ImGui.sameLine();
		ImGui.text(value);
		ImGui.separator();
		
		if (ImGui.button("0")) {
			value+="0";
		}
		ImGui.sameLine();
		if (ImGui.button("1")) {
			value+="1";
		}
		ImGui.sameLine();
		if (ImGui.button("2")) {
			value+="2";
		}
		ImGui.sameLine();
		if (ImGui.button("3")) {
			value+="3";
		}
		ImGui.sameLine();
		if (ImGui.button("4")) {
			value+="4";
		}
		
		
		if (ImGui.button("5")) {
			value+="5";
		}
		ImGui.sameLine();
		if (ImGui.button("6")) {
			value+="6";
		}
		ImGui.sameLine();
		if (ImGui.button("7")) {
			value+="7";
		}
		ImGui.sameLine();
		if (ImGui.button("8")) {
			value+="8";
		}
		ImGui.sameLine();
		if (ImGui.button("9")) {
			value+="9";
		}

		
		if (ImGui.button("C")) {
			value="";
			valueArg="";
			operation = Operation.NONE;
		}
		if (ImGui.button("+")) {
			valueArg=value;
			value="";
			operation = Operation.PLUS;
		}
		ImGui.sameLine();
		if (ImGui.button("-")) {
			valueArg=value;
			value="";
			operation = Operation.MINUS;
		}
		ImGui.sameLine();
		if (ImGui.button("*")) {
			valueArg=value;
			value="";
			operation = Operation.MULTIPLY;
		}
		if (ImGui.button("=")) {
			int v1 = Integer.parseInt(valueArg);
			int v2 = Integer.parseInt(value);
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
			default:
				break;
			}
			value = ""+result;
		}
	}
}
