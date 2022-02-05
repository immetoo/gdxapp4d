package love.distributedrebirth.numberxd.x4o;

import org.x4o.xml.lang.X4OLanguageLocal;
import org.x4o.xml.lang.X4OLanguageModuleLoader;
import org.x4o.xml.lang.X4OLanguageModuleLoaderException;
import org.x4o.xml.lang.X4OLanguageModuleLocal;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class NumberXDModuleLoader implements X4OLanguageModuleLoader {

	private static final String PP_NXD_PROVIDER_HOST = "numberxd.x4o.distributedrebirth.love";
	private static final String PP_NXD_XMLNS = "http://"+PP_NXD_PROVIDER_HOST+"/xml/ns/";
	private static final String PP_NXD_XSD_FILE = "-1.0.xsd";
	private static final String NXD_CORE = "nxd-core";
	private static final String NXD_ROOT = "nxd-root";
	private static final String NXD_CORE_XSD_FILE = NXD_CORE+PP_NXD_XSD_FILE;
	private static final String NXD_ROOT_XSD_FILE = NXD_ROOT+PP_NXD_XSD_FILE;
	/** The NXD core namespace uri. */
	public  static final String NXD_CORE_URI = PP_NXD_XMLNS+NXD_CORE;
	/** The NXD root namespace uri. */
	public  static final String NXD_ROOT_URI = PP_NXD_XMLNS+NXD_ROOT;
	/** The NXD core schema namespace uri. */
	public  static final String NXD_CORE_XSD_URI = NXD_CORE_URI+PP_NXD_XSD_FILE;
	/** The NXD root schema namespace uri. */
	public  static final String NXD_ROOT_XSD_URI = NXD_ROOT_URI+PP_NXD_XSD_FILE;
	
	@Override
	public void loadLanguageModule(X4OLanguageLocal arg0, X4OLanguageModuleLocal arg1) throws X4OLanguageModuleLoaderException {
		// TODO Auto-generated method stub
	}
}
