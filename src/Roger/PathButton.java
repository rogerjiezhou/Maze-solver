package Roger;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class PathButton extends JButton implements MouseListener, MouseMotionListener{

	private int Path;
	private boolean game;
	private boolean visited = false;
	private boolean route = false;
	
	public PathButton(int P)
	{
		Path = P;
		if(Path == 0)
			this.setBackground(Color.BLUE);
		else if(Path == 1)
			this.setBackground(Color.RED);
		else
			this.setBackground(Color.YELLOW);
		addMouseListener(this);
		addMouseMotionListener(this);	
		game = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(game != true)
		{	
			if(this.getBackground() == Color.RED)
			{
				this.setBackground(Color.BLUE);
				this.Path = 0;
			}
			else if(this.getBackground() == Color.BLUE)
			{
				this.setBackground(Color.RED);
				this.Path = 1;
			}
			else;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setGame(boolean g)
	{
		game = g;
	}
	
	public int getPath()
	{
		return Path;
	}

	public void setRoute()
	{
		route = true;
		this.setBackground(Color.magenta);
	}
	
	public void setVisited()
	{
		visited = true;
//		this.setBackground(Color.gray);
	}
	
	public boolean isVisited()
	{
		return visited;
	}
	
}
