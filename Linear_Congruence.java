/*
 * @author : Shayan Dasgupta
 * 
 * Solving a linear congruence of the form ax=b(mod m)
 */

import java.util.*;

class Linear_Congruence 
{
	static Scanner sc = new Scanner(System.in);
   	public static void main(String[] args)
	{
		driver();
		
		while(true)
		{
			System.out.println("Do you want to find the solution to more linear congruences? \nPress 1 for 'Yes' or 0 for 'No'.");
			int ch = sc.nextInt();
			
			switch(ch)
			{
					case 1 -> driver();
					case 0 -> System.exit(0);
					default -> System.out.println("Invalid input.");
			}
		}
	}
	
   	static int Congruence(int a, int b, int m)
   	{
		while(a != 1)
		{
			b += m;
			
			if(b%a == 0)
			{
				b /= a;
				a /= a;
			}		
		}
	   
		return b;
    	}
	
	static void driver()
	{
		System.out.println("ax = b(mod m)\nEnter the values for");
		System.out.print("a = ");
		int a = sc.nextInt();
		System.out.print("b = ");
		int b = sc.nextInt();
		System.out.print("m = ");
		int m = sc.nextInt();
		
		int d = GCD.Euclidean_Algorithm(a,m);
		
		int x;
		if(b%d == 0)
		{
			a /= d;
			b /= d;
			m /= d;
			
			System.out.println("The given linear congruence has exactly " +d+ " unique solution(s), which are");
			x = Congruence(a,b,m);
			
			while(d>0)
			{
				System.out.println(x);
				d--;
				x += m;
			}
		}
		else
			System.out.println("The given linear congruence has 0 solutions.");
	}
}
