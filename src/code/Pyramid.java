package code;

import java.util.ArrayList;

public class Pyramid {
	
	private int _pyramidValue; // holds reference to the value of the pyramid written by Tim Weppner
	private ArrayList<Pyramid> _pyramids; // list of pyramid pieces written by Tim Weppner
	
	public Pyramid(){ // sets the initial pyramid value to 0 written by Tim Weppner
		_pyramidValue = 0;
	}
	
	public ArrayList<Pyramid> getpyramidList(){ // gives access to the list of pyramid pieces written by Tim Weppner
		return _pyramids;
	}
	
	public int getPyramidValue(){ // returns the value of the pyramid written by Tim Weppner
	   	return _pyramidValue;
	    	
    }
	
	public void setPyramidValue(int x){ // changes the value of the pyramid written by Tim Weppner
		_pyramidValue = x;    	
    }
}
