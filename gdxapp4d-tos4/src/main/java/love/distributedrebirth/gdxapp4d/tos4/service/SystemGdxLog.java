package love.distributedrebirth.gdxapp4d.tos4.service;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemGdxLog {

	void infoTag(String tag, String message, Object...args);
	
	void infoTag(String tag, String message, Throwable exception);
	
	void debugTag(String tag, String message, Object...args);
	
	void debugTag(String tag, String message, Throwable exception);
	
	void errorTag(String tag, String message, Object...args);
	
	void errorTag(String tag, String message, Throwable exception);
	
	default void info(Object tag, String message, Object...args) {
		infoTag(tag.getClass().getName(), message, args);
	}
	
	default void debug(Object tag, String message, Object...args) {
		debugTag(tag.getClass().getName(), message, args);
	}
	
	default void error(Object tag, String message, Object...args) {
		errorTag(tag.getClass().getName(), message, args);
	}
	
	default void error(Object tag, String message, Throwable exception) {
		errorTag(tag.getClass().getName(), message, exception);
	}
}
