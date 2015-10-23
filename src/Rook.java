import javax.swing.ImageIcon;


public class Rook extends Piece //rook subclass of piece
{

	private String blackfile=Chess.filesource+"brook.gif";//file for black rook icon
	private String whitefile=Chess.filesource+"wrook.gif";//file for white rook icon
	
	
	public Rook(boolean isblack) //constructor for rook
	{
		super(isblack);////brings in variables and methods from Piece
		if (isblack==true)// if is black is true
		{
		icon= new ImageIcon(blackfile);//icon is the black file
		color="black";//piece color is black
		}
		else
		{
		icon=new ImageIcon(whitefile);//icon is the white file
		color="white";//icon is the white file
		}
	}
	public boolean canMove (int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if bishop can move or not
	{
		boolean pathclear=true;//monitors if the path is clear or not
				
		if (Sendbox!=Sstartbox && Fendbox!=Fstartbox)//if the destination is not in the horizontal or vertical direction
		{
			return false;//cant move
		}
		if (Sendbox==Sstartbox)//if moving vertically
		{
			if (Fstartbox>Fendbox)//if moving up
			{
				for (int square=Fstartbox-1;square>Fendbox;square=square-1)//checks each square for other pieces
				{
					if (Chess.position[square][Sendbox]!=null)//if a piece is in a square
					{
						pathclear=false;//cant move
					}
				}
			}
			if (Fstartbox<Fendbox)//if moving down 
			{
				for (int square=Fstartbox+1;square<Fendbox;square=square+1)
				{
					if (Chess.position[square][Sendbox]!=null){pathclear=false;}
				}
			}
		}
		
		if (Fendbox==Fstartbox)//if moving horizontally
		{
			if (Sstartbox>Sendbox)//if moving left
			{
				for (int square=Sstartbox-1;square>Sendbox;square=square-1)
				{
					if (Chess.position[Fendbox][square]!=null){pathclear=false;}
				}
			}
			if (Sstartbox<Sendbox)//if moving right
			{
				for (int square=Sstartbox+1;square<Sendbox;square=square+1)
				{
					if (Chess.position[Fendbox][square]!=null){pathclear=false;}
				}
			}
		}
		if (Chess.position[Fendbox][Sendbox]==null && pathclear==true)//if the path is clear and the destination is empty
		{
			return true;//can move
		}
		if (Chess.position[Fendbox][Sendbox]==null)//if the path is not clear and destination is empty
		{
			return false;//return false
		}
		if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color) && pathclear==true)//if destination has enemy piece and path is clear
		{
			return true;// can move
		}
		return false;//if no confirmation that piece can move, then cant move
	}
}


