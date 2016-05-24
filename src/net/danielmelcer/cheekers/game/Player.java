package net.danielmelcer.cheekers.game;

import net.danielmelcer.cheekers.board.*;

import java.util.*;
import java.util.concurrent.*;

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
	 */
	public Move requestMove(GameController gc);
	
}
