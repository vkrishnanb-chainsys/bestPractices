package com.chainsys.lambda;

import java.util.ArrayList;
// SAM - Single Abstract Method Interface
interface IntegerFunction{
	Integer doOperation(int x, int y);
}
public class Lessons {
	public static void demoA()
	{
		ArrayList<Integer> nos=new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		nos.forEach((n)-> System.out.println(n));
	}
	public static void demoB()
	{
		ArrayList<Integer> nos=new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		nos.forEach((n)-> 
		{
			int i=100;
			int result=n+i;
			System.out.println("n="+n+" n+100: "+result);
		}
		);
	}
	public static void demoC()
	{
		IntegerFunction add=(x,y)-> x+y;
		int result=add.doOperation(123,50);
		System.out.println(result);
	}
	public static void demoD()
	{
		IntegerFunction getTotal=(x,y)->x+y;
		ArrayList<Integer> nos=new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		int i=100;
		nos.forEach((n)-> 
		{
			int result=0;
			result=getTotal.doOperation(n, i);
			System.out.println(" total: "+result);
		}
		);
	}
}
