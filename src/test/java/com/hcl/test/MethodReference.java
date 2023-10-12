package com.hcl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Say
{
	void say();
}

public class MethodReference {

	public static void sayHello()
	{
		System.out.println("Say Hello to Java learners..");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listofWords=new ArrayList<String>();
		
		List<String> list=Arrays.asList("1","2","3");
		
		listofWords.add("Virat Kohli");
		listofWords.add("Rohit Sharma");
		listofWords.add("Surya Kumar Yadav");
		listofWords.add("Ishaan Kishan");
		listofWords.add("Tilak Verma");
		
		listofWords.stream().forEach(System.out::println);
		
		//Lambda Expression
		List<Integer> collect1=list.stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
		System.out.println(collect1);
		
		//With Method Reference
		List<Integer> collect2=list.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(collect2);
		
		//Static method reference
		Say s=MethodReference::sayHello;
		s.say();
		
	}

}
