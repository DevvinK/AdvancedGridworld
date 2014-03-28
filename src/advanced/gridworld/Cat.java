package advanced.gridworld;

import framework.info.gridworld.actor.Actor;
import framework.info.gridworld.actor.Bug;
import framework.info.gridworld.grid.Grid;
import framework.info.gridworld.grid.Location;


public class Cat extends Bug
{
	public Cat()
	{
		this.setColor(null);
	}
	
	
	public void move()
	{
		Grid<Actor>gr = getGrid();
		
		if (gr == null)
		{
			return;
		}
		
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		
		if (gr.isValid(next))
		{
			moveTo(next);
		}
		
		else
		{
			removeSelfFromGrid();
		}
	}
	
	public void act()
	{
		if (canMove())
		{
			move();
		}
		
		else
		{
			turn();
		}
	}
}
