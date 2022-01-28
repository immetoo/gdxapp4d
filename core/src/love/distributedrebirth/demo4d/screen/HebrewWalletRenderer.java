package love.distributedrebirth.demo4d.screen;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.ImGuiRendererMain;
import love.distributedrebirth.demo4d.fraction4d.Gê̄ldGetậl;

public class HebrewWalletRenderer extends ImGuiRendererMain {

	public HebrewWalletRenderer(Demo4DMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		ImGui.begin("Hebrew Wallet", widgetOpen);
		
		ImGui.text("Current amount:");
		ImGui.sameLine();
		ImGui.text("0000");
		ImGui.separator();
		if (ImGui.button("Pay")) {
		}
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("wallet", 4, flags);
		ImGui.tableSetupColumn("In/Out");
		ImGui.tableSetupColumn("AmountRaw");
		ImGui.tableSetupColumn("AmountFix");
		ImGui.tableSetupColumn("Decimal");
		ImGui.tableHeadersRow();
		
		String[] walletData = {
				"ה","מ","מָ","ח","חֱ","חֱ‎מָא",
				"א","בד","ב","ד","ץףן",
				"הזפץ","מספר","צצצצ","ץאאא","דואר"
			};
		for (String data:walletData) {
			Gê̄ldGetậl geld = new Gê̄ldGetậl(data);
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.text(data.length()==2||data.length()==3?"OUT":"IN");
			ImGui.tableNextColumn();
			ImGui.text(data);
			ImGui.tableNextColumn();
			ImGui.text(geld.toHebrewString(true)); // true=reverse for ImGui
			ImGui.tableNextColumn();
			ImGui.text(Double.toString(geld.getTotalDecimalValue()));
		}
		ImGui.endTable();
		
		ImGui.end();
	}
}
