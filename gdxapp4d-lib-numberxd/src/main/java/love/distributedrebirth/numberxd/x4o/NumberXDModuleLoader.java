package love.distributedrebirth.numberxd.x4o;

import org.x4o.xml.conv.ObjectConverter;
import org.x4o.xml.eld.lang.ModuleElement;
import org.x4o.xml.element.ElementBindingHandler;
import org.x4o.xml.element.ElementClass;
import org.x4o.xml.element.ElementClassAttribute;
import org.x4o.xml.element.ElementNamespace;
import org.x4o.xml.element.ElementNamespaceInstanceProvider;
import org.x4o.xml.element.ElementNamespaceInstanceProviderException;
import org.x4o.xml.lang.X4OLanguage;
import org.x4o.xml.lang.X4OLanguageClassLoader;
import org.x4o.xml.lang.X4OLanguageLocal;
import org.x4o.xml.lang.X4OLanguageModuleLoader;
import org.x4o.xml.lang.X4OLanguageModuleLoaderException;
import org.x4o.xml.lang.X4OLanguageModuleLocal;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.type.V006Tixte;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V018Tord;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class NumberXDModuleLoader implements X4OLanguageModuleLoader {

	private static final String PP_NXD_PROVIDER_HOST = "unicode4d.x4o.distributedrebirth.love";
	private static final String PP_NXD_XMLNS = "http://"+PP_NXD_PROVIDER_HOST+"/xml/ns/";
	private static final String PP_NXD_XSD_FILE = "-1.0.xsd";
	private static final String NXD_DATA = "d";
	//private static final String NXD_ROOT = "nxd-root";
	private static final String NXD_DATA_XSD_FILE = NXD_DATA+PP_NXD_XSD_FILE;
	//private static final String NXD_ROOT_XSD_FILE = NXD_ROOT+PP_NXD_XSD_FILE;
	public  static final String NXD_DATA_URI = PP_NXD_XMLNS+NXD_DATA;
	//public  static final String NXD_ROOT_URI = PP_NXD_XMLNS+NXD_ROOT;
	public  static final String NXD_DATA_XSD_URI = NXD_DATA_URI+PP_NXD_XSD_FILE;
	//public  static final String NXD_ROOT_XSD_URI = NXD_ROOT_URI+PP_NXD_XSD_FILE;
	
	@Override
	public void loadLanguageModule(X4OLanguageLocal language, X4OLanguageModuleLocal languageModule) throws X4OLanguageModuleLoaderException {
		languageModule.setId("nxd-module");
		languageModule.setProviderName("Number eXtra Dimension Module");
		languageModule.setProviderHost(PP_NXD_PROVIDER_HOST);
		languageModule.setDescription("Number eXtra Dimension Module Loader");
		
		addBindingHandler(languageModule,new V072TongBindingHandler(),"v072-bind","Binds the V072Tong childeren.");
		addBindingHandler(languageModule,new V072TongP1BindingHandler(),"v072P1-bind","Binds the V072TongP1 childeren.");
		addBindingHandler(languageModule,new V072TongP2BindingHandler(),"v072P2-bind","Binds the V072TongP2 childeren.");
		
		/*
		ElementNamespace namespaceRoot = createNamespaceContext(language,NXD_ROOT,NXD_ROOT_URI,NXD_ROOT_XSD_URI,NXD_ROOT_XSD_FILE,NXD_ROOT);
		namespaceRoot.setLanguageRoot(true); // Only define single language root so xsd is (mostly) not cicle import.
		ElementClass rootElement = createElementClass(language,"module",language.getLanguageConfiguration().getDefaultElementLanguageModule(),ModuleElement.class,"The module tag is the root xml element for ELD language.");
		rootElement.addElementClassAttribute(createElementClassAttribute(language,"id",true,null));
		rootElement.addElementClassAttribute(createElementClassAttribute(language,"providerHost",true,null));
		namespaceRoot.addElementClass(rootElement);
		startAndAddNamespace(language,languageModule,namespaceRoot);
		*/
		
		ElementNamespace namespace = createNamespaceContext(language,NXD_DATA,NXD_DATA_URI,NXD_DATA_XSD_URI,NXD_DATA_XSD_FILE,NXD_DATA);
		configElementClasses(language,namespace);
		startAndAddNamespace(language,languageModule,namespace);
	}
	
	private void configElementClasses(X4OLanguage language,ElementNamespace namespace) throws X4OLanguageModuleLoaderException {
		ElementClass ec = null;
		
		ec = createElementClass(language,"v006",V006Tixte.class,null,"Defines an V006Tixte number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"v009",V009Tyte.class,null,"Defines an V009Tyte number.");
		//configBãßBȍőnPartAttributes(language, ec, T03PartTrit.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"v018",V018Tord.class,null,"Defines an V018Tord number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"陸",V036Teger.class,null,"Defines an V036Teger number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"參",V072Tong.class,null,"Defines an V072Tong number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"肆",V072TongP1.class,null,"Defines an V072TongP1 number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		ec = createElementClass(language,"伍",V072TongP2.class,null,"Defines an V072TongP1 number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
		
		
		ec = createElementClass(language,"v144",V144Tocta.class,null,"Defines an V144Tocta number.");
		//configBãßBȍőnPartAttributes(language, ec, T02PartBinary.PART_1);
		namespace.addElementClass(ec);
	}
	
	private void configBãßBȍőnPartAttributes(X4OLanguage language,ElementClass ec, BãßBȍőnPartʸᴰ<?> basePart) throws X4OLanguageModuleLoaderException {
		for (BãßBȍőnPartʸᴰ<?> part: basePart.BãßInstances()) {
			ec.addElementClassAttribute(createElementClassAttribute(language,part.BȍőnChinaKey(),true,new BãßBȍőnPartDialToneConverter(part)));
		}
	}
	
	private void startAndAddNamespace(X4OLanguageLocal language,X4OLanguageModuleLocal languageModule,ElementNamespace namespace) throws X4OLanguageModuleLoaderException {
		try {
			namespace.getElementNamespaceInstanceProvider().start(language, namespace);
		} catch (ElementNamespaceInstanceProviderException e) {
			throw new X4OLanguageModuleLoaderException(this,"Error starting instance provider: "+e.getMessage(),e);
		}
		languageModule.addElementNamespace(namespace);
	}
	
	private ElementClassAttribute createElementClassAttribute(X4OLanguage language,String name,boolean required,ObjectConverter converter) throws X4OLanguageModuleLoaderException {
		try {
			ElementClassAttribute result = (ElementClassAttribute)X4OLanguageClassLoader.newInstance(language.getLanguageConfiguration().getDefaultElementClassAttribute());
			result.setId(name);
			if (required) {
				result.setRequired(required);
			}
			if (converter!=null) {
				result.setObjectConverter(converter);
			}
			return result;
		} catch (InstantiationException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} catch (IllegalAccessException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		}
	}
	
	private ElementClass createElementClass(X4OLanguage language,String tag,Class<?> objectClass,Class<?> elementClass,String description) throws X4OLanguageModuleLoaderException {
		try {
			ElementClass result = (ElementClass)X4OLanguageClassLoader.newInstance(language.getLanguageConfiguration().getDefaultElementClass());
			result.setId(tag);
			result.setObjectClass(objectClass);
			result.setElementClass(elementClass);
			result.setDescription(description);
			return result;
		} catch (InstantiationException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} catch (IllegalAccessException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		}
	}
	
	private ElementNamespace createNamespaceContext(X4OLanguageLocal language,String id,String uri,String schemaUri,String schemaResource,String schemaPrefix) throws X4OLanguageModuleLoaderException {
		ElementNamespace namespace;
		try {
			namespace = (ElementNamespace)X4OLanguageClassLoader.newInstance(language.getLanguageConfiguration().getDefaultElementNamespace());
		} catch (InstantiationException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} catch (IllegalAccessException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} 
		try {
			namespace.setElementNamespaceInstanceProvider((ElementNamespaceInstanceProvider)
				X4OLanguageClassLoader.newInstance(language.getLanguageConfiguration().getDefaultElementNamespaceInstanceProvider())
				);
		} catch (InstantiationException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} catch (IllegalAccessException e) {
			throw new X4OLanguageModuleLoaderException(this,e.getMessage(),e);
		} 
		
		namespace.setId(id);
		namespace.setUri(uri);
		namespace.setSchemaUri(schemaUri);
		namespace.setSchemaResource(schemaResource);
		namespace.setSchemaPrefix(schemaPrefix);
		return namespace;
	}
	
	private void addBindingHandler(X4OLanguageModuleLocal languageModule,ElementBindingHandler handler,String id,String description) {
		handler.setId(id);
		handler.setDescription(description);
		languageModule.addElementBindingHandler(handler);
	}
}
