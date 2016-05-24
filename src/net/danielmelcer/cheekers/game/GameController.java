package net.danielmelcer.cheekers.game;

import java.awt.Color;

import net.danielmelcer.cheekers.board.*;

public class GameController {

	private Board currentBoard;
	private Player player1;
	private Player player2;
	private GUIBoard gui;
	
	public GameController(Board startingBoard, Player p1, Player p2, GUIBoard gui){
		this.currentBoard = startingBoard;
		
		this.player1 = p1;
		this.player2 = p2;
		
		this.gui = gui;
	}
	
	public void setColor(Color c){
		gui.setColor(c);
	}
	
	public GUIBoard getGui(){
		return gui;
	}
	
	public void startGame(){
		while(currentBoard.getWinState() == WinState.NEITHER_WIN){
			//TODO
		}
	}
	
	private Board MakeMove(Move m) throws IllegalArgumentException{
		Board newBoard = currentBoard.makeMove(m);
		
		currentBoard = newBoard;
		return newBoard;
	}
}
