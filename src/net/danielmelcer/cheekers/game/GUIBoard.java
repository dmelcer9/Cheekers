package net.danielmelcer.cheekers.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import net.danielmelcer.cheekers.board.*;

/**
 * This class creates and displays the GUI for a checkers board. It will also take input and pass it to a MoveListener.
 * @author Daniel Melcer
 * @see MoveListener
 */
public class GUIBoard extends JFrame {
	
	private MoveListener ml;
	private JPanel mainPanel;
	private BoardDisplay bd;
	
	public GUIBoard(Board b){
		super("Cheekers!");
		mainPanel = new JPanel();
		bd = new BoardDisplay(b);
	}
	
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
	
	private class BoardDisplay extends JComponent{
		
		private volatile Board currentBoard;
		
		BoardDisplay(Board b){
			this.currentBoard = b;
		}
		
		public void setBoard(Board b){
			currentBoard = b;
			this.invalidate();
		}
		
		@Override public void paint(Graphics g){
			
		}
	}
}
