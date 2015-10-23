// Marcus Del Rio - CSC281 - Professor Black

// This program is a playable Chess game with an AI opponent that makes random movements.
// The board will come up blank until the public static String filesource is changed to contain the the directory path of the folder holding
// the chess piece icons
import java.awt.Color;//calls Color library
import java.awt.Graphics;//calls Graphics library

import javax.swing.Icon;//calls swing Icon library
import javax.swing.JFrame;//calls swing JFrame library

public class Chess {
	
	public static final int WINDOW_WIDTH=410, WINDOW_HEIGHT=430;//creates immutable window dimensions
	public static Piece[][] position=new Piece[8][8];//creates an array to hold the positions of the pieces that will be modified from different classes
	public static JFrame mywindow=new JFrame("Chess");//creates a new window that can be modified throughout the program
	public static boolean WhitesTurn=true;
	public static String filesource="C:/Users/Marcus/workspace/Chess/src/";
	
	
	public static void main (String[] args)
	{
		position[0][0]=new Rook(true);// creates a new black Rook
		position[0][1]=new Knight(true);// creates a new black Knight
		position[0][2]=new Bishop(true);// creates a new black Bishop
		position[0][3]=new Queen(true);// creates a new black Queen
		position[0][4]=new King(true);// creates a new black King
		position[0][5]=new Bishop(true);// creates a new black Bishop
		position[0][6]=new Knight(true);// creates a new black Knight
		position[0][7]=new Rook(true);// creates a new black rook
		for (int i=0;i<8;i++)//runs a for loop across the second and 7th rows
		{
			position[1][i]=new Pawn(true);//creates new black pawns
			position[6][i]=new Pawn(false);//creates new white pawns
		}
		position[7][0]=new Rook(false);//creates a new white rook
		position[7][1]=new Knight(false);//creates a new white Knight
		position[7][2]=new Bishop(false);//creates a new white Bishop
		position[7][3]=new Queen(false);// creates a new white Queen
		position[7][4]=new King(false);//creates a new white King
		position[7][5]=new Bishop(false);//creates a new white Bishop
		position[7][6]=new Knight(false);//creates a new white Knight
		position[7][7]=new Rook(false);//creates a new white rook
		for (int b=2;b<6;b++)//fills in rest of spaces in position array as null
		{
			for (int a=0;a<8;a++)
			{
				position[b][a]=null;
			}
		}
		
		BoardMouseListener Mouse=new BoardMouseListener();//creates new mouse listener
		mywindow.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);//sets size of new window
		mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes program exit after closing the window
		BoardComponent board=new BoardComponent();//creates new board component
		board.setBounds(0,0,400,400);//sets bounds of board component
		mywindow.add(board);//adds board component 
		mywindow.addMouseListener(Mouse);//adds mouse listener
		mywindow.setVisible(true);//makes window true
		
	}
	
	public static void AIplayer()// this program is called when the AI must make a random move 
	{
		while (WhitesTurn==false)//while it is blacks turn, will end when a valid move is made
		{
			int randomrow=(int) (Math.random()*8);//a random row
			int randomcol=(int) (Math.random()*8);//a random column
			if (position[randomrow][randomcol]!=null)//if the board space is occupied
			{
				if (position[randomrow][randomcol].color.equals("black")) //if the random piece is black//start checking for movements
					{
						int randomrow1= (int) (Math.random()*8);//another random row
						int randomcol1= (int) (Math.random()*8);//another random column
						if (position[randomrow][randomcol].canMove(randomrow, randomcol, randomrow1, randomcol1))//if the random piece can move to  random space
								{
								position[randomrow1][randomcol1]=position[randomrow][randomcol];//destination icon becomes start icon
								position[randomrow][randomcol]=null;//start icon becomes null
								WhitesTurn=true;//ends AI turn
								}
					}
				
			}
		}
			
	}
}
	


