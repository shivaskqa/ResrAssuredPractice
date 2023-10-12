
package com.hcl.test;


interface Sayable{
	public void say(String message);

}

public class LambdaExpressionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	//anonymous implementation..	
     /* Sayable d=new Sayable() {
    	  
    	  public void say(String message)
    	  {
    		  System.out.println("Say "+message);
    	  }
    	  
      };
		
      d.say("Hello..");

	}
*/	
	//With Lambda Expression..
	Sayable s1=name-> System.out.print(name);
		s1.say("Hello..");
	}	

}


