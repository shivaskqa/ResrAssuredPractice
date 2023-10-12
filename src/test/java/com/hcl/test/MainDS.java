package com.hcl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Generic> g=new ArrayList<>();
		Generic<?> g1=new Generic<>(10);
		Generic<?> g2=new Generic<>("Hello");

		g.add(g1);
		g.add(g2);
		
		//int i=g.get(0).getValue();
		
		//String s=g.get(1).getValue();
		
		int[] scores= {1,3,8,3,5,6,2,4};
		
		List<Integer> bestScore=Arrays.stream(scores).boxed().sorted().skip(5).collect(Collectors.toList());
		
		System.out.println(bestScore);
		
		Function<List<Integer>,Integer> function=x->x.stream()
				.map(i->i*2)
				.mapToInt(i->i)
				.distinct()
				.sum();
		
		Function <Integer,Integer> function2=x->x*10;
		Function <Integer,Integer> function3=x->x*100;
		
		int len=function.andThen(function2).andThen(function3).apply(Arrays.asList(1,2,2));
		System.out.println(len);
		
		
	}

}
