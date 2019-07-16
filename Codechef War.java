import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static long power_of_two[];
    static long N;
    static long a[];
    
    static long solve(long left, long right, long pos)
    {
        long cnt1 = pos-1,cnt2 = N;
        long p1 = 0, p2 = 0;
        
        long res = 0;
        long f1,f2;
        
        while(left+right > 1)
        {
            if(left > 0)
            {
                f1 = (left&1L);
                left = left/2L + f1;
                
                if(f1 == 1)
                {
                    res = res + a[(int)cnt1];
                }
                else
                {
                    cnt1 = cnt1 - power_of_two[(int)p1];
                }
                p1++;
            }
            
            f2 = (right&1L);
            right = right/2L + f2;
            
            if(f2 == 1)
            {
                if(left > 0) 
                    left--;
                else
                {
                    res = res + a[(int)cnt2];
                }
            }
            else
            {
                cnt2 = cnt2 - power_of_two[(int)p2];
            }
            p2++;
        }
        
        return res;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner in = new Scanner(System.in);
	    
	    int T = in.nextInt();
	    
	    power_of_two = new long[25];
	    for(int i = 0; i <= 23; i++)
	    {
	        power_of_two[i] = (int)Math.pow(2,i);
	    }
	    
	    while(T-- > 0)
	    {
	        N = in.nextLong();
	        N -= 1;
	        a = new long[(int)N+5];
	        
	        for(int i = 1; i <= N; i++)
	            a[i] = in.nextLong();
	       
	        long F = in.nextLong();
	        
	        long D = Long.MAX_VALUE;
	        
	        long P = 0;
	        
	        for(int i = 1; i <= N; i++)
	        {
	            if(a[i] <= F)
	            {
	                long temp = solve(i-1, N-i+1, i);
	                
	                if(temp < D)
	                {
	                    D = temp;
	                    P = i;
	                }
	            }
	            if(D == 0)
	                break;
	        }
	        
	        if(P == 0)
	        {
	            System.out.println("impossible");
	        }
	        else
	        {
	            System.out.println("possible");
	            D = D + F;
	            System.out.println(P + " " + D);
	        }
	    }
	}
}
