package love.distributedrebirth.numberxd.base2t.bone;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Adds name and website for alt2 info.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface BassBoneAlt2Info {

	String name();
	
	String website();
}
