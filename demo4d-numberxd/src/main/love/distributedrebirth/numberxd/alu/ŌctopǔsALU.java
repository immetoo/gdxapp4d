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
