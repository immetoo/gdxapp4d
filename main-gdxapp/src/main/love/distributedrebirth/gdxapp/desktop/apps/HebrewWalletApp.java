package love.distributedrebirth.gdxapp.desktop.apps;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.numberxd.Gê̄ldGetậl;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class HebrewWalletApp extends DefaultDeskApp implements DeskAppRenderer {

	public HebrewWalletApp() {
		super("Hebrew Wallet", "");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}

	@Override
	public void render() {
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
	}
}
