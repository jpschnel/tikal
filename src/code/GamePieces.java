package code;

import java.util.ArrayList;

public class GamePieces {
   
	private ArrayList<GamePieces> _workers; // a list of the workers written by Tim Weppner
    private int _workerValue; // the value of each worker which would have been implemented if there were expedition leaders written by Tim Weppner
    
    public GamePieces(){ // creates the list  written by Tim Weppner
        _workers = new ArrayList<GamePieces>();
        _workerValue = 1;
    }
   
    public void createWrokers(){ // populates the list written by Tim Weppner
        for(int i=0; i<10; i++){
            GamePieces xi = new GamePieces();
            _workers.add(xi);
        }
    }
    
    public ArrayList<GamePieces> getWorkers(){ //gives you access to the list written by Tim Weppner
    	return _workers;
    }
    
    public int getWorkerValue(){ // returns the value of each worker written by Tim Weppner
    	return _workerValue;
    }
}
