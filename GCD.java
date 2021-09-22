/*
 * @author : Shayan Dasgupta
 * 
 * Finds the GCD of two numbers using the Euclidean Algorithm.
 */

import java.io.*;

class GCD
{
    public static void main(String args[]) throws IOException
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the two numbers whose GCD you want to find :");
        int a =Integer.parseInt(br.readLine());
        int b =Integer.parseInt(br.readLine());
        
        // Program doesn't work when b<a
        if(b<a)
        {
        	a = a + b;
        	b = a - b;
        	a = a - b;
        }
        
        print(a,b,Euclidean_Algorithm(a,b));

        while(true)
        {
            System.out.println("Do you want to find the GCD of two more numbers? \nPress 1 for 'Yes' or 0 'No'.");
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
            System.out.println("("+a+","+b+") = "+Math.max(Math.abs(a), Math.abs(b)));
        else
            System.out.println("("+a+","+b+") = " + rt);//(go check notebook)
    }
}
