package love.distributedrebirth.imxmi.lang;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImFrameˣᴹᴵ extends AbstractImComponentSetˣᴹᴵ {
	
	private String title;
	private ImBoolean frameOpen;
	private float nextWindowPosX;
	private float nextWindowPosY;
	private int nextWindowPosCond;
	private float nextWindowSizeWidth;
	private float nextWindowSizeHeight;
	private int nextWindowSizeCond;
	
	public ImFrameˣᴹᴵ() {
		this(null, null);
	}
	
	public ImFrameˣᴹᴵ(String title, ImBoolean frameOpen) {
		this.title = title;
		this.frameOpen = frameOpen;
		nextWindowPosX = 320;
		nextWindowPosY = 240;
		nextWindowPosCond = ImGuiCond.FirstUseEver;
		nextWindowSizeWidth = 640;
		nextWindowSizeHeight = 480;
		nextWindowSizeCond = ImGuiCond.FirstUseEver;
	}
	
	@Override
	public void renderBegin() {
		ImGui.setNextWindowPos(nextWindowPosX, nextWindowPosY, nextWindowPosCond);
		ImGui.setNextWindowSize(nextWindowSizeWidth, nextWindowSizeHeight, nextWindowSizeCond);
	}
	
	@Override
	public void renderComponent() {
		if (ImGui.begin(title, frameOpen)) {
			renderComponents();
		}
	}
	
	@Override
	public void renderEnd() {
		ImGui.end();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ImBoolean getFrameOpen() {
		return frameOpen;
	}
	
	public void setFrameOpen(ImBoolean frameOpen) {
		this.frameOpen = frameOpen;
	}
	
	public void setNextWindowPos(float nextWindowPosX, float nextWindowPosY) {
		setNextWindowPosX(nextWindowPosX);
		setNextWindowPosY(nextWindowPosY);
	}
	
	public float getNextWindowPosX() {
		return nextWindowPosX;
	}
	
	public void setNextWindowPosX(float nextWindowPosX) {
		this.nextWindowPosX = nextWindowPosX;
	}
	
	public float getNextWindowPosY() {
		return nextWindowPosY;
	}
	
	public void setNextWindowPosY(float nextWindowPosY) {
		this.nextWindowPosY = nextWindowPosY;
	}
	
	public int getNextWindowPosCond() {
		return nextWindowPosCond;
	}
	
	public void setNextWindowPosCond(int nextWindowPosCond) {
		this.nextWindowPosCond = nextWindowPosCond;
	}
	
	public void setNextWindowSize(float nextWindowSizeWidth, float nextWindowSizeHeight) {
		setNextWindowSizeWidth(nextWindowSizeWidth);
		setNextWindowSizeHeight(nextWindowSizeHeight);
	}
	
	public float getNextWindowSizeWidth() {
		return nextWindowSizeWidth;
	}
	
	public void setNextWindowSizeWidth(float nextWindowSizeWidth) {
		this.nextWindowSizeWidth = nextWindowSizeWidth;
	}
	
	public float getNextWindowSizeHeight() {
		return nextWindowSizeHeight;
	}
	
	public void setNextWindowSizeHeight(float nextWindowSizeHeight) {
		this.nextWindowSizeHeight = nextWindowSizeHeight;
	}
	
	public int getNextWindowSizeCond() {
		return nextWindowSizeCond;
	}
	
	public void setNextWindowSizeCond(int nextWindowSizeCond) {
		this.nextWindowSizeCond = nextWindowSizeCond;
	}
}
