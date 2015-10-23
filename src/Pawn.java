import javax.swing.ImageIcon;


public class Pawn extends Piece // Pawn subclass of Piece
{
	
	private String blackfile=Chess.filesource+"bpawn.gif";//file for icon for black pawn
	private String whitefile=Chess.filesource+"wpawn.gif";//file for icon for white pawn
	private boolean hasmoved=false;//monitors if pawn has been moved before
	

	public Pawn(boolean isblack) //constructor for Pawn
	{
		super(isblack);//brings in all methods and variables from class Piece
		if (isblack==true)//if piece is black
			{
			icon= new ImageIcon(blackfile);//icon is the black file
			color="black";//color is black
			}
		else
			{
			icon=new ImageIcon(whitefile,"this is a whitepawn");//icon is the white file
			color="white";//color is white
			}
	}
	public boolean canMove(int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if pawn can move
	{
		String pawncolor=Chess.position[Fstartbox][Sstartbox].color;//creates a variable holding the pawns color
		
		if (Chess.position[Fendbox][Sendbox]==null && (Sendbox-Sstartbox)==0)//if the pawn tries to move vertically
		{
			if ( pawncolor.equals("black") && (Fendbox-Fstartbox)==2 && hasmoved==false)// if the piece has never moved before and it is black
			{
				hasmoved=true;//now piece has moved
				return true;//can move the two spaces instead of one
			}
			if ( pawncolor.equals("white") && (Fendbox-Fstartbox)==-2 && hasmoved==false)// if the piece has never moved before and it is white
			{
				hasmoved=true;//now piece has moved
				return true;//can move the two spaces
			}
			if ( pawncolor.equals("black") && (Fendbox-Fstartbox)==1)//if the piece is black and the destination is one space down
			{
				hasmoved=true;//piece has moved
				return true;// can move
			}
			if ( pawncolor.equals("white") && (Fendbox-Fstartbox)==-1)// if the piece is white and the destination is one space up
			{
				hasmoved=true;
				return true;
			}
		}
		if (Chess.position[Fendbox][Sendbox]==null)// destination is empty and it hasnt moved yet
		{
			return false;//cant move
		}
		if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color))// if destination is empty piece
		{
			if ( pawncolor.equals("black") && (Fendbox-Fstartbox)==1)// if moving down as black piece
			{
				if (Math.abs(Sendbox-Sstartbox)==1)//if the piece is one diagonal square away
				{
				hasmoved=true;
				return true;
				}
			}
			if ( pawncolor.equals("white") && (Fendbox-Fstartbox)==-1)// if moving up as white piece
			{
				if (Math.abs(Sendbox-Sstartbox)==1)
				{
				hasmoved=true;
				return true;
				}
			}
		}
		return false;//if piece hasnt moved yet, cant move
	}
	
	
}

