package net.danielmelcer.cheekers.board;

/**
 * This enum is returned by the TestWin method in the Board class.
 * @author Daniel Melcer
 * @see Board
 */
public enum WinState {
	/**
	 * This represents a state where red wins the game.
	 */
	RED_WIN,
	
	/**
	 * This represents a state where black wins the game.
	 */
	BLACK_WIN,
	
	/**
	 * This represents a state where neither has won the game yet.
	 */
	NEITHER_WIN,
	
	/**
	 * The board is completely empty.
	 */
	EMPTY;
}
