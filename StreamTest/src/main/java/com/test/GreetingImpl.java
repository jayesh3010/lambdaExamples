package com.test;

public class GreetingImpl implements Greeting {

	@Override
	public void greet(String s) {
		System.out.println("Hello " + s);
	}

}
