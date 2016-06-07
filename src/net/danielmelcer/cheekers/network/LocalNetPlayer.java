package net.danielmelcer.cheekers.network;

import net.danielmelcer.cheekers.board.Move;
import net.danielmelcer.cheekers.game.*;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

/**
 * This class represents a Local Player on the network. After receiving the move from the GUI, it transmits the move across the network.
 * @author Daniel Melcer
 *
 */
public class LocalNetPlayer extends HumanPlayer {

	private final Socket s;
	ObjectOutputStream o;
	
	/**
	 * Constructs a LocalNetPlayer with a socket
	 * @param s The socket to use
	 */
	public LocalNetPlayer(Socket s) throws IOException{
		this.s = s;
		 o = new ObjectOutputStream(s.getOutputStream());
	}
	
	/**
	 * Gets a move from the GUI and transmits it over the network. Returns null if there is a network error.
	 * @return Move The move that is selected
	 */
	@Override
	public Move requestMove(GameController gc) throws InterruptedException {
		Move m = super.requestMove(gc);
		
		try{
			System.out.println("Outputting object");
			o.writeObject(m);
		} catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Network error!");
			throw new InterruptedException("Network error");
		}
		
		return m;
	}
	
	@Override public void cleanUp(){
		try {
			s.close();
		} catch (IOException e) {
			//s is already closed
			//No action needed
		}
	}

}
