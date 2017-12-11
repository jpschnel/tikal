package code;

import java.util.NoSuchElementException;

public class Board {
	
	private Tile[][] _board; // a two dimensional array of tiles written by Tim Weppner
	private Tile _tilePlacedThisTurn; // holds the reference of the tile placed this turn written by Tim Weppner
	private int _x; // the numerical value of the row written by Tim Weppner
	private int _y; // the numerical value of the column written by Tim Weppner
	private int _xTilePlacedThisTurn; // the numerical value of the row of the tile placed this turn written by Tim Weppner
	private int _yTilePlacedThisTurn; // the numerical value of the column of the tile placed this turn written by Tim Weppner
	//create methods that can pull values from specific tiles on the board written by Tim Weppner
	//create methods that can change written by Tim Weppner
	
	public Board(int x, int y){ // creates a 2 dimensional array of x width and y height written by Tim Weppner
		_board = new Tile[x][y];
	}
	
	public Tile[][] getBoard(){
		return _board;
	}
	public void placeTile(Tile t, int x, int y){ // places a specific tile in a specific location on the board and stores the value of the row column and tile written by Tim Weppner
		_board[x][y] = t;
		_tilePlacedThisTurn = t;
		_xTilePlacedThisTurn = x;
		_yTilePlacedThisTurn = y;
	}
	
	public void removeTile(int x, int y){ // removes a tile from the arrayList written by Tim Weppner
		_board[x][y] = null;
	}
	
	public int getColForTilePlacedThisTurn(){ // returns the numerical value of the column of the tile placed this turn written by Tim Weppner
		return _yTilePlacedThisTurn;
	}
	
	public int getRowForTilePlacedThisTurn(){ // returns the numerical value of the row of the tile placed this turn written by Tim Weppner
		 return _xTilePlacedThisTurn;
	}
	
	public Tile getTilePlacedThisTurn(){ // returns the tile placed this turn written by Tim Weppner
		return _tilePlacedThisTurn;
	}
	
	public Tile getTile(int x, int y){ // retrieves a specific tile on the board and stores the value of the row and column written by Tim Weppner
		_x = x;
		_y = y;
		return _board[x][y];
	}
	
	public Tile getTop(){ // returns the tile one space above the selected tile written by Tim Weppner
		if(_board[_x][_y+1]!= null){
			return _board[_x][_y+1]; //change the xy written by Tim Weppner
		}
		else{
			 throw new NoSuchElementException();
		}
	}
	
	public Tile getTopLeft(){ // returns the tile placed one space above and one to the left of the selected tile written by Tim Weppner
		if(_board[_x-1][_y+1]!= null){
			return _board[_x-1][_y+1];
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	public Tile getTopRight(){ // returns the tile placed one space above and one to the right of the selected tile written by Tim Weppner
		if(_board[_x+1][_y+1] != null){
			return _board[_x+1][_y+1];
		}
		else{
			throw new NoSuchElementException();
		}	
	}
	
	public Tile getBottom(){ // returns the tile placed one space below the selected tile written by Tim Weppner
		if(_board[_x][_y-1] != null){
			return _board[_x][_y-1];
		}
		else{
			throw new NoSuchElementException();
		}
		//change the xy
	
	}
	
	public Tile getBottomLeft(){ // returns the tile placed one space below and one to the left of the selected tile written by Tim Weppner
		if(_board[_x-1][_y-1] != null){
			return _board[_x-1][_y-1];
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	public Tile getBottomRight(){ // returns the tile placed one space below and one to the right of the selected tile written by Tim Weppner
		if(_board[_x+1][_y-1] != null){
			return _board[_x+1][_y-1];
		}
		else{
			throw new NoSuchElementException();
		}
		//change the xy
	}
	
	public Tile getRight(){ // returns the tile placed one to the right of the selected tile written by Tim Weppner
		if(_board[_x+1][_y] != null){
			return _board[_x+1][_y];
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	public Tile getLeft(){ // returns the tile placed one to the left of the selected tile written by Tim Weppner
		if(_board[_x-1][_y] != null){
			return _board[_x-1][_y];
		}
		else{
			throw new NoSuchElementException();
		}
	}
}
