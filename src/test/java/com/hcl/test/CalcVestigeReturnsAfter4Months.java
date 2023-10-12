package com.hcl.test;

public class CalcVestigeReturnsAfter4Months {

	public static void main(String[] args) {
		
		float pointValue=500;
		printReturnFromVestige(pointValue);
		
	}

	private static void printReturnFromVestige(float pointValue) {
		// TODO Auto-generated method stub
		
		float totalreturnOnPurchase=0,returnOnPurchase=0;
		float totalReturnOnCashBack=0,cashBackValue=0;
		float totalConsistencyOffer=0;
		float discountPriceAfterFourMonths=0;
		
		if(pointValue>=100)
		{
			
			returnOnPurchase=250;
			cashBackValue=144;
			
			int pointValueRounded=(int)pointValue/100;	
			totalreturnOnPurchase= returnOnPurchase * pointValueRounded * 4;
			totalReturnOnCashBack= cashBackValue * pointValueRounded * 4;
			totalConsistencyOffer = 2500 * pointValueRounded;
			
			discountPriceAfterFourMonths = totalreturnOnPurchase + totalReturnOnCashBack + totalConsistencyOffer;
			
			System.out.println("****** The Vestige will give after four months if he/she maintains consistency more than or equal to 100 PV per a month:  " );
			System.out.println("Total Return on Purchase : "+totalreturnOnPurchase);
			System.out.println("Total Return on Cash Back : "+totalReturnOnCashBack);
			System.out.println(" Total Returns on consistency offer : "+totalConsistencyOffer);
			System.out.println("Total discount : "+discountPriceAfterFourMonths);
			
			
		}
		else if(pointValue>=60 && pointValue<100)
		{

			returnOnPurchase=150;
			cashBackValue=90;
			
			int pointValueRounded=(int)pointValue/100;	
			totalreturnOnPurchase= returnOnPurchase * pointValueRounded;
			totalReturnOnCashBack= cashBackValue * pointValueRounded;
			totalConsistencyOffer = 1250 * pointValueRounded;
			
			discountPriceAfterFourMonths = totalreturnOnPurchase + totalReturnOnCashBack + totalConsistencyOffer;
			
			System.out.println("****** The Vestige will give after four months if he/she maintains consistency 60 PV per a month:  " );
			System.out.println("Total Return on Purchase : "+totalreturnOnPurchase);
			System.out.println("Total Return on Cash Back : "+totalReturnOnCashBack);
			System.out.println(" Total Returns on consistency offer : "+totalConsistencyOffer);
			System.out.println("Total discount : "+discountPriceAfterFourMonths);
			
		}
	}
}
