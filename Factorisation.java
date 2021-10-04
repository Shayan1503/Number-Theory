/*
 * @author : Shayan Dasgupta
 * 
 * Gives us the unique prime factorisation of an integer.
 */
import java.util.*;
class Factorisation
{
    static Scanner sc = new Scanner();
    public static void main (String[] args)
    {
        driver();

        while(true)
        {
            System.out.println("Do you want to factorize another number? \nPress 1 for 'Yes' or 0 'No'.");
            int ch = sc.nextInt();
            switch(ch)
            {
            case 1: driver();
            		break;
            case 0: System.exit(0);
            		break;
            default: System.out.println("Invalid input.");
            }
        }
    }

    static boolean isprime(int a)
    {
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
    
    //this method for a presentable output
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
    
    static void driver()
    {
        System.out.print("Enter number:");
        int n = sc.nextInt();
        System.out.print(n+" = ");

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
    }
}
