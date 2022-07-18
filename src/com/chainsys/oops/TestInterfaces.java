package com.chainsys.oops;

public class TestInterfaces {
	public static void testImplementationA()
	{
		IService implOne = new ImplementorA();
		implOne.doTask();
		implOne.completedTask();
	}
	public static void testImplementationB()
	{
		IService implOne = new ImplementorB();
		implOne.doTask();
		implOne.completedTask();
	}
}
