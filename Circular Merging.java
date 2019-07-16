import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static Vector<Long> a;
    static long dp[][];
    
    static void solve(int L, int R, Long cost)
    {
        if(L == R)
        {
            dp[L][R] = 0L;
            return;
        }
        
        long res = cost;
        long x = 0L;
        int mid = R;
        long c = Long.MAX_VALUE;
        for(int i = R-1; i >= L; i--)
        {
            long temp = a.get(i);
            x = x + temp;
            mid--;
            
            if(dp[L][mid] == -1L)
                solve(L,mid,cost-x);
            if(dp[mid+1][R] == -1L)
                solve(mid+1,R,x);
            
            c = Math.min(c, dp[L][mid]+dp[mid+1][R]);
        }
        
        dp[L][R] = res + c;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner in = new Scanner(System.in);
	    
	    int T = in.nextInt();
	    while(T-- > 0)
	    {
	        int N = in.nextInt();
	        
	        long s = 0L;
	        a = new Vector<>();
	        for(int i = 0; i < N; i++)
	        {
	            long x = in.nextLong();
	            s = s + x;
	            a.add(x);
	        }
	        
	        long ans = Long.MAX_VALUE;
	        dp = new long[N+5][N+5];
	        for(int i = 0; i <= N+1; i++)
	            for(int j = 0; j <= N+1; j++)
	                dp[i][j] = -1L;
	                
	       
	       long[][] cpy = new long[N+5][N+5];
	       for(int i = 0; i < N; i++)
	       {
	           solve(1,N,s);
	           ans = Math.min(ans, dp[1][N]);
	           
	           for(int j = 1; j <= N; j++)
	           {
	               for(int k = 1; k <= N; k++)
	               {
	                   cpy[j][k] = dp[j][k];
	                   dp[j][k] = -1L;
	               }
	           }
	           for(int j = 1; j < N; j++)
	                for(int k = 1; k < N; k++)
	                    dp[j+1][k+1] = cpy[j][k];
	                    
	           long temp = a.lastElement();
	           a.removeElementAt(N-1);
	           a.add(0,temp);
	       }
	       
	       System.out.println(ans);
	    }
	}
}
