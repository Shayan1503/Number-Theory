/*
 * @author : Shayan Dasgupta
 * 
 * Finds the GCD of two numbers using the Euclidean Algorithm.
 */

import java.util.*;

class GCD
{
    static Scanner sc = new Scanner();
    public static void main(String[] args) 
    {
        driver();
        
        while(true)
        {
            System.out.println("Do you want to find the GCD of two more numbers? \nPress 1 for 'Yes' or 0 'No'.");
            int ch = sc.nextInt();
            
            switch(ch)
            {
                    case 1 -> driver();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid input.");
            }
        }
    }
   static int Euclidean_Algorithm(int a, int b)
    {
       // The idea is that for the equation a = bq + r, gcd(a, b) = gcd(b, r)
    	if (a%b == 0)
    		return b;
    	else
    		return Euclidean_Algorithm(b, a%b);
    }

    static void print(int a, int b, int rt)
    {
        if(rt == 0)
            System.out.println("("+a+","+b+") = " + Math.abs(a));
        else
            System.out.println("("+a+","+b+") = " + rt);
    }
    
    static void driver()
    {
        System.out.println("Enter the two numbers whose GCD you want to find :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        print(a,b,Euclidean_Algorithm(a,b));
    }
}
