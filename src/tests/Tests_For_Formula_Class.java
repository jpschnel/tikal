package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Formula;

public class Tests_For_Formula_Class {
	
	@Test public void test_1(){
		//tests if the formula works for 6 players -Justin Schnell
		int expected= 10;
		Formula f= new Formula(6);
		int actual= f.boardFormula();
		assertTrue("I expected the int returned to be "+expected+" . However, it returned an int of "+actual,expected==actual);
	}
	@Test public void test_2(){
		//tests if the formula works for 100 players - Justin Schnell
		int expected= 40;
		Formula f= new Formula(100);
		int actual= f.boardFormula();
		assertTrue("I expected the int returned to be "+expected+" . However, it returned an int of "+actual,expected==actual);
	}
	@Test public void test_3(){
		//tests if the formula works for 5280 players! - Justin Schnell
		int expected= 282;
		Formula f= new Formula(5280);
		int actual= f.boardFormula();
		assertTrue("I expected the int returned to be "+expected+" . However, it returned an int of "+actual,expected==actual);
	}

}
