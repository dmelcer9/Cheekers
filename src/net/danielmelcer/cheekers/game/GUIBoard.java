package net.danielmelcer.cheekers.game;

import java.awt.Color;

/**
 * This class creates and displays the GUI for a checkers board. It will also take input and pass it to a MoveListener.
 * @author Daniel Melcer
 * @see MoveListener
 */
public class GUIBoard {
	
	private MoveListener ml;
	
	/**
	 * This will set a MoveListener to accept a move that is performed. Only one MoveListener can be set at a time.
	 * @param ml The MoveListener to notify
	 */
	public void setMoveListener(MoveListener ml){
		this.ml = ml;
	}
	
	/**
	 * Set the color of the "current turn" piece.
	 * @param c The color to set
	 */
	public void setColor(Color c){
		//TODO
	}
}
