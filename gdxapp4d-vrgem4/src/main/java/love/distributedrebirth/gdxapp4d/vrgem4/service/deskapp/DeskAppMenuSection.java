package love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public enum DeskAppMenuSection {

	EDITORS,
	EDUCATION,
	INTERNET,
	MULTIMEDIA,
	PROGRAMMING,
	SCIENCE,
	SHELLS,
	SYSTEM,
	;
	
	private DeskAppMenuSection() {
	}
	
	public boolean isSystem() {
		return this == SYSTEM;
	}
}
