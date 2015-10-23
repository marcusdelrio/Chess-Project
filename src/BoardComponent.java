import java.awt.Color;// calls necessary libraries
import java.awt.Graphics;

import javax.swing.JComponent;


public class BoardComponent extends JComponent//board component extends Jcomponent from swing library
{
	public void paintComponent(Graphics tan)//makes painting component with a graphics variable
	{
		
		{
			int x=0;
			int y=0;
			int width=50;//width of each square on the chessboard
			Color firstcolor=new Color(233,174,95);//creates first color tan
			Color secondcolor=new Color(177,113,24);//crrates second color brown
			tan.setColor(firstcolor);//sets color of tan graphics variable
			Graphics brown=tan.create();//creates new graphics variable brown
			brown.setColor(secondcolor);//sets color to brown
			for (int j=0;j<8;j++)//for each row
			{	
			for (int i=0;i<8;i++)//for each column
				{
				if (j%2==0)// if an even row
					{
					if (i%2==0){brown.fillRect((x+50)*i,y,width,width);}//draw brown squares on even columns
					else{tan.fillRect((x+50)*i, y, width, width);}//else draw a tan square
					}
				else//if an odd row
					{
					if (i%2==0){tan.fillRect((x+50)*i,y,width,width);}//draw a tan square on even columns
					else{brown.fillRect((x+50)*i, y, width, width);}//else draw a brown square
					}
				}
			y=y+50;//move one row down for drawing purposes
			}	
			for (int row=0;row<8;row++)//for each row
			{
				for (int col=0;col<8;col++)//for each column
				{
					if (Chess.position[row][col]!=null)//if the position coordinate corresponds to a piece, draw the piece at the correct location
					{Chess.position[row][col].drawPiece(tan, col*50, row*50);}//calls the Piece's drawPiece method at the correct point
				}
			}
			
		}
		
	}
	
}
