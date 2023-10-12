package com.hcl.test;


interface Calc
{
	public int add(int a,int b);
}


public class LambdaExpressionWithTwoParamsnReturnType {

	public static void main(String a[])
	{

		Calc c=(i,j)-> { return i+j; };
		
		System.out.println(c.add(20,30));
		
	}
	
}
