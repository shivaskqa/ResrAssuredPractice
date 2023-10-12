package com.hcl.test;


interface Add
{
	public void add(int a,int b);
}

public class LambdaExpressionWithTwoParametersnNoReturnType {

   Add calc=(i,j)->{System.out.println(i+j);};
}
