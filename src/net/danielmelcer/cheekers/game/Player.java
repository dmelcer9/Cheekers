package net.danielmelcer.cheekers.game;

import net.danielmelcer.cheekers.board.*;

/**
 * The Player interface allows a GameController to request a move from a player
 * @author Daniel Melcer
 * @see GameController
 */
public interface Player {
	
	/**
	 * Request a move from the player
	 * @param gc The GameController making the request
	 * @return The requested move
	 * @throws InterruptedException If the game is interrupted
	 */
	public Move requestMove(GameController gc) throws InterruptedException;
	
	/**
	 * Performs cleanup actions after the game finishes or is stopped
	 */
	public default void cleanUp(){
		
	}
	
}
