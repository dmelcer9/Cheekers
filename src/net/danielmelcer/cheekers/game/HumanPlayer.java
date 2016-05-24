package net.danielmelcer.cheekers.game;

import java.util.concurrent.CountDownLatch;

import net.danielmelcer.cheekers.board.Move;

public class HumanPlayer implements Player {

	CountDownLatch moveSubmitted;
	Move moveToGet;
	
	@Override
	public Move requestMove(GameController gc) {
		moveSubmitted = new CountDownLatch(1);
		gc.getGui().setMoveListener(this::receiveMove);
		try {
			moveSubmitted.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return moveToGet;
	}
	
	public void receiveMove(Move m){
		this.moveToGet = m;
		this.moveSubmitted.countDown();
	}

}
