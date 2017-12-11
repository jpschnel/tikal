package tests;

import static org.junit.Assert.*;
import code.GamePieces;
import code.Player;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class Tests_For_GamePieces_Class {

	@Test public void test_1(){
		// test for 10 game pieces (getworkers and createworkers) - Justin Schnell
		GamePieces _g= new GamePieces();
		ArrayList<GamePieces> expected= new ArrayList<GamePieces>();
		GamePieces e1= new GamePieces();

		GamePieces e2= new GamePieces();
		GamePieces e3= new GamePieces();
		GamePieces e4= new GamePieces();
		GamePieces e5= new GamePieces();
		GamePieces e6= new GamePieces();
		GamePieces e7= new GamePieces();
		GamePieces e8= new GamePieces();
		GamePieces e9= new GamePieces();
		GamePieces e10= new GamePieces();
		expected.add(e1);
		expected.add(e2);
		expected.add(e3);
		expected.add(e4);
		expected.add(e5);
		expected.add(e6);
		expected.add(e7);
		expected.add(e8);
		expected.add(e9);
		expected.add(e10);
		_g.createWrokers();
		ArrayList<GamePieces> actual= _g.getWorkers();
		assertTrue("I expected "+expected+". but got "+actual, expected.size()==actual.size());

	}
	@Test public void test_2(){
		//tests the getWorker method - Justin Schnell
		GamePieces _gp= new GamePieces();
		int actual= _gp.getWorkerValue();
		int expected=1; 
		assertTrue("I expected the workervalue to be "+expected+" but the workervalue i got was "+actual,expected==actual);

	}
}