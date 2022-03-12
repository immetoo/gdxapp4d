package love.distributedrebirth.unicode4d.atlas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalAdapter;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class FontAtlasStoreGlyph {

	private List<V072Tong> tongs = new ArrayList<>();
	
	public FontAtlasStoreGlyph() {
	}
	
	public List<V072Tong> getTongs() {
		return tongs;
	}
	
	public void setTongs(List<V072Tong> glyph) {
		this.tongs = glyph;
	}
	
	public void addTong(V072Tong glyph) {
		this.tongs.add(glyph);
	}

	public List<T08PartOctal> getOct64() {
		List<T08PartOctal> result = new ArrayList<>();
		BaseAppenderOctal appender = new BaseAppenderOctal(result);
		for (V072Tong tong: tongs) {
			tong.fillOctalsByClone(appender);
		}
		return result;
	}
	
	public void setOct64(List<T08PartOctal> data) {
		BaseIteratorOctalAdapter adapter = new BaseIteratorOctalAdapter(data.iterator());
		List<V072Tong> result = new ArrayList<>();
		while (adapter.hasNext()) {
			result.add(new V072Tong(adapter));
		}
		tongs = result;
	}
	
	public byte[] getByte64() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Base2Terminator.INSTANCE.Bãß2WriteTong(tongs, baos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return baos.toByteArray();
	}
	
	public void setByte64(byte[] decodedBytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);
		try {
			List<V072Tong> result = new ArrayList<>();
			Base2Terminator.INSTANCE.Bãß2ReadTong(bais, result);
			tongs = result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getBase64() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Base2Terminator.INSTANCE.Bãß2WriteTong(tongs, baos);
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
			tongs = result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
