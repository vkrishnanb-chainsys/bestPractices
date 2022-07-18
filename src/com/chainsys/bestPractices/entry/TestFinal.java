package com.chainsys.bestPractices.entry;

public class TestFinal {
	private final int dataA; // read only field
	private static final int dataB=123; // constant
	public TestFinal(int x)
	{
		// Value can be assigned through the constructor
		dataA=x; 
	}
	public String toString()
	{
		return dataA+" "+ dataB;
	}
}
