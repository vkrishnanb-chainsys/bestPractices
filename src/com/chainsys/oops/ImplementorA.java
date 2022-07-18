package com.chainsys.oops;

public class ImplementorA implements IService
{

	@Override
	public void doTask() {
		System.out.println("A--- doTask");	
	}	
}
class ImplementorB implements IService
{
	@Override
	public void doTask() {
		System.out.println("B--- doTask");	
	}	
}