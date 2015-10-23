import javax.swing.ImageIcon;


public class Queen extends Piece //Queen is subclass of piece
{
	
	private String blackfile=Chess.filesource+"bqueen.gif";//file name for icon for black queen
	private String whitefile=Chess.filesource+"wqueen.gif";//file name for icon for white queen

	public Queen(boolean isblack) //constructor for Queen
	{
		super(isblack);//brings in methods and variables from Piece
		if (isblack==true)//if queen is black
		{
		icon= new ImageIcon(blackfile);//icon is black queen
		color="black";//color is black
		}
		else
		{
		icon=new ImageIcon(whitefile);// icon is white queen
		color="white";//color is white
		}
	
	}
	public boolean canMove (int Fstartbox,int Sstartbox,int Fendbox,int Sendbox)//checks if the piece can move
	{
		boolean pathclear=true;//monitors if path is clear
		if (Sendbox!=Sstartbox && Fendbox!=Fstartbox && Math.abs(Fstartbox-Fendbox)!=Math.abs(Sstartbox-Sendbox))//if the piece doesnt move diagonally or laterally
		{return false;}//cant move
		if (Sendbox==Sstartbox || Fendbox==Fstartbox)//if moving horizontally, runs the exact code from the rook canMove method
		{
			if (Sendbox==Sstartbox)
			{
				if (Fstartbox>Fendbox)
				{
					for (int square=Fstartbox-1;square>Fendbox;square=square-1)
					{
						if (Chess.position[square][Sendbox]!=null)
						{
							pathclear=false;
						}
					}
				}
				if (Fstartbox<Fendbox)
				{
					for (int square=Fstartbox+1;square<Fendbox;square=square+1)
					{
						if (Chess.position[square][Sendbox]!=null){pathclear=false;}
					}
				}
			}
		
			if (Fendbox==Fstartbox)
			{
				if (Sstartbox>Sendbox)
				{
					for (int square=Sstartbox-1;square>Sendbox;square=square-1)
					{
						if (Chess.position[Fendbox][square]!=null){pathclear=false;}
					}
				}
				if (Sstartbox<Sendbox)
				{
					for (int square=Sstartbox+1;square<Sendbox;square=square+1)
					{
						if (Chess.position[Fendbox][square]!=null){pathclear=false;}
					}
				}
			}
		}
		else if ((Math.abs(Fstartbox-Fendbox)==Math.abs(Sstartbox-Sendbox)))//if moving diagonoally, runs exact code from canMove in bishop
		{
			if (Fendbox>Fstartbox && Sendbox>Sstartbox)
			{
				for (int counter=1;counter<(Fendbox-Fstartbox);counter++)
				{
					if (Chess.position[Fstartbox+counter][Sstartbox+counter]!=null)
						{pathclear=false;}
				}
			}
			if (Fendbox<Fstartbox && Sendbox>Sstartbox)
			{
				for (int counter=1;counter<(Fstartbox-Fendbox);counter++)
				{
					if (Chess.position[Fstartbox-counter][Sstartbox+counter]!=null)
						{pathclear=false;}
				}
			}
			if (Fendbox<Fstartbox && Sendbox<Sstartbox)
			{
				for (int counter=1;counter<(Fstartbox-Fendbox);counter++)
				{
					if (Chess.position[Fstartbox-counter][Sstartbox-counter]!=null)
						{pathclear=false;}
				}
			}
			if (Fendbox>Fstartbox && Sendbox<Sstartbox)
			{
				for (int counter=1;counter<(Fendbox-Fstartbox);counter++)
				{
					if (Chess.position[Fstartbox+counter][Sstartbox-counter]!=null)
						{pathclear=false;}
				}
			}
		}
		if (Chess.position[Fendbox][Sendbox]==null && pathclear==true)//if path clear and destination is empty
		{
			return true;//can move
		}
		if (Chess.position[Fendbox][Sendbox]==null)//if destination empty but path not clear
		{
			return false;//cant move
		}
		if (!Chess.position[Fstartbox][Sstartbox].color.equals(Chess.position[Fendbox][Sendbox].color) && pathclear==true)//if path clear and destination is enemy piece
		{
			return true;//can move
		}

		return false;//if hasnt returned true by this point, piece cant move
	}

}
