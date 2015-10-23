import javax.swing.ImageIcon;


public class Bishop extends Piece //Bishop subclass of piece
{

	private String blackfile=Chess.filesource+"bbishop.gif";// file for black bishop icon 
	private String whitefile=Chess.filesource+"wbishop.gif";// file for white bishop icon 

	public Bishop(boolean isblack) //constructor
	{
		super(isblack);//brings in variables and methods from Piece
		if (isblack==true)// if is black is true
		{
		icon= new ImageIcon(blackfile);//icon is the black file
		color="black";//piece color is black
		}
		else
		{
		icon=new ImageIcon(whitefile);//icon is the white file
		color="white";//piece color is white
		}
	}
	public boolean canMove (int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if bishop can move or not
	{
		boolean pathclear=true;//creates a boolean that monitors if the path to the destination is clear
		if (Math.abs(Fstartbox-Fendbox)!=Math.abs(Sstartbox-Sendbox))//if the bishop does not move in diagonal
		{
			return false;//can't move 
		}
		if (Fendbox>Fstartbox && Sendbox>Sstartbox)//if piece moves down and to the right
		{
			for (int counter=1;counter<(Fendbox-Fstartbox);counter++)//checks that each intermediate square is empty
			{
				if (Chess.position[Fstartbox+counter][Sstartbox+counter]!=null)//if an intermediate square is not empty, cant move
					{pathclear=false;}
			}
		}
		if (Fendbox<Fstartbox && Sendbox>Sstartbox)//if piece moves up and to the right
		{
			for (int counter=1;counter<(Fstartbox-Fendbox);counter++)
			{
				if (Chess.position[Fstartbox-counter][Sstartbox+counter]!=null)
					{pathclear=false;}
			}
		}
		if (Fendbox<Fstartbox && Sendbox<Sstartbox)//if piece moves up and to the left
		{
			for (int counter=1;counter<(Fstartbox-Fendbox);counter++)
			{
				if (Chess.position[Fstartbox-counter][Sstartbox-counter]!=null)
					{pathclear=false;}
			}
		}
		if (Fendbox>Fstartbox && Sendbox<Sstartbox)//if piece moves down and to the left
		{
			for (int counter=1;counter<(Fendbox-Fstartbox);counter++)
			{
				if (Chess.position[Fstartbox+counter][Sstartbox-counter]!=null)
					{pathclear=false;}
			}
		}
		if (Chess.position[Fendbox][Sendbox]==null && pathclear==true)//if the destination is empty and the path is clear
		{
			return true;//can move
		}
		if (Chess.position[Fendbox][Sendbox]==null)//if the destination is empty but failed on path clear
		{
			return false;//return false
		}
		if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color) && pathclear==true)// if destination is an enemy piece and the path is clear
		{
			return true;//can move
		}
		return false;//if it hasnt returned by now, cant move
		
	}

}
