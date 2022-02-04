package love.distributedrebirth.gdxapp.screen;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.Demo4DMain;
import love.distributedrebirth.gdxapp.ImGuiRendererMain;
import love.distributedrebirth.numberxd.Gê̄ldGetậl;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
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
		ImGui.beginTable("wallet", 5, flags);
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
			Gê̄ldGetậl geld2 = geld.toClone(); // unit test
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.text(data.length()==2||data.length()==3?"OUT":"IN");
			ImGui.tableNextColumn();
			ImGui.text(data);
			ImGui.tableNextColumn();
			ImGui.text(geld2.toHebrewString(true)); // true=reverse for ImGui
			ImGui.tableNextColumn();
			ImGui.text(Double.toString(geld.getTotalDecimalValue()));
		}
		ImGui.endTable();
		
		ImGui.end();
	}
}
