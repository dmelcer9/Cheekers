package net.danielmelcer.cheekers.network;
import net.danielmelcer.cheekers.board.*;
import net.danielmelcer.cheekers.game.*;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class RemotePlayer implements Player {

	Socket s;
	
	public RemotePlayer(Socket s){
		this.s = s;
	}
	
	
	@Override
	public Move requestMove(GameController gc) throws InterruptedException {
		try(ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
			return (Move) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Network error!");
			throw new InterruptedException("Network error");
		}
	}

}
