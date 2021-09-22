/*
 * @author : Shayan Dasgupta
 * 
 * Aim : Finding all the solutions to a linear diophantine equation using congruences
 */

import java.util.*;

class Linear_Diophantine
{
	static int a,b,c;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        GCD gcd = new GCD();
        Linear_Congruence cong = new Linear_Congruence();
        
        System.out.println("ax + by = c\nEnter the values for");
        System.out.print("a = ");
		a = sc.nextInt();
		System.out.print("b = ");
		b = sc.nextInt();
		System.out.print("c = ");
		c = sc.nextInt();
		
		double startTime = System.nanoTime();
		
		int d = gcd.Euclidean_Algorithm(a, b);
		
		if(c%d == 0)
		{
			a /= d; 
			b /= d; 
			c /= d;

			int x = cong.Congruence(a, c, b);
			int y = (c-a*x)/b;
			System.out.println("The given Linear Diophantine equation has infinite solutions in the form");
			display(x,y);
		}
		else
		System.out.println("The given Linear Diophantine equation has 0 solutions.");
		
		double endTime = System.nanoTime();
	    System.out.println("\nTook "+((endTime - startTime)/Math.pow(10,9))+" seconds.");
	    while(true)
	        {
	            System.out.println("Do you want to find the solution of more linear diophantine equations? \nPress 1 for 'Yes' or 0 'No'.");
	            int ch = sc.nextInt();
	            switch(ch)
	            {
	            case 1: main(null);
	            		break;
	            case 0: System.exit(0);
	            		break;
	            default: System.out.println("Invalid input.");
	            }
	        }	
    	}
   
    static void display(int X, int Y)
    {
    	int A = Math.abs(a);
    	int B = Math.abs(b);
    	if(a>0&&b>0)
    	{
    		System.out.println("x = " +X+ " + " +B+ "t");
    		System.out.println("y = " +Y+ " - " +A+ "t");
    	}
    	else if(a>0&&b<0)
    	{
    		System.out.println("x = " +X+ " - " +B+ "t");
    		System.out.println("y = " +Y+ " - " +A+ "t");
    	}
    	else if(a<0&&b>0)
    	{
    		System.out.println("x = " +X+ " + " +B+ "t");
    		System.out.println("y = " +Y+ " + " +A+ "t");
    	}
    	else if(a<0&&b<0)
    	{
    		System.out.println("x = " +X+ " - " +B+ "t");
    		System.out.println("y = " +Y+ " + " +A+ "t");
    	}
    }
}
