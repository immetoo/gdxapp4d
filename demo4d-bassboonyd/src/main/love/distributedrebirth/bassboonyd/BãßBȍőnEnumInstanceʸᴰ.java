package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnEnumInstanceʸᴰ<T> extends BãßBȍőnEnumʸᴰ<T> {

	int ordinal();
	
	default T BȍőnInstance() {
		return BãßInstances()[ordinal()];
	}
	
	default T BãßInstance() {
		return BãßInstances()[BãßBȍőnConstants.INT_ZERO];
	}
}
