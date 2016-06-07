package net.danielmelcer.cheekers.network;
import net.danielmelcer.cheekers.board.*;
import net.danielmelcer.cheekers.game.*;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

/**
 * This class represents a player on the other side of a network.
 * @author Daniel Melcer
 *
 */
public class RemotePlayer implements Player {

	private Socket s;
	ObjectInputStream ois;
	
	/**
	 * Constructs a RemotePlayer with the specified socket
	 * @param s
	 */
	public RemotePlayer(Socket s) throws IOException{
		this.s = s;
		
			ois = new ObjectInputStream(s.getInputStream());
		
	}
	
	
	@Override
	public Move requestMove(GameController gc) throws InterruptedException {
		try{
			System.out.println("Inputting object");
			return (Move) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Network error!");
			throw new InterruptedException("Network error");
		}
	}

}
