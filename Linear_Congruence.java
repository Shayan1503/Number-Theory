/*
 * @author : Shayan Dasgupta
 * 
 * Solving a linear congruence of the form ax=b(mod m)
 */

import java.io.*;

class Linear_Congruence 
{
   public static void main(String[] args)throws IOException 
   {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	GCD gcd = new GCD();
		
	System.out.println("ax = b(mod m)\nEnter the values for");
	System.out.print("a = ");
	int a = Integer.parseInt(br.readLine());
	System.out.print("b = ");
	int b = Integer.parseInt(br.readLine());
	System.out.print("m = ");
	int m = Integer.parseInt(br.readLine());
		
	int d = gcd.Euclidean_Algorithm(a,m);
		
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
			x+=m;
		}
			
	}
	else
		System.out.println("The given linear congruence has 0 solutions.");
		
	while(true)
	{
		System.out.println("Do you want to find the solution of more linear congruences? \nPress 1 for 'Yes' or 0 'No'.");
		int ch = Integer.parseInt(br.readLine());
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
}
