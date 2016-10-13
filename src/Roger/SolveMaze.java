package Roger;

import java.util.Stack;

public class SolveMaze {

	PathButton []Maze;
	boolean find = false;
	int location;
	int size;
	Stack<Integer> s = null;
	
	public SolveMaze(PathButton []input)
	{
		int length = input.length;
		size = (int) Math.sqrt(length);
		Maze = new PathButton[length];
		for(int i = 0 ; i < length ; i++)
		{
			Maze[i] = input[i];
			if(input[i].getPath() == 2)
				location = i;
		}
		System.out.println(location);
		Solve();
		
	}

	public void Solve()
	{
		s = new Stack<Integer>();
		recursive(location);
		System.out.println(s.size());
	}
	
	public void recursive(int location)
	{
		if(Maze[location].getPath() != 3)
		{
			s.push(location);
			System.out.println(location);
			/* left */
			if((location % size != 0) && find != true && Maze[location - 1].isVisited() == false && Maze[location-1].getPath() != 0)
			{
				Maze[location].setVisited();
				recursive(location-1);
			}
			/* up */
			if(((location - size) >= 0) && find != true && Maze[location - size].isVisited() == false && Maze[location - size].getPath() != 0)
			{
				Maze[location].setVisited();
				recursive(location -size);
			}
			/* right */
			if((location % size != 11) && find != true && Maze[location + 1].isVisited() == false && Maze[location + 1].getPath() != 0)
			{
				Maze[location].setVisited();
				recursive(location+1);
			}
			/* down */
			if(((location + size) <= Maze.length) && find != true && Maze[location + size].isVisited() == false && Maze[location + size].getPath() != 0)
			{
				Maze[location].setVisited();
				recursive(location + size);
			}
			Maze[location].setVisited();
			if(find == true)
			{
			   int temp = s.pop();
			   Maze[temp].setRoute();
			}
			else
			{
				s.pop();
			}

		}
		else
		{
			find = true;
		    Maze[location].setRoute();
		    System.out.println(s.size());

		}
	}
}
