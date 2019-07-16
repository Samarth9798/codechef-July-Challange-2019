import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static long find(long x, long y, long xx, long yy, long check)
    {
        if(check%2L == 0 && x%2L == xx && y%2L == yy)
        {
            return 2L;
        }
        while(check%2L == 0)
            check /= 2L;
            
        for(long i = 3L; i <= Math.sqrt(check); i += 2L)
        {
            if(check%i == 0 && x%i == xx && y%i == yy)
                return i;
            while(check%i == 0)
                check /= i;
        }
        if(check > 1 && x%check == xx && y%check == yy) 
            return check;
            
        return -1L;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner in = new Scanner(System.in);
	    
	    int T = in.nextInt();
	    
	    while(T-- > 0)
	    {
	        long x = (long)Math.pow(2,16);
	        long y = (long)Math.pow(3,9);
	        long xx,yy;
	        
	        System.out.println("1 "+x);
	        xx = in.nextLong();
	        
	        System.out.println("1 "+y);
	        yy = in.nextLong();
	        
	        x = x*x;
	        y = y*y;
	        
	        long ans = find(x,y,xx,yy,x-xx);
	        
	        System.out.println("2 "+ans);
	        String s = in.next();
	        if(s == "No")
	            break;
	    }
	}
}
