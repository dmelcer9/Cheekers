package net.danielmelcer.cheekers.game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import net.danielmelcer.cheekers.board.*;

/**
 * This class creates and displays the GUI for a checkers board. It will also take input and pass it to a MoveListener.
 * @author Daniel Melcer
 * @see MoveListener
 */
public class GUIBoard extends JFrame {
	
	public static void main(String[] args){
		new GUIBoard(Board.getDefaultBoard());
	}
	
	private MoveListener ml;
	private JPanel mainPanel;
	private BoardDisplay bd;
	
	private JButton colorButton;
	private JButton submitButton;
	private JButton resetMoveButton;
	
	public GUIBoard(Board b){
		super("Cheekers!");
		this.setSize(640, 480);
		this.setLocationByPlatform(true);
		this.setMinimumSize(new Dimension(360, 240));
		
		mainPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.gridheight = 5;
		c.gridwidth = 2;
		c.insets = new Insets(10,10,10,10);
		c.weightx = 1;
		c.weighty = 1;
		bd = new BoardDisplay(b);
		
		mainPanel.add(bd, c);
		c.weighty = 0;
		colorButton = new JButton();
		colorButton.setMinimumSize(new Dimension(100,100));
		colorButton.setBackground(Color.black);
		colorButton.setEnabled(false);
		c.gridx = 2;
		c.weightx = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		mainPanel.add(colorButton, c);
		
		JLabel nextMoveLabel = new JLabel("Next Move");
		c.gridheight = 1;
		c.weightx = 0;
		
		c.gridy = 1;
		
		c.anchor = GridBagConstraints.NORTH;
		mainPanel.add(nextMoveLabel, c);
		
		JComponent filler = new JLabel();
		c.weighty = 1;
		c.gridy=2;
		mainPanel.add(filler,c);
		
		resetMoveButton = new JButton("Reset Move");
		c.gridheight = 1;
		c.weighty = 0.05;
		c.gridy=3;
		mainPanel.add(resetMoveButton,c);
		resetMoveButton.addActionListener((e)->bd.resetMoveNums());
		
		submitButton = new JButton("Submit move");
		submitButton.setToolTipText("Submits the move.");
		c.gridheight = 1;
		c.weighty = 0.1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.CENTER;
		mainPanel.add(submitButton, c);
		
		this.add(mainPanel);
		this.setVisible(true);
		
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
		colorButton.setBackground(c);
	}
	
	private class BoardDisplay extends JComponent{
		
		private volatile PieceType[][] currentBoard;
		private volatile int[][] moveNums;
		private int clickCount = 0;
		
		BoardDisplay(Board b){
			this.currentBoard = b.getBoard();
			this.moveNums = new int[8][8];
			this.addMouseListener(new MouseAdapter(){
				@Override public void mouseClicked(MouseEvent e){
					BoardDisplay.this.processClick(e);
				}
			});
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
		
		public void resetMoveNums(){
			moveNums = new int[8][8];
			clickCount = 0;
			this.repaint();
		}
		
		public void setBoard(Board b){
			currentBoard = b.getBoard();
			this.repaint();
		}
		
	
		
		@Override public void paint(Graphics g){
			int width = this.getSize().width;
			int height = this.getSize().height;
			float[] c = Color.RGBtoHSB(255,228,270, null);
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
					if(moveNums[y][x]!=0){
						g.setColor(new Color(0,0,0));
						g.drawString(moveNums[y][x]+"", xpos, ypos+12);
					}
					PieceType curPiece = currentBoard[y][x];
					if(curPiece == PieceType.BLACK || curPiece == PieceType.BLACK_KING){
						g.setColor(new Color(0,0,0));
						g.fillOval(xpos, ypos, xSize, ySize);
					}
					if(curPiece == PieceType.RED || curPiece == PieceType.RED_KING){
						g.setColor(new Color(255,0,0));
						g.fillOval(xpos, ypos, xSize, ySize);
					}
					if(curPiece == PieceType.BLACK_KING || curPiece == PieceType.RED_KING){
						int thirdX = xSize/3;
						int thirdY = ySize/3;
						g.fillOval(xpos + thirdX, ypos + thirdY, thirdX, thirdY);
					}
					
				}
			}
			
			
		}
	}
}
