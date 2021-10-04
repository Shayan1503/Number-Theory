/*
 * @author : Shayan Dasgupta
 * 
 * Finding all the solutions to a linear diophantine equation using congruences
 */

import java.util.*;

class Linear_Diophantine
{
	static int a,b,c;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		driver();
		
		while(true)
		{
			System.out.println("Do you want to find the solution of more linear diophantine equations? \nPress 1 for 'Yes' or 0 'No'.");
			int ch = sc.nextInt();
			
			switch(ch)
			{
					case 1 -> driver();
					case 0 -> System.exit(0);
					default -> System.out.println("Invalid input.");
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
	
	static void driver()
	{
		System.out.println("ax + by = c\nEnter the values for");
        	System.out.print("a = ");
		a = sc.nextInt();
		System.out.print("b = ");
		b = sc.nextInt();
		System.out.print("c = ");
		c = sc.nextInt();
		
		int d = GCD.Euclidean_Algorithm(a, b);
		
		if(c%d == 0)
		{
			a /= d; 
			b /= d; 
			c /= d;

			int x = Linear_Congruence.Congruence(a, c, b);
			int y = (c-a*x)/b;
			System.out.println("The given Linear Diophantine equation has infinite solutions in the form");
			display(x,y);
		}
		else
			System.out.println("The given Linear Diophantine equation has 0 solutions.");
	}
}
