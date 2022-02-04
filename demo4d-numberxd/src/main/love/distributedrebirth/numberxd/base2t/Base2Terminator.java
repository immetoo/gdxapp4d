package love.distributedrebirth.numberxd.base2t;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumInstanceʸᴰ;
import love.distributedrebirth.numberxd.base2t.glyph.BãßBȍőnGlyphSetKeyʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;

/**
 * Terminate from and to classical bytes.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public enum Base2Terminator implements BãßBȍőnEnumInstanceʸᴰ<Base2Terminator> {
	
	INSTANCE;
	
	private static final int STREAM_EOF = -1;
	private static final int BLOCK_TONG_SIZE = 9;
	private static final int BLOCK_TOCTA_SIZE = 18;
	private static final int SHIFT_8 = 8;
	private static final int SHIFT_16 = 16;
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> GET_BBC() { return BBC; }
	
	private Base2Terminator() {
		BBC.INIT_BOON(this);
	}
	
	public int Bãß2ReadTong(InputStream input, List<V072Tong> output) throws IOException {
		int totalBytes = 0;
		byte[] data = new byte[BLOCK_TONG_SIZE];
		int readDataSize = 0; // per 9 bytes we have 24 octals for one V072Tong number
		while ((readDataSize = input.read(data, 0, data.length)) != STREAM_EOF) {
			Bãß2ReadCheckSize(readDataSize, BLOCK_TONG_SIZE);
			int v0 =  data[0] +  (data[1] << SHIFT_8) +  (data[2] << SHIFT_16);
			int v1 =  data[3] +  (data[4] << SHIFT_8) +  (data[5] << SHIFT_16);
			int v2 =  data[6] +  (data[7] << SHIFT_8) +  (data[8] << SHIFT_16);
			List<T08PartOctal> octals = Bãß2ReadOctals(v0, v1, v2);
			output.add(new V072Tong(new BaseIteratorOctalAdapter(octals.iterator())));
			totalBytes += BLOCK_TONG_SIZE;
		}
		return totalBytes;
	}
	
	public int Bãß2ReadTocta(InputStream input, List<V144Tocta> output) throws IOException {
		int totalBytes = 0;
		byte[] data = new byte[BLOCK_TOCTA_SIZE];
		int readDataSize = 0; // per 18 bytes we have 48 octals for one V144Tocta number
		while ((readDataSize = input.read(data, 0, data.length)) != STREAM_EOF) {
			Bãß2ReadCheckSize(readDataSize, BLOCK_TOCTA_SIZE);
			int v0 =  data[0] +  (data[1] << SHIFT_8) +  (data[2] << SHIFT_16);
			int v1 =  data[3] +  (data[4] << SHIFT_8) +  (data[5] << SHIFT_16);
			int v2 =  data[6] +  (data[7] << SHIFT_8) +  (data[8] << SHIFT_16);
			int v3 =  data[9] + (data[10] << SHIFT_8) + (data[11] << SHIFT_16);
			int v4 = data[12] + (data[13] << SHIFT_8) + (data[14] << SHIFT_16);
			int v5 = data[15] + (data[16] << SHIFT_8) + (data[17] << SHIFT_16);
			List<T08PartOctal> octals = Bãß2ReadOctals(v0, v1, v2, v3, v4, v5);
			output.add(new V144Tocta(new BaseIteratorOctalAdapter(octals.iterator())));
			totalBytes += BLOCK_TOCTA_SIZE;
		}
		return totalBytes;
	}
	
	private void Bãß2ReadCheckSize(int readDataSize, int expectedSize) throws IOException {
		if (readDataSize < expectedSize) {
			throw new IOException("Expected "+expectedSize+" bytes, got: "+readDataSize);
		}
	}
	
	private List<T08PartOctal> Bãß2ReadOctals(int...values) {
		List<T08PartOctal> octals = new ArrayList<>();
		for (int value:values) {
			T08PartOctal.PART_1.BãßVoorElk(v -> octals.add(T08PartOctal.indexOf(v, value)));
		}
		return octals;
	}
	
	public int Bãß2WriteTong(List<V072Tong> data, OutputStream output) throws IOException {
		return Bãß2Write(data, output);
	}
	
	public int Bãß2WriteTocta(List<V144Tocta> data, OutputStream output) throws IOException {
		return Bãß2Write(data, output);
	}
	
	private <T extends BaseNumber<T>> int Bãß2Write(List<T> data, OutputStream output) throws IOException {
		int totalBytes = 0; // per 8 octa's is 3 bytes
		List<T08PartOctal> octals = new ArrayList<>();
		BaseAppenderOctal appender = new BaseAppenderOctal(octals);
		data.forEach(v -> v.fillOctalsByClone(appender));
		Iterator<T08PartOctal> read = octals.iterator();
		while (read.hasNext()) {
			int byteTriplet = 0;
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_1);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_2);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_3);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_4);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_5);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_6);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_7);
			byteTriplet += read.next().ordinalOf(T08PartOctal.PART_8);
			output.write(byteTriplet);
			output.write(byteTriplet >> SHIFT_8);
			output.write(byteTriplet >> SHIFT_16);
			totalBytes += 3;
		}
		return totalBytes;
	}
}
