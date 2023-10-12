package com.hcl.test;


interface DisplayJerseyumber
{
	public int displayNumber();
}

public class LambdaExpressionWithReturnType {
	public static void main(String[] args) 
	{
		DisplayJerseyumber jn=() -> { return 63; };
		System.out.println(jn.displayNumber());
	}
}