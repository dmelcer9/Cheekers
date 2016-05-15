package net.danielmelcer.cheekers.board;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class manages a stack of a given type. References sufficiently below the top of the stack are placed into SoftReferences.
 * This means that if the JVM runs out of memory, it will start removing items from the stack.
 * @author Daniel Melcer
 * @see BoardHistory
 */
public class SoftStack<T> {
	
	private int strongLimit;
	
	private Stack<SoftReference<T>> softr;
	private LinkedList<T> strongr;
	
	/**
	 * Constructs a SoftStack with a given limit. This will define how many strong references the SoftStack will store.
	 * Any additional items will push an item into a SoftReference
	 * @param strongReferenceLimit The maximum number of items before Soft references are used
	 */
	public SoftStack(int strongReferenceLimit){
		this.strongLimit = strongReferenceLimit;
		
		softr = new Stack<>();
		strongr = new LinkedList<>();
		
	}
	
	private void shiftElements(){
		
		boolean softEmpty = softr.isEmpty() || (softr.peek().get() == null);
		if(softEmpty) softr.clear();
		
		if(strongr.size() <= strongLimit){
			if(softEmpty){
				return;
			} else{
				while(!softEmpty && strongr.size() < strongLimit){
					strongr.addLast(softr.pop().get());
					softEmpty = softr.isEmpty() || (softr.peek().get() == null);
				}
			}
		} else{
			while(strongr.size() > strongLimit){
				softr.add(new SoftReference<>(strongr.removeLast()));
			}
		}
		
	}
	
	/**
	 * Returns true if the next item is available
	 * @return A boolean corresponding to if an item is available
	 */
	public boolean available(){
		shiftElements();
		return !strongr.isEmpty();
	}
	
	/**
	 * Pushes an item onto the Stack
	 * @param element The item to add to the stack
	 */
	public void push(T element){
		strongr.addFirst(element);
		shiftElements();
	}
	
	/**
	 * Removes and returns the top item from the stack
	 * @return The top item of the stack or null if none exists
	 */
	public T pop(){
		if(!available()) return null;
		T ret = strongr.removeFirst();
		shiftElements();
		return ret;
	}
}
