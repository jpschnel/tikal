package code;



public class Formula {
	
	private int _players; // number of players in the game written by Tim Weppner
	private int _numberOfPositions; // number of columns written by Tim Weppner
	private int _numberOfPyramidPieces; // number of pyramid pieces written by Tim Weppner
	private int _numberOfTiles; // total number of tiles written by Tim Weppner
	
	public Formula(int players){ // retrieves the number of players which is needed for the following methods written by Tim Weppner
		_players = players;
		_players = 2;
	}
	
	public int boardFormula(){ // uses the given formula to calculate the number of columns on the board written by Tim Weppner
		for(int i = 1; i>0; i++){
				if (15 <= ((i+(i-1)) * (i/2)) / (_players)){
					_numberOfPositions = i;
					return _numberOfPositions;
			}
		
		}
		return 0;
	}
	
	public int numberOfPyramidPieces(){ // uses the given formula to calculate the total number of pyramid pieces available written by Tim Weppner
		_numberOfPyramidPieces = _numberOfPositions + _players;
		return _numberOfPyramidPieces; 
		//in game be sure for each type of pyramid to make sure the different are incremented correctly written by Tim Weppner
	}
    public int numberOfTiles(){ // calculates the total number of tiles in the game written by Tim Weppner
        if ( _numberOfPositions % 2 == 0 ){
            _numberOfTiles =(_numberOfPositions/2)*((2*_numberOfPositions)+1);
            return _numberOfTiles;
        }
        else{
            _numberOfTiles =(((_numberOfPositions/2)+1)*(_numberOfPositions-1))+((_numberOfPositions/2)*_numberOfPositions);
            return _numberOfTiles;
        }
        
    }
}
