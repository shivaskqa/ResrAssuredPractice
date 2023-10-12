package com.hcl.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class PracticeJava8Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers=Arrays.asList(12,14,21,25,27,33,3,1,1,2,3,5,7,8,9,3,5,8,10,11,54);
		
		System.out.println(" Print distinct numbers via streams -- using Java8 methods");
		numbers.stream().distinct().collect(Collectors.toList()).forEach(e->System.out.println(e+" "));
		System.out.println(" Print odd numbers via streams.. ");
		numbers.parallelStream().filter(e->e%2!=0).collect(Collectors.toList()).forEach(e->System.out.println(e+" "));
		System.out.println("Swap two numbers without using third variable..");
		System.out.println("Using Java8 print vowels in a given string..");
		String text="Using Java8 we are priting vowels in a given string";
		
		IntPredicate vowel=new IntPredicate() {
			
			@Override
			public boolean test(int c) {
			
				return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || 
					   c=='A' || c=='E' || c=='I' || c== 'O' || c=='U';
			}
		};
		
		long vowelCount=text.toLowerCase().chars().distinct().filter(vowel).count();
		
		System.out.println("Vowels and Consonants count in given string.. "+vowelCount);
		countOfVowelsnConsonantsInGivenString(text);
		
		System.out.println("Vowels and Consonants count in given string using Java 8.. "+vowelCount);
		countOfVowelsnConsonantsInGivenStringUsingJava8(text);
		
		System.out.println("Print HashMap keys and values..");
		displayHashMapKV();
		
		String s="Hello World";
		Set<String> setofstrings=new HashSet(Arrays.asList(s.split(" ")));
		setofstrings.stream().forEach(e->System.out.println(e));
		
	}

	private static void displayHashMapKV() {
		// TODO Auto-generated method stub
		Map<Integer,String> data=new LinkedHashMap<Integer,String>();
		data.put(18, "Virat Kohli");
		data.put(45, "Rohit Sharma");
		data.put(17, "Rishabh Pant");
		data.put(32, "Ishaan Kishan");
		data.put(63, "Surya Kumar Yadav");
		data.put(99, "Ravichandran Ashwin");
		
		for(Map.Entry<Integer,String> entry:data.entrySet())
			 System.out.println(entry.getKey()+ " "+entry.getValue());
		data.keySet().stream().forEach(t->System.out.println(t+" : "+data.get(t)));
		
		
		
	}

	private static void countOfVowelsnConsonantsInGivenStringUsingJava8(String text) {
		
		if(null==text)
    	  throw new IllegalArgumentException("Input string cant be null ");
      
       text=Arrays.asList(text.toLowerCase().split("")).stream().distinct().collect(Collectors.joining());
       
       System.out.println(text);

       long vowelsCount=text
    		     .chars()
    		     .filter(ch->(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || 
    		             ch=='A' || ch=='E' || ch=='I' || ch== 'O' || ch=='U'))
    		     .count();
       
       System.out.println(vowelsCount);
		
       long consonantsCount=text
  		     .chars()
  		     .filter(ch->(ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
  		     .filter(ch->(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u' && 
  		             ch!='A' && ch!='E' && ch!='I' && ch!= 'O' &&  ch!='U'))
  		     .count();
       System.out.println(consonantsCount);
		
	}

	private static void countOfVowelsnConsonantsInGivenString(String tempText) {
		
		int vCount = 0,cCount = 0;
		
		char ch[]=tempText.toLowerCase().toCharArray();
		
		
		
		for(Character c:ch)
		{
			//if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c== 'O' || c=='U')
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' )
			     vCount++;
			else if(c>='a' || c<='z' || c>='A' || c<='Z' )
				cCount++;
		}

		System.out.println("Vowels count in given String .. "+vCount);
		System.out.println("Consonants count in given String.. "+cCount);
		
	}

	private static void swapTwoNumbersWithoutThirdVariable(int i, int j) {
		// TODO Auto-generated method stub
		
		i=i+j;
		j=i-j;
		i=i-j;
		
		System.out.println(i+" "+j);
		
	}

}
