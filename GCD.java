/*
 * @author : Shayan Dasgupta
 * 
 * Aim : Finds the GCD of two numbers using the Euclidean Algorithm.
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

        if(b<a)
        {
        	a = a + b;
        	b = a - b;
        	a = a - b;
        }
        
        double startTime = System.nanoTime();

        print(a,b,Euclidean_Algorithm(a,b));

        double endTime = System.nanoTime();
        System.out.println("\nTook "+((endTime - startTime)/Math.pow(10,9))+" seconds.");

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

//    int compute(int a, int b)
//    {
//    	//We need the absolute values of a and b since other classes which call this method can send negative integers too, and the algorithm works best with positive integers
//        a = Math.abs(a);
//        b = Math.abs(b);
//        int q = 1, r = 1;
//
//        //my algorithm only works properly when a>b, so in case it's the other way around this condition will solve that problem by swapping the values
//        if(b>a)
//        {
//            a = a + b;
//            b = a - b;
//            a = a - b;
//        }
//
//        if(a == 0 || b == 0)
//        {
//            return 0;
//        }
//        else
//        {
//            //main while loop which gives us the GCD by implementing the Euclidean Algorithm
//            while(r>0)//runs only for positive values for r.
//            {
//                q = 1;//need to restart from 1 since q is the multiplier
//                
//                //the loop below gives us the q which on multiplying with b gives us an integer closest to a
//                while((q*b)<=a)
//                {
//                    q++;
//                }
//                q--;//need to reduce it by 1 since the while loop continues for an extra loop
//                // ^^(try fixing this in the loop itself later)^^
//                r = a-b*q;
//                //System.out.println(a+" = "+b+" * "+q+" + "+r);
//                if(r == 0)
//                    break;
//                //this here is where we get new a and b for the next equation for the division algorithm
//                a = b;
//                b = r;
//            }
//        }
//        return b;
//    }
}