package net.danielmelcer.cheekers.game;

import java.awt.*;
import javax.swing.*;

import net.danielmelcer.cheekers.board.*;

/**
 * This class creates and displays the GUI for a checkers board. It will also take input and pass it to a MoveListener.
 * @author Daniel Melcer
 * @see MoveListener
 * @see BoardDisplay
 */
public class GUIBoard extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5666037769829997576L;
	private MoveListener ml;
	private JPanel mainPanel;
	private BoardDisplay bd;
	
	private JButton colorButton;
	private JButton submitButton;
	private JButton resetMoveButton;
	
	/**
	 * Construct a GUIBoard with a given board
	 * @param b The board to use
	 */
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
		submitButton.addActionListener(e->{
			if(ml != null)ml.MoveSelected(bd.getMove());
		});
		c.gridheight = 1;
		c.weighty = 0.1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.CENTER;
		mainPanel.add(submitButton, c);
		
		this.add(mainPanel);
		this.setVisible(true);
		
	}
	
	/**
	 * Update the BoardDisplay with the selected board
	 * @param b The board to display
	 */
	public void updateBoard(Board b){
		bd.setBoard(b);
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
}
