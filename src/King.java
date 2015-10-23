import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class King extends Piece // king is a subclass of Piece
{
	
	
	private String blackfile=Chess.filesource+"bking.gif";// file for black icon of King
	private String whitefile=Chess.filesource+"wking.gif";//file for white King icon
	
	
	public King(boolean isblack) // constructs a king
		{
		super(isblack);// brings in methods and variables from piece
		if (isblack==true)//if piece is black
		{
		icon= new ImageIcon(blackfile);//loads in black king file to icon
		color="black";//color is black
		}
		if (isblack==false)
		{
		icon=new ImageIcon(whitefile);//loads in white king file to icon
		color="white";//color is white
		}
		}
	public boolean canMove(int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if king can move 
	{
		

		
		if (Chess.position[Fendbox][Sendbox]==null)//if destination is empty
		{
			if (Math.abs(Sendbox-Sstartbox)<=1 && Math.abs(Fendbox-Fstartbox)<=1 )// if destination is within one square distance
			{
				return true;//can move
			}
		}
		if (Chess.position[Fendbox][Sendbox]==null)// if destination is empty but didnt move
		{
			return false;// cant move
		}
		if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color))// if destination is enemy piece
		{
			if (Math.abs(Sendbox-Sstartbox)<=1 && Math.abs(Fendbox-Fstartbox)<=1 )
			{
				return true;//can move
			}
		}
		
		
		return false;// if king hasnt moved, cant move
	}
		
		

	

}
