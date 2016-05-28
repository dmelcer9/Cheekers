package net.danielmelcer.cheekers.game;

import java.util.concurrent.CountDownLatch;

import net.danielmelcer.cheekers.board.Move;

/**
 * An implementation of Player that gets its moves from a GUIBoard.
 * @author Daniel Melcer
 * @see GUIBoard
 */
public class HumanPlayer implements Player {

	private CountDownLatch moveSubmitted;
	private Move moveToGet;
	
	/**
	 * Gets move inputed by player. Note that this sets moveListener in GUIBoard.
	 * @param gc The GameController that is requesting the move
	 */
	@Override
	public Move requestMove(GameController gc) throws InterruptedException{
		moveSubmitted = new CountDownLatch(1);
		gc.getGui().setMoveListener(this::receiveMove);
		
		moveSubmitted.await();
		
		return moveToGet;
	}
	
	private void receiveMove(Move m){
		this.moveToGet = m;
		this.moveSubmitted.countDown();
	}

}
