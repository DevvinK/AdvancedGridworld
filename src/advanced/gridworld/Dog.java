package advanced.gridworld;

import java.util.ArrayList;

import framework.info.gridworld.grid.Grid;
import framework.info.gridworld.grid.Location;
import framework.info.gridworld.actor.Actor;
import framework.info.gridworld.actor.Bug;

public class Dog extends Actor
{
	public Dog()
	{
		this.setColor(null);
	}
	
	public void act()
	{
		if (getGrid() == null)
		{
			return;
		}
		
		ArrayList<Actor> actors = getKitties();
		Location loc = selectMoveLocation(actors);
		makeMove(loc);
	}
	
	public ArrayList<Actor> getKitties()
	{
		ArrayList<Location> temp = getGrid().getOccupiedLocations();
		ArrayList<Actor> Kitties = new ArrayList<Actor>();
		
		for (Location current: temp)
		{
			if (getGrid().get(current) instanceof Cat)
			{
				Kitties.add(getGrid().get(current));
			}
		}
		
		
		return Kitties;
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors)
		{
			if (!(a instanceof Cat))
			{
				a.removeSelfFromGrid();
			}
		}
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		
		return getGrid().getEmptyAdjacentLocations(getLocation());
	}
	
	public Location selectMoveLocation(ArrayList<Actor> kitties)
	{
		int n = kitties.size();
		
		if (n ==0)
		{
			return getLocation();
		}
		
		int r =(int) (Math.random() * n);
		return kitties.get(r).getLocation();
	}
	
	public void makeMove (Location loc)
	{
		if (loc == null)
		{
			removeSelfFromGrid();
		}
		
		else
		{
			if(getGrid().get(this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(loc) )) == null)
			{
				loc = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(loc));
			}
			else
			{
				loc = this.getLocation();
			}
			moveTo(loc);
		}
	}
}
