/*
 * @author : Shayan Dasgupta
 * 
 * Aim : Trying to find an algorithm that gives us the the unique prime factorisation of an integer in the smallest time possible.
 */
import java.io.*;
// import java.util.Arrays;
class Factorisation

{
    public static void main (String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number:");
        int n = Integer.parseInt(br.readLine());
        System.out.print(n+" = ");

        double startTime = System.nanoTime();

        int copy = n;
        if(n == 0)
            System.out.println("1*0");
        else
        {
            System.out.print("1*");
            for(int i = 2; i <= copy; i++)
            {
                if(isprime(i))//method prime returns true if 'i' is a prime number
                {
                    int pow = check(copy,i);//method check gets the power of that prime
                    if(pow!=0)
                    {
                        display(i,pow,copy);
                    }
                    //this prime needs to be removed from the original number in order to find the other factors
                    copy = (int)(copy/Math.pow(i,pow));
                }
            }
        }

        double endTime = System.nanoTime();
        System.out.println("\nTook "+((endTime - startTime)/Math.pow(10,9))+" seconds.");

        while(true)
        {
            System.out.println("Do you want to factorize another number? \nPress 1 for 'Yes' or 0 'No'.");
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

    static boolean isprime(int a)
    {
        /* this loop checks if a number is prime or not by seeing how many factors that number has;
         * if it is more than 0(excluding 1 and itself; which is why is starts from 2) then that number is a composite;
         * it only runs till the square-root of that number since the smallest factor of any number will be less than or equal to its square-root;
         * this gives us a factor of the number(if it has any) in the quickest way(at least for now and from what I know).
         */
        for(int i = 2; i <= Math.sqrt(a); i++)
        {
            if(a%i == 0)
            {
            	return false;
            }
        }
        
        return true;
        
    }
  
    static int check(double b, int d)
    {
        int cnt = 0;
        while(b > 0)//this finds us the power of that prime factor by checking how many times it can divide that number
        {
            if(b%d == 0)
            {
                b = b/d; 
                cnt++;
            }
            else
            {
                return cnt;
            }
        }
        return cnt;
    }

    static void display(int i, int pow,  double num)
    {
        if (i == num)
        {
            System.out.print(i);
        }
        else
        {
            if(pow == 1)
            {
                System.out.print(i+"*");
            }
            else if((pow > 1)&&(num/Math.pow(i,pow)) == 1)
            {
                System.out.print("("+i+"^"+pow+")");
            }
            else
            {
                System.out.print("("+i+"^"+pow+")*");
            }
        }
    }
}