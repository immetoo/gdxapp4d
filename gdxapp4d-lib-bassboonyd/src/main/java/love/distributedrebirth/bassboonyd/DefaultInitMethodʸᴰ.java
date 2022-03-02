package love.distributedrebirth.bassboonyd;

import java.lang.reflect.Method;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {})
public interface DefaultInitMethodʸᴰ {

	default void BOON_INIT(Object boon) {
		try {
			for (Method m:boon.getClass().getMethods()) {
				if (m.isAnnotationPresent(BãßBȍőnInitMethodʸᴰ.class)) {
					m.invoke(boon, this);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
