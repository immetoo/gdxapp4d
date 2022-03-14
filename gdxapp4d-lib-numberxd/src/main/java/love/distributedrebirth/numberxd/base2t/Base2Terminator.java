package love.distributedrebirth.numberxd.base2t;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.MBeanStoreKeyᴶᴹˣ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "Base2Terminator", purpose = "Terminate from and to classical bytes.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum Base2Terminator implements DefaultEnumInstanceᴶᴹˣ<Base2Terminator,MBeanStoreKeyᴶᴹˣ> {
	
	INSTANCE;
	
	private static final int STREAM_EOF = -1;
	private static final int BLOCK_TONG_SIZE = 9;
	private static final int BLOCK_TOCTA_SIZE = 18;
	private static final int SHIFT_8 = 8;
	private static final int SHIFT_16 = 16;
	private final GuageCounterᴶᴹˣ readV072TongInvokes;
	private final GuageCounterᴶᴹˣ readV072TongTypeReads;
	private final GuageCounterᴶᴹˣ readV072TongByteWrites;
	private final GuageCounterᴶᴹˣ readV144ToctaInvokes;
	private final GuageCounterᴶᴹˣ readV144ToctaTypeReads;
	private final GuageCounterᴶᴹˣ readV144ToctaByteWrites;
	private final GuageCounterᴶᴹˣ writeV072TongInvokes;
	private final GuageCounterᴶᴹˣ writeV072TongByteReads;
	private final GuageCounterᴶᴹˣ writeV072TongTypeWrites;
	private final GuageCounterᴶᴹˣ writeV144ToctaInvokes;
	private final GuageCounterᴶᴹˣ writeV144ToctaBytesReads;
	private final GuageCounterᴶᴹˣ writeV144ToctaTypeWrites;
	private final BãßBȍőnCoffinOpenʸᴰ<MBeanStoreKeyᴶᴹˣ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<MBeanStoreKeyᴶᴹˣ> GET_BBC() { return BBC; }
	
	private Base2Terminator() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(MBeanStoreKeyᴶᴹˣ.JMX);
		readV072TongInvokes = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV072TongInvokes");
		readV072TongTypeReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV072TongTypeReads");
		readV144ToctaInvokes = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV144ToctaInvokes");
		readV072TongByteWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV072TongByteWrites");
		readV144ToctaTypeReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV144ToctaTypeReads");
		readV144ToctaByteWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "readV144ToctaByteWrites");
		writeV072TongInvokes = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV072TongInvokes");
		writeV072TongByteReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV072TongByteReads");
		writeV072TongTypeWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV072TongTypeWrites");
		writeV144ToctaInvokes = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV144ToctaInvokes");
		writeV144ToctaBytesReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV144ToctaBytesReads");
		writeV144ToctaTypeWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "writeV144ToctaTypeWrites");
	}
	
	public int Bãß2ReadTong(InputStream input, List<V072Tong> output) throws IOException {
		int totalBytes = 0;
		byte[] data = new byte[BLOCK_TONG_SIZE];
		int readDataSize = 0; // per 9 bytes we have 24 octals for one V072Tong number
		while ((readDataSize = input.read(data, 0, data.length)) != STREAM_EOF) {
			Bãß2ReadCheckSize(readDataSize, BLOCK_TONG_SIZE);
			int v0 =  (data[0] & 0xFF) +  ((data[1] << SHIFT_8) & 0xFF00) +  ((data[2] << SHIFT_16) & 0xFF0000);
			int v1 =  (data[3] & 0xFF) +  ((data[4] << SHIFT_8) & 0xFF00) +  ((data[5] << SHIFT_16) & 0xFF0000);
			int v2 =  (data[6] & 0xFF) +  ((data[7] << SHIFT_8) & 0xFF00) +  ((data[8] << SHIFT_16) & 0xFF0000);
			List<T08PartOctal> octals = Bãß2ReadOctals(v0, v1, v2);
			output.add(new V072Tong(new BaseIteratorOctalAdapter(octals.iterator())));
			totalBytes += BLOCK_TONG_SIZE;
		}
		readV072TongInvokes.increment();
		readV072TongTypeReads.increment(output.size());
		readV072TongByteWrites.increment(totalBytes);
		return totalBytes;
	}
	
	public int Bãß2ReadTocta(InputStream input, List<V144Tocta> output) throws IOException {
		int totalBytes = 0;
		byte[] data = new byte[BLOCK_TOCTA_SIZE];
		int readDataSize = 0; // per 18 bytes we have 48 octals for one V144Tocta number
		while ((readDataSize = input.read(data, 0, data.length)) != STREAM_EOF) {
			Bãß2ReadCheckSize(readDataSize, BLOCK_TOCTA_SIZE);
			int v0 =  (data[0] & 0xFF) +  ((data[1] << SHIFT_8) & 0xFF00) +  ((data[2] << SHIFT_16) & 0xFF0000);
			int v1 =  (data[3] & 0xFF) +  ((data[4] << SHIFT_8) & 0xFF00) +  ((data[5] << SHIFT_16) & 0xFF0000);
			int v2 =  (data[6] & 0xFF) +  ((data[7] << SHIFT_8) & 0xFF00) +  ((data[8] << SHIFT_16) & 0xFF0000);
			int v3 =  (data[9] & 0xFF) + ((data[10] << SHIFT_8) & 0xFF00) + ((data[11] << SHIFT_16) & 0xFF0000);
			int v4 = (data[12] & 0xFF) + ((data[13] << SHIFT_8) & 0xFF00) + ((data[14] << SHIFT_16) & 0xFF0000);
			int v5 = (data[15] & 0xFF) + ((data[16] << SHIFT_8) & 0xFF00) + ((data[17] << SHIFT_16) & 0xFF0000);
			List<T08PartOctal> octals = Bãß2ReadOctals(v0, v1, v2, v3, v4, v5);
			output.add(new V144Tocta(new BaseIteratorOctalAdapter(octals.iterator())));
			totalBytes += BLOCK_TOCTA_SIZE;
		}
		readV144ToctaInvokes.increment();
		readV144ToctaTypeReads.increment(output.size());
		readV144ToctaByteWrites.increment(totalBytes);
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
		int totalBytes = Bãß2Write(data, output);
		output.flush();
		writeV072TongInvokes.increment();
		writeV072TongByteReads.increment(totalBytes);
		writeV072TongTypeWrites.increment(data.size());
		return totalBytes;
		
	}
	
	public int Bãß2WriteTocta(List<V144Tocta> data, OutputStream output) throws IOException {
		int totalBytes = Bãß2Write(data, output);
		output.flush();
		writeV144ToctaInvokes.increment();
		writeV144ToctaBytesReads.increment(totalBytes);
		writeV144ToctaTypeWrites.increment(data.size());
		return totalBytes;
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
