package com.chainsys.oops;

public interface IService {
	void doTask();
	default void completedTask()
	{
		System.out.println("Task Completed");
	}
}
