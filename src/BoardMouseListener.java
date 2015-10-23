import java.awt.event.MouseEvent;//necessary imports for mouse listener
import java.awt.event.MouseListener;



public class BoardMouseListener implements MouseListener //Board mouse listener will implement the MOUselistener interface
{
	public static int startboxX=0;//X value of the chosen starting box
	public static int startboxY=0;//Y value of the chosen starting box
	
	
	public void mouseClicked(MouseEvent arg0) {
		
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
		
		startboxX=((arg0.getX()-8)/50);//sets the value to the X point where the mouse was clicked
		startboxY=((arg0.getY()-30)/50);//sets the value to the Y point where the mouse was clicked
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		int endboxX=((arg0.getX()-8)/50);//sets position of final X coordinate
		int endboxY=((arg0.getY()-30)/50);//sets position of final Y coordinate
		if (Chess.position[startboxY][startboxX].color.equals("white"))//if a white piece is to be moved
		{
			if (Chess.position[startboxY][startboxX].canMove(startboxY,startboxX,endboxY,endboxX))//runs canMove function for specific piece
			{
				Chess.position[endboxY][endboxX]=Chess.position[startboxY][startboxX];//destination icon becomes start icon
				Chess.position[startboxY][startboxX]=null;//start icon becomes null
				Chess.WhitesTurn=false;//after move is made for white, changes to black turn
				Chess.AIplayer();//method which moves the piece for black
				Chess.mywindow.repaint();//repaints the window to show changes
			}
		}	
		
		
	}
	
		
		
	}


