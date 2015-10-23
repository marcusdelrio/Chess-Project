import javax.swing.ImageIcon;


public class Knight extends Piece // knight is subclass of piece
{
	
	private String blackfile=Chess.filesource+"bknight.gif";//file for icon for black knight
	private String whitefile=Chess.filesource+"wknight.gif";//file for icon for white knight

	public Knight (boolean isblack) //constructs Knight
	{
		super(isblack);//brings in variables and methods from Piece
		if (isblack==true)// if piece is black
		{
		icon= new ImageIcon(blackfile);//icon is black Knight
		color="black";//color is black
		}
		else
		{
		icon=new ImageIcon(whitefile);// icon is white knight
		color="white";//color is white
		}
	}
	
	public boolean canMove (int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if a move is legal
	{
	if (Chess.position[Fendbox][Sendbox]==null)//if the destination is empty
	{
		if ((Math.abs(Sendbox-Sstartbox)==1 && Math.abs(Fendbox-Fstartbox)==2) || (Math.abs(Sendbox-Sstartbox)==2 && Math.abs(Fendbox-Fstartbox)==1))//all possible L shaped moves for knight 
		{
			return true;// if move is L shaped, then can move 
		}
	}
	if (Chess.position[Fendbox][Sendbox]==null)// if destination is null and didnt move
	{
		return false;//cant move
	}
	if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color))// if destination is empty
	{
		if ((Math.abs(Sendbox-Sstartbox)==1 && Math.abs(Fendbox-Fstartbox)==2) || (Math.abs(Sendbox-Sstartbox)==2 && Math.abs(Fendbox-Fstartbox)==1))
		{
			return true;
		}
	}
	return false;// if move failed previous if statements, then cant move
	}
	
}
