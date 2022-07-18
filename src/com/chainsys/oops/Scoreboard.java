package com.chainsys.oops;

public class Scoreboard {
	private int currentScore=167;
	private Scoreboard()
	{	
		System.out.println("Scoreboard created");
	}
	public int getScore()
	{
	 return currentScore;
	}
	// Factory Method
	public static Scoreboard getScoreBoard()
	{
	  return new Scoreboard();
	}
}
