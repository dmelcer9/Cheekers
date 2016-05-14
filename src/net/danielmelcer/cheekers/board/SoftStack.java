package net.danielmelcer.cheekers.board;


/**
 * This class manages a stack of a given type. References sufficiently below the top of the stack are placed into SoftReferences.
 * This means that if the JVM runs out of memory, it will start removing items from the stack.
 * @author Daniel Melcer
 *
 */
class SoftStack<T> {
	
	/**
	 * Constructs a SoftStack with a given limit. This will define how many strong references the SoftStack will store.
	 * Any additional items will push an item into a SoftReference
	 * @param strongReferenceLimit
	 */
	public SoftStack(int strongReferenceLimit){
		//TODO: Implement
	}
	
	/**
	 * Returns true if the next item is available
	 * @return A boolean corresponding to if an item is available
	 */
	public boolean available() throws IllegalStateException{
		//TODO: Implement
		return false;
	}
	
	/**
	 * Pushes an item onto the Stack
	 * @param element The item to add to the stack
	 */
	public void push(T element){
		//TODO: Implement
	}
	
	/**
	 * Removes and returns the top item from the stack
	 * @return The top item of the stack or null if none exists
	 */
	public T pop(){
		//TODO: Implement
		return null;
	}
}
