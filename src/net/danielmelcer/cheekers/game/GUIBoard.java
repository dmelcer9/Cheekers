package net.danielmelcer.cheekers.game;

import java.awt.*;

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
		
		submitButton = new JButton("Submit move");
		submitButton.setToolTipText("Submits the move.");
		c.gridheight = 2;
		c.weighty = 0.1;
		c.gridy = 3;
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
