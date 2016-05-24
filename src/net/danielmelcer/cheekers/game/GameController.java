package net.danielmelcer.cheekers.game;

import java.awt.Color;

import net.danielmelcer.cheekers.board.*;

/**
 * This class controls the basic flow of the checkers game
 * @author Daniel Melcer
 *
 */
public class GameController {

	private Board currentBoard;
	private Player player1;
	private Player player2;
	private GUIBoard gui;
	
	/**
	 * Construct a GameController with the indicated parameters
	 * @param startingBoard The starting configuration of the board. 
	 * @param p1 The red player
	 * @param p2 The black player
	 * @param gui The instance of GUIBoard to use
	 */
	public GameController(Board startingBoard, Player red, Player black, GUIBoard gui){
		this.currentBoard = startingBoard;
		
		this.player1 = red;
		this.player2 = black;
		
		this.gui = gui;
	}
	
	/**
	 * Sets the color of the current piece in GUIBoard
	 * @param c The color for the current turn
	 */
	public void setColor(Color c){
		gui.setColor(c);
	}
	
	/**
	 * Returns an instance of the GUIBoard
	 * @return The current GUIBoard
	 */
	public GUIBoard getGui(){
		return gui;
	}
	
	/**
	 * This method starts the game and calls the relevant methods of the Player objects
	 */
	public void startGame(){
		while(currentBoard.getWinState() == WinState.NEITHER_WIN){
			//TODO
		}
	}
	
	/**
	 * This method attempts to make a given move. If the move succeeds, the new move is stored in the GameController
	 * @param m The move to make
	 * @return The new state of the board
	 * @throws IllegalArgumentException If the move is illegal
	 */
	private Board MakeMove(Move m, SelectingPlayer sp) throws IllegalArgumentException{
		Board newBoard = currentBoard.makeMove(m, null);
		//TODO
		currentBoard = newBoard;
		return newBoard;
	}
}
