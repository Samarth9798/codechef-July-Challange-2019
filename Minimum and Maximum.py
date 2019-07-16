T = int(input())

while T:
    N = int(input())
    K = int(input())
    
    if K%N == 0:
        print(0)
    else:
        K = K%N
        a = [1]*(N)
        
        if  K > N//2:
            cnt = N-K
            
            i = 1
            while cnt > 0:
                a[i] = 0
                cnt -= 1
                i += 2
        else:
            a = [0]*(N)
            cnt = K
            
            i = 1
            while cnt > 0:
                a[i] = 1
                cnt -= 1
                i += 2

        ans = 0
        for i in range(0,N-1):
            ans += abs(a[i] - a[i+1])
            
        print(ans)
    T-=1
