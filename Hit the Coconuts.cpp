#include<bits/stdc++.h>
using namespace std;
#define fast ios::sync_with_stdio(0), cout.tie(0), cin.tie(0);
typedef long long int ll;
#define endl "\n"

int N,Z;
ll a[1005];
ll dp[1005][1005];

void solve(int i, int rem)
{
    if(rem == 0)
    {
        return;
    }
    
    ll res = 1e15;
    int cnt = 0;
    for(int j = i; j < N-rem+1; j++)
    {
        ll temp = a[j] + (cnt*a[j]);
        if(dp[j+1][rem-1] == 0 && temp < res)
        {
            solve(j+1,rem-1);
        }
        temp = temp + dp[j+1][rem-1];
        if(temp < res) 
            res = temp;
        cnt++;
    }
    dp[i][rem] = res;
}

int main()
{
    fast
    
    int T;
    cin >> T;
    while(T--)
    {
        cin >> N >> Z;
        
        for(int i = 0; i < N; i++)
            cin >> a[i];
        
        sort(a,a+N, greater<ll>());
        
        for(int i = 0; i < N; i++)
            for(int j = 1; j <= Z; j++)
                dp[i][j] = 0;
        
        solve(0,Z);
    
        cout << dp[0][Z] << endl;
    }
}
