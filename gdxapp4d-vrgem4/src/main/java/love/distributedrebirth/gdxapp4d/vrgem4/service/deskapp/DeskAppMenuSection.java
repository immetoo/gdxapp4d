package love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp;

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
