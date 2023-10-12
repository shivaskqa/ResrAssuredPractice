package com.hcl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sentence="vestige creates health and wealth";
		
		arrangeVowelsInGivenString(sentence);
		
		char a[]=new char[10];
		
		for(int i=0;i<10;i++)
		{
			a[i]='i';
			System.out.print(a[i]+" ");
			
		}


		
		
		
		try
		{
			calc();
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Hi..");
		}
		
	}

	public static void calc()
	{
        System.out.println("Hi from Calc ... ");
		throw new Error("Getting this message from calc method: ");
	}
	
	public static void arrangeVowelsInGivenString(String text)
	{
		
		char ch[]=text.toCharArray();
		int countVowels=0;
		
		List<Character> listofChars=new ArrayList<Character>();
		
		for(Character c:ch)
		{
			if(c=='A' || c=='a' ||c=='E' || c=='e' ||c=='I' || c=='i' ||c=='O' || c=='o' ||c=='U' || c=='u' )
				{ countVowels++;
				listofChars.add(c);
				}
		}
		
		System.out.println("Before Sorting in the vowels ..");
		System.out.println(listofChars);
		System.out.println("After Sorting.."
				+ "");
		Collections.sort(listofChars);
		System.out.println(listofChars);
	}
	
}
