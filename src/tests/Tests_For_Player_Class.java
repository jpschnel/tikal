package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.GamePieces;
import code.Player;

public class Tests_For_Player_Class {
	@Test public void test_1(){
		//tests if name and getname mechanism works - Justin Schnell
		String _expected= "Christopher Eccleston";
		Player _p= new Player(_expected);
		String _actual= _p.getName();
		assertTrue("the expected name was "+_expected+", but the returned name was "+_actual,_expected==_actual);
	}
	@Test public void test_2(){
		//tests if getscore and addscore functions - Justin Schnell
		Player _p= new Player("David Tennant");
		_p.addScore(5);
		int expected= 5;
		int actual= _p.getScore();
		assertTrue("the expected score was "+expected+", but the returned score was "+actual,expected==actual);
	}
	@Test public void test_3(){
		//tests if getpieces works in player class - Justin Schnell
		ArrayList<GamePieces> gp= new ArrayList<GamePieces>();
		for(int i=0; i<10; i++){
            GamePieces xi = new GamePieces();
            gp.add(xi);
		}
            ArrayList<GamePieces> expected= gp;
		
		List<GamePieces> actual = new Player("Matt Smith").getPieces();
		assertTrue("the expected score was "+expected+", but the returned score was "+actual,expected.size()==actual.size());
	}
	@Test public void test_4(){
		//tests action points at creation of character - Justin Schnell
		int expected= 12;
		int actual= new Player("Peter Capaldi").getActionPoints();
		assertTrue("the expected score was "+expected+", but the returned score was "+actual,expected==actual);
	}
		/* this test is unfinished */	@Test public void testForPlayerClass_5(){
					//tests if reset _AP works
					Player np= new Player("Who?");
						int i=np.getActionPoints()-7;
						System.out.println("the current amount of ap is "+np.getActionPoints());
						np.resetAP();
						assertTrue("yes sir"+np.getActionPoints(),true);
	}
}
