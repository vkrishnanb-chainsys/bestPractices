package com.chainsys.oops;

public class TestScoreboard {
	public static void main(String[] args) {
		Scoreboard sb = Scoreboard.getScoreBoard();
		int score=sb.getScore();
		System.out.println(score);
	}
}