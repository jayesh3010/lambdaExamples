package com.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LamdaUsage {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carrols",50),
				new Person("Thomas","Carlyle",20),
				new Person("Charlotte","Brante",100),
				new Person("Mathew","Arnold",5)
				);
		
		//sort list by last name
		Collections.sort(people, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));
		
		//print all persons in the list
		printall(people);
		
		System.out.println("==========================");
		//print all persons with last name starts with C
		//printallWithLastNameAsC(people);
		printConditionally(people,new Condition() {

			@Override
			public boolean checkCondition(Person p) {
				return p.getLastName().startsWith("C");
			}
			
		});
		
		System.out.println("==========================");
		printConditionally(people, p->p.getLastName().startsWith("C"));
		System.out.println("==========================");
		printWithPredicate(people, p->p.getLastName().startsWith("C"));
		
		System.out.println("==========================");
		printWithPredicate(people, p->true);

	}

	private static void printall(List<Person> people) {
		for(Person p: people) {
			System.out.println(p);
		}
	}
	
	
	private static void printallWithLastNameAsC(List<Person> people) {
		for(Person p: people) {
			if(p.getLastName().startsWith("C"))
			System.out.println(p);
		}
	}
	
	private static void printConditionally(List<Person> people,Condition c) {
		for(Person p: people) {
			if(c.checkCondition(p))
			System.out.println(p);
		}
	}
	
	private static void printWithPredicate(List<Person> people,Predicate<Person> pr) {
		for(Person p: people) {
			if(pr.test(p))
			System.out.println(p);
		}
	}


}


interface Condition
{
	boolean checkCondition(Person p);
}
