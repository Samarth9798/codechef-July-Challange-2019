T = int(input())

while T:
    N = int(input())
    a = list(map(int,input().split()))
    
    s = sum(a)
    mean = s / N
    ans = -1
    
    for i in range(0,len(a)):
        temp = s - a[i]
        temp = temp / (N-1)
        if temp == mean:
            if ans == -1:
                ans = i+1
            elif a[ans-1] > a[i]:
                ans = i+1
    if ans > 0:
        print(ans)
    else:
        print("Impossible")
    T-=1
