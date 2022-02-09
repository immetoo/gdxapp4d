package love.distributedrebirth.numberxd.alu;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.BaseGetậl;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ŌctopǔsALU {

	public <T extends BaseGetậl<T,V>,V extends BaseNumber<V>>  BaseGetậl<T,V> math(BaseGetậl<T,V> opA, BaseGetậl<T,V> opB) {
		BaseIteratorOctal bioA = opA.iteratorOctalsByClone();
		BaseIteratorOctal bioB = opB.iteratorOctalsByClone();
		BaseIteratorOctalALU bioALU = new BaseIteratorOctalALU(bioA, bioB);
		BaseGetậl<T,V> result = opA.toClone(bioALU);
		return result;
	}
	
	enum ŌctopǔsArmZuigerInzet {
		OCTAL_1,   // T08PartOctal
		OCTAL_2,   // V006Tixte
		OCTAL_3,   // V009Tyte
		OCTAL_6,   // V018Tord
		OCTAL_9,   // V027Temvig
		OCTAL_12,  // V036Teger
		OCTAL_14,  // V042Traw
		OCTAL_24,  // V072Tong
		OCTAL_48,  // V144Tocta
		
		OCTAL_280,     // V0x000348ˣᴸ (V042Traw * 20)
		OCTAL_540,     // V0x000654ˣᴸ (V027Temvig * 60)
		OCTAL_1080,    // V0x000CA8ˣᴸ (V0x000654ˣᴸ * 2)
		OCTAL_1680,    // V0x0013B0ˣᴸ (V0x000348ˣᴸ * 6)
		
		OCTAL_8640_MATRIX,    // KlompGetậl4ˢᴰ (V0x000CA8ˣᴸ * 8)
		
		FRACTION_3,           // V009Tyte = digit aka digital hebrew BCD
		FRACTION_12_MATRIX,   // Gê̄ldGetậl    (V036Teger * 1_ or quad digit
		FRACTION_48_MATRIX,   // GroßGetậl1ⁿᴰ (V144Tocta * 1) or 7/9
		FRACTION_576_MATRIX,  // GroßGetậl6ˢᴰ (GroßGetậl1ⁿᴰ * 6)
		
		FRACTION_1680_MATRIX_X,  // WavẽWorstGetậl1ⁿᴰ (V0x0013B0ˣᴸ * x)
		FRACTION_1680_MATRIX_XY, // WavẽWorstGetậl2ⁿᴰ (V0x0013B0ˣᴸ * x * y)
		
	}
	
	class BaseIteratorOctalALU implements BaseIteratorOctal {

		private final BaseIteratorOctal bioA;
		private final BaseIteratorOctal bioB;
		
		public BaseIteratorOctalALU(BaseIteratorOctal bioA, BaseIteratorOctal bioB) {
			this.bioA = bioA;
			this.bioB = bioB;
		}
		
		@Override
		public boolean hasNext() {
			return bioA.hasNext();
		}

		@Override
		public T08PartOctal next() {
			T08PartOctal valA = bioA.next();
			T08PartOctal valB = bioB.next();
			
			int valANum = valA.BȍőnRangTelNul();
			int valBNum = valB.BȍőnRangTelNul();
			
			var valResultNum = valANum + valBNum;
			
			if (valResultNum > valA.BãßInstances().length) {
				valResultNum = valA.BãßInstances().length -1;
			}
			
			T08PartOctal valResult = T08PartOctal.values()[valResultNum];
			
			return valResult;
		}
	}
}
