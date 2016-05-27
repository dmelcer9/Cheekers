package net.danielmelcer.cheekers.board;

public enum SelectingPlayer {
	RED,
	BLACK;
	
	/**
	 * Returns the inversion of the current color
	 * @return The opposite of the current color
	 */
	public SelectingPlayer invert(){
		if(this == RED) return BLACK;
		else return RED;
	}
}
