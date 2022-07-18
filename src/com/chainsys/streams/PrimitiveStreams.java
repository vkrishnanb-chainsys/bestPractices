package com.chainsys.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
	public static void lessonOne()
	{
		Stream s1=Stream.empty();
		
		IntStream intstream = IntStream.of(1, 2, 3, 4, 5);
		System.out.println("Count: "+intstream.count());
		//  java.lang.IllegalStateException: stream has already been operated upon or closed
		// Whenever a terminal operation is called on a Stream object, the instance gets consumed and closed.
		System.out.println("Array: "+intstream.toArray());
		System.out.println(intstream.findFirst().getAsInt());
		System.out.println("Sum: "+intstream.sum());
		
	}
	public static void boxedStream()
	{
		Stream<Integer> intstream = IntStream.of(1, 2, 3, 4, 5).boxed();
		System.out.println("Count: "+intstream.count());
//		System.out.println("List: "+intstream.toList());
//		System.out.println(intstream.findFirst().get());
	}
	public static void streamSupplier()
	{
		Supplier<Stream<Integer>> intSupplierStream =  ()-> Stream.of(10, 2, 3, 4, 5);
		System.out.println("Count: "+intSupplierStream.get().count());
		System.out.println("First: "+intSupplierStream.get().findFirst().get());
		System.out.println("List: "+intSupplierStream.get().toList());
	}
	public static void lessonFour()
	{
		LongStream longstream = LongStream.of(1, 2, 3, 4, 5);
		DoubleStream doublestream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		
	}
	public static void findAnyTest()
	{
//		Supplier<Stream<Integer>> intstream = ()->Stream.of(1, 2, 3, 4, 5);
//		for(int i=0;i<100;i++)
//		{
//		System.out.print(intstream.get().findAny().get()+" , ");
//		}
		// In a non-parallel operation, it will most likely return the first element in the Stream, but there is no guarantee for this.
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i< 100; i++){
		 list.add(i);
		}
		System.out.println(list.parallelStream().findFirst().get());
		System.out.println(list.parallelStream().findAny().get());
//		for(int i=0;i<100;i++)
//		{
//		System.out.print(list.parallelStream().findAny().get()+" , ");
//		}
	}
}
