package love.distributedrebirth.numberxd.x4o;

import java.util.Locale;

import org.x4o.xml.conv.AbstractStringObjectConverter;
import org.x4o.xml.conv.ObjectConverter;
import org.x4o.xml.conv.ObjectConverterException;

import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

public class BãßBȍőnPartDialToneConverter extends AbstractStringObjectConverter {

	private static final long serialVersionUID = -6130905265398185836L;
	private final BãßBȍőnPartʸᴰ<?> basePart;
	
	public BãßBȍőnPartDialToneConverter(BãßBȍőnPartʸᴰ<?> basePart) {
		this.basePart = basePart;
	}
	
	@Override
	public Class<?> getObjectClassTo() {
		return basePart.getClass();
	}

	@Override
	public String convertStringBack(Object obj, Locale locale) throws ObjectConverterException {
		return BãßBȍőnPartʸᴰ.class.cast(obj).BȍőnDialTone();
	}

	@Override
	public Object convertStringTo(String str, Locale locale) throws ObjectConverterException {
		return basePart.BãßValueOfDialTone(str);
	}

	@Override
	public ObjectConverter clone() throws CloneNotSupportedException {
		return new BãßBȍőnPartDialToneConverter(basePart);
	}
}
