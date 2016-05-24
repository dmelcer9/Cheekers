package net.danielmelcer.cheekers.game;
import net.danielmelcer.cheekers.board.*;

/**
 * A class for asynchronously getting a move from a source
 * @author Daniel Melcer
 * @see GUIBoard
 */
@FunctionalInterface
public interface MoveListener {

	/**
	 * This method is called when a move is selected
	 * @param m The selected move
	 */
	public void MoveSelected(Move m);
}
