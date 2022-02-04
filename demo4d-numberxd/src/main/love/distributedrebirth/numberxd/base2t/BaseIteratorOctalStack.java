package love.distributedrebirth.numberxd.base2t;

import java.util.Stack;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Stack model for octal iterators.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseIteratorOctalStack implements BaseIteratorOctal {

	private final Stack<BaseIteratorOctal> stack = new Stack<>();
	
	public BaseIteratorOctalStack() {
	}
	
	public void addIterator(BaseIteratorOctal iterator) {
		stack.push(iterator);
	}
	
	@Override
	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		}
		if (stack.peek().hasNext()) {
			return true;
		}
		stack.pop();
		if (stack.isEmpty()) {
			return false;
		}
		return stack.peek().hasNext();
	}

	@Override
	public T08PartOctal next() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("Stack is empty.");
		}
		return stack.peek().next();
	}
}
