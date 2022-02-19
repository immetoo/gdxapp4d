package love.distributedrebirth.unicode4d.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class UnicodePlaneBaseGlyph {

	private String unicode;
	private List<V072Tong> glyph = new ArrayList<>();
	
	public UnicodePlaneBaseGlyph() {
	}
	
	public String getUnicode() {
		return unicode;
	}
	
	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
	
	public List<V072Tong> getGlyph() {
		return glyph;
	}
	
	public void setGlyph(List<V072Tong> glyph) {
		this.glyph = glyph;
	}
	
	public void addGlyph(V072Tong glyph) {
		this.glyph.add(glyph);
	}
	
	public String getBase64() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Base2Terminator.INSTANCE.Bãß2WriteTong(glyph, baos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
	
	public void setBase64(String base64) {
		byte[] decodedBytes = Base64.getDecoder().decode(base64);
		ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);
		try {
			List<V072Tong> result = new ArrayList<>();
			Base2Terminator.INSTANCE.Bãß2ReadTong(bais, result);
			glyph = result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
