package com.chainsys.streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// Stream - A sequence of elements computed on demand
// 			supports sequential and parallel aggregate operations

public class StreamLessons {
	public static void streamEvenNumbersList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
//		List<Integer> list = Arrays.asList(10,20,30,40,50);
		Stream<Integer> intstream = list.stream();
		List<Integer> evenNumbersList = 
				intstream.filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
		System.out.print(evenNumbersList);
	}

	public static void streamReduce() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}

	public static void streamCollect() {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

		Stream<Integer> stream = list.stream();
		Integer sum = stream.collect(
				Collectors.summingInt(Integer::intValue));
		System.out.println(sum);
	}

	public static void streamCreation() {
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		streamOne.forEach(p -> System.out.println(p));
		Stream<Integer> streamTwo = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		//
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
		randomNumbers.limit(20).forEach(System.out::println);
	}

	public static void streamFilter() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);
	}

	public static void streamMap() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
		// The map() intermediate operation converts each element
		// in the stream into another object via the given function.
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

	}

	public static void streamStateful() {
		for (int i = 0; i < 5; i++) {

			Set<Integer> seen = new HashSet<>();
			IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream.parallel().map(
					// stateful behavioral parameter.
					e -> {
						if (seen.add(e))
							return e;
						else
							return 0;
					}).sum();

			System.out.println(sum);

		}
	}

	public static void streamSkip() {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).skip(2).forEach(i -> System.out.print(i + " "));

	}

	public static void streamDistinct() {
		List<String> memberNames = new ArrayList<String>();
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Arjun");
		memberNames.add("Kamal");
		memberNames.add("Kamal");
		memberNames.add("Arun");
		memberNames.add("Sanjay");
		memberNames.stream().distinct().forEach(System.out::println);
	}

	public static void streamPeek() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

//		 list.stream().peek(System.out::println);
//		list.stream().forEach(System.out::println);
		/*
		 * // without filter - count does not process all the elements 
		 * list.stream().peek(System.out::println) .count();
		 */
		/*
		 * list.stream() .filter(i -> i%2==0) .peek(System.out::println) .count();
		 */
		/*
		 * // forEach will process all the elements
		 * list.stream().peek(System.out::print).forEach(e->System.out.println());
		 */
		// collect will process all the elements
		 list.stream() .peek(System.out::println).collect(Collectors.toList());


	}

	public static void testStreamPeek() {
		/*
		 * Stream.of("one", "two", "three", "four") .peek(System.out::println)
		 * .collect(Collectors.toList());
		 */
		/*
		 * Stream.of("one", "two", "three", "four") .peek(e->e.toUpperCase())
		 * .forEach(System.out::println);
		 */

		Stream.of("one", "two", "three", "four").map(String::toUpperCase)// .map(s->s.toUpperCase())
				.forEach(System.out::println);

		/*
		 * // peek() can be useful in altering the inner state of an element // without
		 * replacing the element Stream<Emp> empStream = Stream.of(new Emp(100,"Alice"),
		 * new Emp(101,"Bob"), new Emp(102,"Chuck")); empStream.peek(e ->
		 * e.setName(e.getName().toLowerCase())) .forEach(System.out::println);
		 */
		/*
		 * Stream.of("one", "two", "three", "four") .filter(e -> e.length() > 3) .peek(e
		 * -> System.out.println("Filtered value: " + e)) .map(String::toUpperCase)
		 * .peek(e -> System.out.println("Mapped value: " + e))
		 * .collect(Collectors.toList());
		 */
	}

	public static void testAStateful() {
		for (int i = 0; i < 5; i++) {
			processB();
		}
	}

	private static int count = 0;

	private static void processA() {
		count = 0;
		IntStream stream = IntStream.range(1, 1000);
		// finding the sum of even numbers
		int sum = stream.parallel().filter(i -> {
			boolean b = i % 2 == 0;
			if (b) {
				count++;// updating count hence making lambda stateful.
			}
			return b;
		}).sum();

		System.out.printf("sum :%d  count:%d%n", sum, count);
	}

	private static void processB() {
		IntStream stream = IntStream.range(1, 1000);

		// finding the even numbers
		int[] even = stream.parallel().filter(i -> i % 2 == 0).toArray();

		// finding sum
		int sum = IntStream.of(even).parallel().sum();

		System.out.printf("sum :%d  count:%d%n", sum, even.length);
	}
}

class Emp {
	private int id;
	private String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return getName();
	}
}