package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Game {//Add implements when we create a game iterator
	private Board _board; // holds the reference to the board written by Tim Weppner
	private Player _playerTurn; // holds a reference to the player whose turn it is written by Tim Weppner
	//private ArrayList<GamePieces> _pieces; // a list of all the explorers written by Tim Weppner
	static ArrayList<Player> _order; // a list showing the order of the players written by Tim Weppner
	private boolean _isStarted; // shows if the game is started  written by Tim Weppner
	private Tile _tile; // holds reference to a non volcano tile written by Tim Weppner
	private Tile _volcano; // holds reference to a volcano tile written by Tim Weppner
	private int _numberOfPlayers; // represents the numerical value of players written by Tim Weppner
	private ArrayList<Tile> _tiles; // the list of tiles that the players pick from written by Tim Weppner
	private Formula _formula; // the algorithm that decides how much of everything is needed written by Tim Weppner
	private ArrayList<Pyramid> _pyramids; // list of the pyramid pieces written by Tim Weppner
	private HashMap<Player, Integer> _playerScoring; // a way to correlate the player with their score written by Tim Weppner
	private int  _pathX6ToX3; // the relationship between a tiles X6 position and the tile adjacent to its' X3 position written by Tim Weppner
	private int  _pathX5ToX2; // the relationship between a tiles X5 position and the tile adjacent to its' X3 position written by Tim Weppner
	private int  _pathX4ToX1; // the relationship between a tiles X4 position and the tile adjacent to its' X3 position written by Tim Weppner
	private int  _pathX3ToX6; // the relationship between a tiles X3 position and the tile adjacent to its' X3 position written by Tim Weppner
	private int  _pathX2ToX5; // the relationship between a tiles X2 position and the tile adjacent to its' X3 position written by Tim Weppner
	private int  _pathX1ToX4; // the relationship between a tiles X1 position and the tile adjacent to its' X3 position written by Tim Weppner
	private boolean _firstTurn; // true if first turn, else false written by Tim Weppner
	public Tile _tilePlacedThisTurn; // holds reference to the tile placed this turn written by Tim Weppner
	public int _colOfTilePlacedThisTurn; // shows the column of the tile placed this turn written by Tim Weppner
	public int _rowOfTilePlacedThisTurn; // shows the row of the tile placed this turn written by Tim Weppner
	
	
	public Game(){ // Initializes the game written by Tim Weppner
		//GamePieces gp = new GamePieces();
	    //gp.createWrokers();
	    //gp.getWorkers();
		//_pieces = new ArrayList<GamePieces>();
		_pathX6ToX3 = 0; // no path written by Tim Weppner
		_pathX5ToX2 = 0; // no path written by Tim Weppner
		_pathX4ToX1 = 0; // no path written by Tim Weppner
		_pathX3ToX6 = 0; // no path written by Tim Weppner 
		_pathX2ToX5 = 0; // no path written by Tim Weppner
		_pathX1ToX4 = 0; // no path written by Tim Weppner
		_firstTurn = true; // it is the first turn written by Tim Weppner
		_tiles = new ArrayList<Tile>(); // creates a new arraylist of tiles written by Tim Weppner
		_order = new ArrayList<Player>(); // creates a new arraylist of players written by Tim Weppner
		_isStarted = false; // is false until the start method is initiated written by Tim Weppner
		_pyramids = new ArrayList<Pyramid>(); // creates a new arraylist of pyramid pieces written by Tim Weppner
		_formula = new Formula(_numberOfPlayers); // creates the formula usint the number of players written by Tim Weppner
		_board = new Board(_formula.boardFormula(), _formula.boardFormula()); // creates the board based of the algorithm written by Tim Weppner
		_playerScoring = new HashMap<Player, Integer>(); // creates a coordinate system which matches a a player with their score written by Tim Weppner
		createPyramid(_formula.numberOfPyramidPieces()); // creates the pyramid pieces and populates _pyramids written by Tim Weppner
		createTiles(_formula.boardFormula()); // creates the tiles and populates _tiles written by Tim Weppner
		Collections.shuffle(_tiles); // shuffles the list of tiles written by Tim Weppner
		_tiles.get(0).setFirstTile(); // sets the first tile in the list to the first tile in the game written by Tim Weppner
	}

	public ArrayList<Player> orderOfPlay(){  // a method which states the order of the players
		return _order;
	}
	
	public void setOrderOfPlay(ArrayList<Player> p){ // sets the order of play to be the given arraylist
		_order = p;
		_playerTurn = _order.get(0);
	}
	
	public int score(Player player){ // returns the score of a specific player
		return player.getScore();
	}
	
	public boolean register(Player player){ // creates a player, adds them to _order, increases the number of players
		if(!_order.contains(player) && player != null && !_isStarted){
			_order.add(player);
			_numberOfPlayers++;
            _playerScoring.put(player, 0);
			return true;
		}
		return false;
	}
	
	public boolean start(){ // starts the game
		if(_order.size() < 2 || _isStarted){
			return false;
		}
		ArrayList<Player> players = new ArrayList<Player>();
		for(Player p : _order){
			players.add(p);
		}
		_order.clear();
		while(!players.isEmpty()){
			int index = new Random().nextInt(players.size());
			_playerTurn = players.get(index);
			//this
			this._playerTurn.resetAP();
			_order.add(players.get(index));
			players.remove(index);
		}
		_playerTurn = _order.get(0);
		_isStarted = true;
		return true;
	}
	
//	public int lootyBooty(){ // would have been used if the loot had been in the game
//		int score = 0;
//		int loot = 1;
//		int pyramid = 0;
//		score = score + loot + pyramid;
//		return score;
//	}
	
	public boolean endTurn(){ // ends the turn
		if(_board.getTilePlacedThisTurn() != null || _tile == _volcano){
			_firstTurn = false;
			return true;
		}else{
			return false;
		}
	}
	
	public Player getPlayerTurn(){ // tells whose turn it is
		return _playerTurn;
	}
	
	public Board getBoard(){ // returns the board
		return _board;
	}
	
	public void endGame(){ // ends the game
		Player winner = _order.get(0);
		for(Player player : _order){
			if(player.getScore() > winner.getScore()){
				winner = player;
			}
			System.out.println(player.getName() + ":" + player.getScore());
		}
		System.out.println("This game's winner is" + winner.getName() + "with" + winner.getScore() + "points.");
	}
	
	public String saveGame(){ // saves the game in a text file
		String data = "";
		int index = _order.indexOf(getPlayerTurn());
		for(int i = 0; i < _order.size(); i++){
			if(index + i >= _order.size()){
				Player player = _order.get(index + i - _order.size());
				data += player.getName() + " ";
				data += player.getActionPoints();
				data += " " + player.getScore() + " ";
			} else {
				Player player = _order.get(index + i);
				data += player.getName() + " ";
				data += " " + player.getScore() + " ";
			}
		}
		return data;
	}
	
	public int getNumberOfPlayers(){ // tells the number of players
		return _numberOfPlayers;    
	}
	
	private void createTiles(int x){ // randomly creates tiles and adds them to the list of tiles written by Tim Weppner
		int pyramid1 = 0;
		int x1 = 0;
		int x2 = 0; 
		int x3 = 0;
		int x4 = 0;
		int x5 = 0;
		int x6 = 0;
		int trueX =0;
		trueX = x - _numberOfPlayers;
		for(int t = 0; t<_numberOfPlayers; t++){
			Tile t1 = new Tile(0,0,0,0,0,0,0,true, false);
			_tiles.add(t1);
		}
		Random randomGenerator = new Random();
	    for (int i = 1; i <= trueX; ++i){
	    	
	    	int pyramidExistence = randomGenerator.nextInt(2);
	    	if(pyramidExistence == 1){
	    		pyramid1 = 1;
	    	}
	    	else{
	    		pyramid1 = 0;
	    	}
	    	for(int k = 1; k<=3 ; k++){
	    		int state = randomGenerator.nextInt(6);
	    	switch(state){
	    	 case 1:
	    		 int stones1 = randomGenerator.nextInt(2);
	    		 x1 = stones1;	
	    		 break;
	    	 case 2:
	    		 int stones2 = randomGenerator.nextInt(2);
	    		 x2 = stones2;
	    		 break;
	    	 case 3:
	    		 int stones3 = randomGenerator.nextInt(2);
	    		 x3 = stones3;
	    		 break;
	    	 case 4:
	   			 int stones4 = randomGenerator.nextInt(2);
	   			 x4 = stones4;
	   			 break;
	    	 case 5:
 	   			 int stones5 = randomGenerator.nextInt(2);
 	   			 x5 = stones5;
 	   			 break;
	    	 case 6:
	   			 int stones6 = randomGenerator.nextInt(2);
	   			 x6 = stones6;
	   			 break;
	    	}
	     }
	    	Tile t = new Tile(x1, x2, x3, x4, x5, x6, pyramid1, false, false);
	    	_tiles.add(t);
	    }
	}
	
	private void createPyramid(int x){// creates the pyramid and adds them to the list of pyramid pieces written by Tim Weppner
	    for(int i = 0; i<x; i++){
	    	Pyramid p = new Pyramid();
	    	p.setPyramidValue(1);
	    	_pyramids.add(p);
	   	}
	   	for(int i = 0; i<x-2; i++){
	   		Pyramid p = new Pyramid();
	   		p.setPyramidValue(2);
	    	_pyramids.add(p);	    		
	   	}
		for(int i = 0; i<x-4; i++){
			Pyramid p = new Pyramid();
			p.setPyramidValue(3);
	    	_pyramids.add(p);
		}
		for(int i = 0; i<x-6; i++){
			Pyramid p = new Pyramid();
			p.setPyramidValue(4);
	    	_pyramids.add(p);
		}
	}
	
	public void scoringRound(){ // startes a scoring round
		for(int i = 0; i < _order.size(); i++){
			_order.get(i).addScore(0);;
		}
	}
	public void placeTile(Tile t, int x , int y) { // places the tile, or throws an exception written by Tim Weppner
		if(validPlacement(t,x,y)==true){
			_board.placeTile(t, x, y);
		}
		else{
			 new Ah_Ah_Ah_You_Didnt_Say_The_Magic_Word_Exception(); 
		}
		
	}
	public boolean validPlacement(Tile t, int x, int y){ // shows whether or not you can place a tile or not by checking if there is a path from one to the other written by Tim Weppner
		_tilePlacedThisTurn = t; 
		_rowOfTilePlacedThisTurn = x;
		_colOfTilePlacedThisTurn = y;
		if(_firstTurn == true){
			if( x==0 || x == _formula.boardFormula()){
				if(y==0||y==_formula.boardFormula()){
					return true;
				}
				return false;
			}
			return false;
		}
		resetPaths();
		 _board.placeTile(t, x, y);
		  if(t.getX6()+_board.getTop().getX3() !=0 && _board.getTop().isVolcano() == false){
			  _pathX6ToX3 = t.getX6()+_board.getTop().getX3();
		  }
		  else if(t.getX3()+_board.getBottom().getX6() !=0 && _board.getBottom().isVolcano() == false){
			  _pathX3ToX6 = t.getX3()+_board.getBottom().getX6();
		  }
		  else if(_board.getRowForTilePlacedThisTurn() % 2 == 0 ){
			 evenColumns(x, y);
		  }
		  else if(_board.getRowForTilePlacedThisTurn() %2 != 0){
			 oddColumns(x,y);
		  }
		  if(_pathX6ToX3 == 0 && _pathX5ToX2 == 0 && _pathX4ToX1 == 0 && _pathX3ToX6 == 0&& _pathX2ToX5 == 0 && _pathX1ToX4 == 0 && _board.getTile(x,y).isVolcano() == false){
			  _board.removeTile(x, y);
			  new Ah_Ah_Ah_You_Didnt_Say_The_Magic_Word_Exception();
			  return false;
		  }
		  return true;
	}
	
	public boolean isFirstTurn(){ // tells if its the first turn or not written by Tim Weppner
		return _firstTurn;
	}
	
//	public void changeFirstTurn(){//changes it from first turn to not first turn  written by Tim Weppner
//		if(validPlacement(_tilePlacedThisTurn, _rowOfTilePlacedThisTurn, _colOfTilePlacedThisTurn)==true){
//			_firstTurn = false;
//		}
//	}
	
	
	public int getPathX6ToX3(){ // retrieves the value of the path between position X6 and X3  written by Tim Weppner
		return _pathX6ToX3;
	}
	
	public int getPathX5ToX2(){// retrieves the value of the path between position X5 and X2  written by Tim Weppner
		return _pathX5ToX2;
	}
	
	public int getPathX4ToX1(){// retrieves the value of the path between position X4 and X1  written by Tim Weppner
		return _pathX4ToX1;
	}
	
	public int getPathX3ToX6(){// retrieves the value of the path between position X3 and X6  written by Tim Weppner
		return _pathX3ToX6;
	}
	
	public int getPathX2ToX5(){// retrieves the value of the path between position X2 and X5  written by Tim Weppner
		return _pathX2ToX5;
	}
	
	public int getPathX1ToX4(){// retrieves the value of the path between position X1 and X4  written by Tim Weppner
		return _pathX1ToX4;
	}
	
	private void resetPaths(){ // resets all the paths to being 0 (no path)
		  _pathX6ToX3 = 0;
		  _pathX5ToX2 = 0;
		  _pathX4ToX1 = 0;
		  _pathX3ToX6 = 0;
		  _pathX2ToX5 = 0;
		  _pathX1ToX4 = 0;
	}
	
	private void oddColumns( int x , int y){ // used to find where the paths are on a tile in an odd numbered column written by Tim Weppner
		Tile t = _board.getTile(x, y);
		if(t.getX5()+_board.getTopRight().getX2() !=0 && _board.getTopRight().isVolcano() == false){
			  _pathX5ToX2 = t.getX5()+_board.getTopRight().getX2();  
		  }
		  else if(t.getX4()+_board.getRight().getX1() !=0 && _board.getRight().isVolcano() == false){
			  _pathX4ToX1 = t.getX4()+_board.getRight().getX1();	  
		  }
		  else if(t.getX2()+_board.getLeft().getX5() !=0 && _board.getLeft().isVolcano() == false){
			  _pathX2ToX5 = t.getX2()+_board.getLeft().getX5();
		  }
		  else if(t.getX1()+_board.getTopLeft().getX4() !=0 && _board.getTopLeft().isVolcano() == false){
			  _pathX1ToX4 = t.getX1()+_board.getTopLeft().getX4();
		  }
	}
	
	private void evenColumns(int x , int y){ // used to find where the paths are on a tile in an even numbered column written by Tim Weppner
		Tile t = _board.getTile(x, y);
		if(t.getX5()+_board.getRight().getX2() !=0 && _board.getRight().isVolcano() == false){
			  _pathX5ToX2 = t.getX5()+_board.getRight().getX2();
		  }
		  else if(t.getX4()+_board.getBottomRight().getX1() !=0 && _board.getBottomRight().isVolcano() == false){
			  _pathX4ToX1 = t.getX4()+_board.getBottomRight().getX1();
		  }
		  else if(t.getX2()+_board.getBottomLeft().getX5() !=0 && _board.getTop().isVolcano() == false){
			  _pathX2ToX5 = t.getX2()+_board.getTop().getX5();  
		  }
		  else if(t.getX1()+_board.getLeft().getX4() !=0 && _board.getLeft().isVolcano() == false){
			  _pathX1ToX4 = t.getX1()+_board.getLeft().getX4();
		  } 
	}
}
