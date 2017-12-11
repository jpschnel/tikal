package code;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String _name; // name of the player written by Tim Weppner
	private int _score; // the score for the player written by Tim Weppner
	private int _AP; // the action points for the player written by Tim Weppner
	private ArrayList<GamePieces> _pieces; // the list of game pieces written by Tim Weppner
	
	public Player(String name){ // creates the player written by Tim Weppner
		_name = name; // gives him/her a name written by Tim Weppner
		_score = 0; // sets his/her score to 0 written by Tim Weppner
		GamePieces gp = new GamePieces();
		gp.createWrokers(); // populates the list of workers written by Tim Weppner
		_pieces = gp.getWorkers();
		_AP = 12; // sets the action points to 12 written by Tim Weppner
	}
	
	public String getName(){ //gives access to the players name written by Tim Weppner
		return _name;
	}
	
	public int getScore(){ //gives access to the players score written by Tim Weppner
		return _score;
	}
	
	public void addScore(int score){ // increments the score written by Tim Weppner
		_score += score;
	}
	
	public List<GamePieces> getPieces(){ //gives access to the players workers written by Tim Weppner
		return _pieces;
	}
	
	public int getActionPoints(){ //gives access to the players action points written by Tim Weppner
		return _AP;
	}
	
	public void resetAP(){ // resets the action points to 12 written by Tim Weppner
		_AP = 12;
	}
}
