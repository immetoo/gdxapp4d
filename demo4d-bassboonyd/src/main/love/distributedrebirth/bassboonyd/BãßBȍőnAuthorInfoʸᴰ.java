package love.distributedrebirth.bassboonyd;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Moves copyright into runtime class info.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface BãßBȍőnAuthorInfoʸᴰ {

	String name();
	
	String copyright();
}
