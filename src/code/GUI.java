package code;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI implements Runnable {

	private Game _game;
	private Board _board;
	private JFrame frame;	//the JFrame of the game
	private int rows;	//the rows of the game board
	private int x;	//how far from the left edge of the frame
	private int y;	//how far from the top edge of the frame
	private int width;	//the width of the panels in the game board
	private int height;	//the height of the panels in the game board
	private int _north;
	private int _south;
	private int _west;
	private int _east;
	private int _pyramid;
	private String _playerName;
	private int _points;
	private int _tempTile;
	private int _pickedUpTile;
	private int _eastSecond;
	private int _westSecond;
	public Game _gameClass;
	private int _columns;
	private JPanel jp;
	private int xCoordinate;
	private int yCoordinate;
	private JPanel _tile;
	private JLabel pan2;
	private JPanel p;
	private JLabel l;
	private JPanel[][] pan;
	private JPanel player1;
	private boolean isPlayerButtonThere;
	private int amount;
	private JLabel playerButton;
	private Gif _gif;
	
	//i wrote this
	

	public GUI(/*Gameplay g int north, int south, int west, int east, int pyramid, String playerName, int points*/) {

		/*	_north = north;
			_south = south;
			_west = west;
			_east = east;
			_pyramid = pyramid;
			_player = player;
			_points = points;
		 */
		_game = new Game();
	//	_board = _game.returnBoard();
		
		_columns = 6;
		_north = 2;
		_south = 2;
		_west = 2;
		_east = 2;
		_pyramid = 1;
		_eastSecond = 2;
		_westSecond = 2;
		
		 pan = new JPanel[6][6];
		 
		 isPlayerButtonThere = false;
		 
		 amount = 1;
		 
		 _gif = new Gif();
	}

	@Override
	public void run(){

		buildInterface();

	}

	//this method builds the entire game board.

	public void buildInterface(){

		frame = new JFrame();
		frame.setBounds(0, 0, 1600, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		int columns = 6;	//this needs to be passed in
		
		x = 0;
		y = 35;
		width = 100;
		height = 70;
		int panWidth = columns * 100;
		int panHeight = columns * 70;
		
		pan2 = new JLabel();
		pan2.setBounds(0, 0, panWidth, panHeight);
		currentTile(pan2);

		for(int i = 0; i < columns; i++){
			for(int j = 0; j < columns; j++){
				if((i % 2) == 0){
					if(j == 0){
					
						y = 0;
						height = 35;
						
						x = i * 100;
						
						 l = new JLabel();
						l.setBounds(x, y, width, height);
						pan2.add(l);
						frame.getContentPane().add(pan2);
						l.setLayout(null);
					
						y = 35;
						
					}
					else {
						
					height = 70;
					x = i * 100;
				
					l = new JLabel();
				
					l.setBounds(x, y, width, height);
					l.setBorder(new LineBorder(new Color(0,0,0)));
					pan2.add(l);
					frame.getContentPane().add(pan2);
					
					y = y + 70;
				}
			}
				else {
					
					if(j == 0){
						y = 0;

					}
					x = i * 100;
					
					l = new JLabel();
					l.setBounds(x, y, width, height);
					l.setBorder(new LineBorder(new Color(0,0,0)));
					
					pan2.add(l);
					frame.getContentPane().add(pan2);
					
					y = y + 70;
				}
			}
		}
		playerInventorys(5);
		terrainTilesPanel();
	//	tiles(2,2,2,2,1`1,2,2);
		rotateTile();
		pyramidPanel();
		endButton();
		actionPoints(_playerName, _points);
		frame.repaint();

	}

	public void playerInventorys(int players){
		int y = 35;
		
		for(int i = 0; i < players; i ++){
			
			JPanel pane = new JPanel();
			pane.setBounds(1050, y, 100, 100);
			pane.setBorder(new LineBorder(new Color(0,0,0)));
			frame.getContentPane().add(pane);
			pane.setLayout(new GridLayout(5,2));
			
			y = y + 105;
			
			ArrayList<Integer> colors = new ArrayList<Integer>();
			colors.add(0);
			colors.add(128);
			colors.add(255);
			Collections.shuffle(colors);
			int first = colors.get(0);
			int second = colors.get(1);
			int third = colors.get(2);
			
			for(int j = 0; j < 10; j++){

				JButton b = new JButton();
				b.setBackground(new Color(first,second,third));
				pane.add(b);
			}
		}	
	}

	public void terrainTilesPanel(){

		JButton terrainButton = new JButton("Terrain Tiles");
		terrainButton.setBounds(650, 225, 150, 100);
		frame.getContentPane().add(terrainButton);
		terrainButton.addActionListener(new Action());
	}
	public class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			boolean volcano = true;
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			numbers.add(e)
			tiles(_north, _south, _west, _east, _pyramid, _eastSecond, _westSecond, volcano);
			frame.repaint();
		}
	}
	
	public void rotateTile(){
		
		JButton moveButton = new JButton("CLICK ME");
		moveButton.setBounds(850, 500, 150, 50);
		frame.getContentPane().add(moveButton);
		moveButton.addActionListener(new moveAction());
	}	
		public class moveAction implements ActionListener {
			public void actionPerformed(ActionEvent e){
				//new Ah_Ah_Ah_You_Didnt_Say_The_Magic_Word_Exception();
				Gif g = new Gif();
				g.setVisible(true);
				frame.repaint();
			}
		}
	

	//method will make a tile with the following parameters passed in to make it 
	
	public void tiles(int north, int south, int west, int east, int pyramid, int eastSecond, int westSecond, boolean volcano){

		

		_tile = new JPanel();
		_tile.setLayout(null);
		_tile.setBounds(700, 500, width, height);
		_tile.setBorder(new LineBorder(new Color(0,0,0)));
		frame.getContentPane().add(_tile);
		placeTile(_tile);
		
		if(volcano == true){
			JLabel makeVolcano = new JLabel("Volcano");
			makeVolcano.setLayout(null);
			makeVolcano.setBounds(25,5,50,50);
			_tile.add(makeVolcano);
		}
		else{

		JLabel west1 = new JLabel();
		west1.setLayout(null);
		west1.setBorder(new LineBorder(new Color(0,0,0)));
		west1.setBounds(0, 12, 10, 16);
		west1.setText("1");


		if(west == 1){
			_tile.add(west1);
		} else if(west == 2){
			west1.setText("2");
			_tile.add(west1);

		} else {}

		JLabel west3 = new JLabel();
		west3.setLayout(null);
		west3.setBorder(new LineBorder(new Color(0,0,0)));
		west3.setBounds(0, 40, 10, 16);
		west3.setText("1");


		if(westSecond == 1){
			_tile.add(west3);
		} else if(westSecond == 2){
			west3.setText("2");
			_tile.add(west3);
		} else {}

		JLabel north1 = new JLabel();
		north1.setLayout(null);
		north1.setBorder(new LineBorder(new Color(0,0,0)));
		north1.setBounds(42, 0, 16, 11);
		north1.setText("1");

		if(north == 1){
			_tile.add(north1);
		} else if(north == 2){
			north1.setText("2");
			_tile.add(north1);

		} else {}

		JLabel east1 = new JLabel();
		east1.setLayout(null);
		east1.setBorder(new LineBorder(new Color(0,0,0)));
		east1.setBounds(89, 12, 10, 16);
		east1.setText("1");


		if(east == 1){
			_tile.add(east1);
		} else if(east == 2){
			east1.setText("2");
			_tile.add(east1);
			

		} else {}

		JLabel east3 = new JLabel();
		east3.setLayout(null);
		east3.setBorder(new LineBorder(new Color(0,0,0)));
		east3.setBounds(89, 40, 10, 16);
		east3.setText("1");


		if(eastSecond == 1){
			_tile.add(east3);
		} else if(eastSecond == 2){
			east3.setText("2");
			_tile.add(east3);
		

		} else {}

		JLabel south1 = new JLabel();
		south1.setLayout(null);
		south1.setBorder(new LineBorder(new Color(0,0,0)));
		south1.setBounds(42, 58, 16, 11);
		south1.setText("1");


		if(south == 1){
			_tile.add(south1);
		} else if(south == 2){
			south1.setText("2");
			_tile.add(south1);
			

		} else {}

		JLabel pyramidPiece = new JLabel();
		pyramidPiece.setLayout(null);
		pyramidPiece.setBorder(new LineBorder(new Color(0,0,0)));
		pyramidPiece.setBounds(40, 27, 20, 16);
		pyramidPiece.setText(" 0");
		if(pyramid == 1){
			_tile.add(pyramidPiece);

		} else {}
		}
	}

	public void pyramidPanel(){

		JPanel pyramids = new JPanel();
		pyramids.setLayout(new GridLayout(4,5));
		pyramids.setBorder(new LineBorder(new Color(0,0,0)));
		pyramids.setBounds(300, 450, 100, 100);
		frame.getContentPane().add(pyramids);
		
		JTextField g = new JTextField();
		g.setLayout(null);
		g.setBounds(300, 425, 100, 25);
		g.setText("	Pyramid Pieces");
		frame.getContentPane().add(g);

		for(int i = 0; i < 8; i++){

			JLabel one = new JLabel();
			one.setLayout(null);
			one.setText(" 1");
			one.setBorder(new LineBorder(new Color(0,0,0)));
			pyramids.add(one);

		}

		for(int j = 0; j < 6; j++){

			JLabel two = new JLabel();
			two.setLayout(null);
			two.setText(" 2");
			two.setBorder(new LineBorder(new Color(0,0,0)));
			pyramids.add(two);

		}

		for(int k = 0; k < 4; k++){

			JLabel three = new JLabel();
			three.setLayout(null);
			three.setText(" 3");
			three.setBorder(new LineBorder(new Color(0,0,0)));
			pyramids.add(three);

		}

		for(int l = 0; l < 2; l++){

			JLabel four = new JLabel();
			four.setLayout(null);
			four.setText(" 4");
			four.setBorder(new LineBorder(new Color(0,0,0)));
			pyramids.add(four);

		}
	
}

	public void endButton(){

		JButton end = new JButton("END Turn");
		//TO DO: End turn and change to next players turn
		end.setBounds(450, 450, 75, 50);
		end.setBorder(new LineBorder(new Color(0,0,0)));
		frame.getContentPane().add(end);

	}

	public void actionPoints(String name, int points){

		JPanel ap = new JPanel(new GridLayout(2,1));
		ap.setBounds(550,450, 125, 50);
		ap.setBorder(new LineBorder(new Color(0,0,0)));
		frame.getContentPane().add(ap);

		JLabel currentAP = new JLabel();
		currentAP.setText(""+points);
		JLabel currentPlayer = new JLabel();
		currentPlayer.setText(name);
		ap.add(currentPlayer);
		ap.add(currentAP);

	}
	

	
	public void currentTile(JLabel pa2){

		
		pa2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				xCoordinate = e.getX() / 100;
				if(xCoordinate % 2 == 0){
					int k = (e.getY() + 35) / 70;
					yCoordinate = k - 1;
				} else {
					yCoordinate = e.getY() /70;
				}
						
	//		JOptionPane.showMessageDialog(frame, "x:"+xCoordinate+" y:"+yCoordinate);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public int xClickedCoordinate(){
		return xCoordinate;
	}
	
	public int yClickedCoordinate(){
		return yCoordinate;
		
	}	

	public void newTileWanted(final JButton jb){
		
		
		jb.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel thisOne = new JPanel();
				
				thisOne = pan[xCoordinate][yCoordinate];
				
				
			
			if(isPlayerButtonThere == false){
				
				
				playerButton = new JLabel(""+amount);
				playerButton.setBounds(20, 20, 20, 20);
				playerButton.setBorder(new LineBorder(new Color(0,0,255)));
				player1.remove(jb);
				
				isPlayerButtonThere = true;

				thisOne.add(playerButton);
				
				pan[xCoordinate][yCoordinate] = thisOne;
				
				frame.repaint();
				}
				else {
					
					amount = amount + 1;;
					playerButton = new JLabel(""+amount);
					playerButton.setBounds(20, 20, 20, 20);
					playerButton.setBorder(new LineBorder(new Color(0,0,255)));
					player1.remove(jb);
					//player1.remove(jb);	
					isPlayerButtonThere = true;

					thisOne.add(playerButton);
					
					pan[xCoordinate][yCoordinate] = thisOne;
					
					
					frame.repaint();

				}
			
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public void placeTile(final JPanel panel){
		
		
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int leftRight = 0;
				int upDown = 0;
					if((xCoordinate % 2) == 0){
						leftRight = xCoordinate *100;
						upDown = (yCoordinate * 70) + 35;
						panel.setBounds(leftRight, upDown, 100, 70);
						pan[xCoordinate][yCoordinate] = panel;
						frame.getContentPane().add(panel);
						frame.repaint();
					}
					else {
						leftRight = xCoordinate * 100;
						upDown = yCoordinate * 70;
						panel.setBounds(leftRight, upDown, 100, 70);
						pan[xCoordinate][yCoordinate] = panel;
						frame.getContentPane().add(panel);
						frame.repaint();
					}
					
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public void nextTile(JLabel pa2){

		
		pa2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Gif();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

}