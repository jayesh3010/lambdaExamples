package com.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello World!!!");
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		System.out.println(strings.stream().filter(a -> a.length()==3).toString());

		new GreetingImpl().greet("World!");
		
		Greeting greeting = (s) -> System.out.println("Hello Lamda " + s);
		
		greeting.greet("Mars");
		
		AdditionLamda al = (a, b) -> a+b;
		
		System.out.println(al.add(100, 200));
		
		DivisionLamda dl = (a, b) -> {
			if(b==0) return 0.0;
			else return a/b;
		};
		
		System.out.println(dl.division(200, 100));
		
		StringLengthLamda sll = s -> s.length();
		
		System.out.println(sll.getLength("this is string"));
		
		new Thread(()->System.out.println("This is in thread!")).start();
	}
}

@FunctionalInterface
interface AdditionLamda {
	public int add(int a, int b);
}

@FunctionalInterface
interface DivisionLamda {
	public double division(int a, int b);
}

@FunctionalInterface
interface StringLengthLamda{
	int getLength(String s);
}
