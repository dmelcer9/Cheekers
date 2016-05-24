package net.danielmelcer.cheekers.game;

import net.danielmelcer.cheekers.board.*;

import java.util.*;
import java.util.concurrent.*;


public interface Player {
	
	
	public Move requestMove(GameController gc);
	
}
