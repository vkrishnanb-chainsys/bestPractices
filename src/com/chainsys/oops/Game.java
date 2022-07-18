package com.chainsys.oops;

public class Game {
	private int duration;
	// public Game() {}
	public Game(int time) {duration=time;}
	public void startPlaying()
	{
		System.out.println("Game started");
	}
}

class VideoGame extends Game
{
	public VideoGame()
	{
		super(0);
	}
	public VideoGame(int time)
	{
		super(time);
	}
}
