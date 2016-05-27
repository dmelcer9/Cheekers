package net.danielmelcer.cheekers.game;

import net.danielmelcer.cheekers.board.Board;

public class Driver {

	public static void main(String[] args) {
		new GameController(Board.getDefaultBoard(), new HumanPlayer(), new HumanPlayer(), new GUIBoard(Board.getDefaultBoard())).startGame();

	}

}
