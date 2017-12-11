package code;

import java.util.HashMap;

public class Tile {
      
		private int _x1; // top left stone position on the tile written by Tim Weppner
        private int _x2; // bottom left stone position on the tile written by Tim Weppner
        private int _x3; // bottom middle stone position on the tile written by Tim Weppner
        private int _x4; // bottom right stone position on the tile written by Tim Weppner
        private int _x5; // top right stone position on the tile written by Tim Weppner
        private int _x6; // top middle stone position on the tile written by Tim Weppner
        private int _pyramidValue; // the value of the pyramid on the tile written by Tim Weppner
        //private int _loot; // if the loot had been part of the code thats what this would have represented written by Tim Weppner
        private boolean _volcano; // true if there is a volcano, false otherwise written by Tim Weppner
        private HashMap<Player, Integer> _explorerCount; // shows how many explorers each player has on the tile
        private Pyramid _pyramid; // holds reference to the pyramid on the tile if there is one
        private boolean _firstTile;
        
        public Tile(int x1,int x2,int x3,int x4,int x5,int x6, int pyramid, boolean volcano, boolean firstTile){//creates the Tile written by Tim Weppner
        _explorerCount = new HashMap<Player, Integer>();
        for(int i = 0 ; i< Game._order.size(); i++){//creates a hashmap of all players and how many explorers are on the specified tile written by Tim Weppner
        	_explorerCount.put(Game._order.get(i), 0);
        }
        _firstTile = firstTile;
        _x1 = x1;
        _x2 = x2;
        _x3 = x3;
        _x4 = x4;
        _x5 = x5;
        _x6 = x6;
        _pyramidValue = pyramid;
        _volcano = volcano;
        if(pyramid != 0){
          Pyramid p = new Pyramid();
          p.setPyramidValue(pyramid);
        	_pyramid = p;
        }
       
        }
//        public orientation(){
//        }
//        public boolean tilePlaceable(){
//           
//        }
        public void rotateTile(){//rotates the values of X1-X6 clockwise written by Tim Weppner
            int x2 = _x2;
            _x2 = _x1;
            _x1 = _x6;
            _x6 = _x5;
            _x5 = _x4;
            _x3 = x2;
        }
        public void setFirstTile(){
        	_firstTile = true;
        	
        }
        
        public boolean hasPyramid(){ //shows if there is a pyramid on the tile written by Tim Weppner
            if(_pyramidValue == 0){
                return true;
            }
            return false;
        }
        
        public int explorersOnTileForThisPlayer(Player p){ //returns the amount of explorers a player has on a tile written by Tim Weppner
        	return _explorerCount.get(p);
        }
        
        public void addExplorerByThisPlayer(Player p){ // adds an explorer from a player to the tile written by Tim Weppner
        	_explorerCount.replace(p, explorersOnTileForThisPlayer(p),explorersOnTileForThisPlayer(p)+1);
        }
        
        public int pyramidHeight(){//returns the value of the pyramid of the tile written by Tim Weppner
            return _pyramidValue;
        }
        
        public Pyramid getPyramid(){
        	return _pyramid;
        }
        
        public boolean isVolcano(){//shows if the tile is a volcano tile written by Tim Weppner
            return _volcano;
        }
        
        public int getX1(){ //returns the value at position X1 on the Tile written by Tim Weppner
            return _x1;
        }
        
        public int getX2(){//returns the value at position X2 on the Tile written by Tim Weppner
            return _x2;
        }
        
        public int getX3(){//returns the value at position X3 on the Tile written by Tim Weppner
            return _x3;
        }
        
        public int getX4(){//returns the value at position X4 on the Tile written by Tim Weppner
            return _x4;
        }
        
        public int getX5(){//returns the value at position X5 on the Tile written by Tim Weppner
            return _x5;
        }
        
        public int getX6(){//returns the value at position X6 on the Tile written by Tim Weppner
            return _x6;
        }
}

