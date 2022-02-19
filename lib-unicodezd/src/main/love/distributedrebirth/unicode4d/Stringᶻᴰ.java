package love.distributedrebirth.unicode4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Stringᶻᴰ {

	private List<V072Tong> string;
	
	public Stringᶻᴰ(List<V072Tong> tongs) {
		this.string = tongs;
	}
	
	public int codePointSize() {
		return string.size() * 2;
	}
	
	public V036Teger getCodePointByIndex(int index) {
		V072Tong tong = string.get(index >> 1);
		if ((index & 1) == 0) {
			return tong.getValue(T02PartBinary.PART_1);
		} else {
			return tong.getValue(T02PartBinary.PART_2);
		}
	}
	
	public int charSize() {
		int result = 0;
		for (V072Tong points:string) {
			CodePointCommandᶻᴰ cmd = CodePointᶻᴰ.INSTANCE.getCommand(points.getValue(T02PartBinary.PART_1));
			if (cmd == CodePointCommandᶻᴰ.START) {
				result++;
			}
		}
		return result;
	}
	
	public Stringᶻᴰ concat(Stringᶻᴰ argu) {
		List<V072Tong> data = new ArrayList<>(string.size());
		data.addAll(string);
		data.addAll(argu.string);
		return new Stringᶻᴰ(data);
	}
}
