package net.danielmelcer.cheekers.game;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import net.danielmelcer.cheekers.board.*;


/**
 * A JComponent that displays a board
 * @author Daniel Melcer
 * @see GUIBoard
 */
public class BoardDisplay extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7598192723973828059L;
	private volatile PieceType[][] currentBoard;
	private volatile int[][] moveNums;
	private int clickCount = 0;
	
	/**
	 * Constructs a BoardDisplay with the specified Board
	 * @param b The board to display
	 */
	BoardDisplay(Board b){
		this.currentBoard = b.getBoard();
		this.moveNums = new int[8][8];
		this.addMouseListener(new MouseAdapter(){
			@Override public void mouseClicked(MouseEvent e){
				BoardDisplay.this.processClick(e);
			}
		});
	}
	
	/**
	 * Gets the Move selected by the user and resets the move numbers
	 * @return The move the user selects
	 */
	public Move getMove(){
		Coordinate[] coordinates = new Coordinate[clickCount];
		for(int y = 0; y < 8; y++){
			for(int x = 0; x<8; x++){
				if(moveNums[y][x] != 0){
					coordinates[moveNums[y][x]-1] = new Coordinate(x,y);
				}
			}
		}
		
		resetMoveNums();
		this.repaint();
		return new Move(coordinates);
		
	}
	
	private void processClick(MouseEvent e){
		int width = this.getSize().width;
		int height = this.getSize().height;
		
		int gridx = (int) (e.getX()/((double)width/8));
		int gridy = (int) (e.getY()/((double)height/8));
		
		if(gridx > 7 || gridy>7) return;
		if(gridx < 0 || gridy < 0) return;
		
		if(moveNums[gridy][gridx] == 0) moveNums[gridy][gridx] = ++clickCount;
		this.repaint();
	}
	
	/**
	 * Deselects the currently selected move
	 */
	public void resetMoveNums(){
		moveNums = new int[8][8];
		clickCount = 0;
		this.repaint();
	}
	
	/**
	 * Updates the currently displayed board
	 * @param b The new board
	 */
	public void setBoard(Board b){
		currentBoard = b.getBoard();
		resetMoveNums();
		this.repaint();
	}
	

	
	@Override public void paint(Graphics g){
		int width = this.getSize().width;
		int height = this.getSize().height;
		
		g.setColor(new Color(209,139,71));
		g.fillRect(0, 0, width, height);
		
		
		int xSize = width/8;
		int ySize = height/8;
		
		for(int x = 0; x<8; x++){
			for(int y = 0; y<8; y++){
				int xpos = (width*x)/8;
				int ypos = (height*y)/8;
				if((x+y)%2==0){
					g.setColor(new Color(255,228,170));
					g.fillRect(xpos, ypos, xSize, ySize);
				}
				
				PieceType curPiece = currentBoard[y][x];
				if(curPiece == PieceType.BLACK || curPiece == PieceType.BLACK_KING){
					g.setColor(Color.BLACK);
					g.fillOval(xpos, ypos, xSize, ySize);
				}
				if(curPiece == PieceType.RED || curPiece == PieceType.RED_KING){
					g.setColor(Color.RED);
					g.fillOval(xpos, ypos, xSize, ySize);
				}
				if(curPiece == PieceType.BLACK_KING || curPiece == PieceType.RED_KING){
					int thirdX = xSize/3;
					int thirdY = ySize/3;
					g.setColor(Color.YELLOW);
					g.fillOval(xpos + thirdX, ypos + thirdY, thirdX, thirdY);
				}
				if(moveNums[y][x]!=0){
					g.setColor(Color.BLUE);
					g.drawString(moveNums[y][x]+"", xpos, ypos+12);
				}
			}
		}
		
		
	}
}