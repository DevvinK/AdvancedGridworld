package advanced.gridworld;

import framework.info.gridworld.actor.ActorWorld;

public class AnimalRunner
{
	public static void main(String [] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new Dog());
		world.add(new Cat());
		world.show();
	}
}
