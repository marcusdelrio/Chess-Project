import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class Piece //all pieces will be subclass of abstract class
{
	public ImageIcon icon=null;//all pieces will need icon variable
	public String color=" ";//all pieces will set their color upon initializing
	
	
	
	public Piece(boolean isblack)//all pieces will construct according to a boolean isblack determining their color
	
	{}
	
	public void drawPiece(Graphics g,int xpos, int ypos)//all pieces will be drawn the same way and have the same drawPiece
	{
		g.drawImage(icon.getImage(),xpos,ypos,null);
	}	
	
	public boolean canMove(int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//all pieces have a separate canMove function with the same parameters
	{
		return false;
	}
	
}
