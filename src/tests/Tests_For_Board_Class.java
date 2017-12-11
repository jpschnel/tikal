package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Board;
import code.Tile;

public class Tests_For_Board_Class {

	@Test public void test_1(){
		//tests if instantiating a board works - Justin Schnell
		Tile[][] expected= new Tile[8][11];
		Board _b= new Board(8,11); 
		Tile[][] actual= _b.getBoard();
		assertTrue("I expected "+expected+" but got "+actual,expected.length==actual.length && actual[1].length==expected[1].length);;
	}


/* this test is unfinished*/	@Test public void test_2(){
					//tests if the place tile method works 
					
	
	}
}