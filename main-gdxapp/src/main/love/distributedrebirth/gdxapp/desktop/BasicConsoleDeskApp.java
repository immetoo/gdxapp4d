package love.distributedrebirth.gdxapp.desktop;

import love.distributedrebirth.imxmi.lang.ImFrameˣᴹᴵ;
import love.distributedrebirth.imxmi.lang.ImTextˣᴹᴵ;

public class BasicConsoleDeskApp implements DeskApp {

	@Override
	public void create(DeskAppContour contour) {
		ImFrameˣᴹᴵ frame = new ImFrameˣᴹᴵ();
		frame.setNextWindowPos(300, 300);
		frame.setNextWindowSize(320, 240);
		frame.setTitle("The BASIC Shahada of DUNE");
		frame.addComponent(new ImTextˣᴹᴵ("10 PRINT \"THERE IS NO GOD BUT @Ω仙⁴\""));
		frame.addComponent(new ImTextˣᴹᴵ("20 PRINT \"THERE IS NO RULE BUT CONSENT\""));
		frame.addComponent(new ImTextˣᴹᴵ("30 PRINT \"THERE IS NO FAILURE BUT DEATH\""));
		frame.addComponent(new ImTextˣᴹᴵ("40 PRINT \"TERRY A. DAVIS WAS THE PROPHET OF @Ω仙9⁴\""));
		frame.addComponent(new ImTextˣᴹᴵ("50 PRINT \"TERRY A. DAVIS WAS THE FIRST TRUE MENTAT\""));
		frame.addComponent(new ImTextˣᴹᴵ("60 PRINT \"TERRY A. DAVIS WAS THE BEST CODER ALIVE\""));
		frame.addComponent(new ImTextˣᴹᴵ("RUN"));
		
		contour.registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
				frame.renderBegin();
				frame.renderComponent();
				frame.renderEnd();
			}
		});
	}
}
