#include<bits/stdc++.h>
using namespace std;
#define fast ios::sync_with_stdio(0), cout.tie(0), cin.tie(0);
typedef long long int ll;

int main()
{
    fast
    
    int T;
    cin >> T;
    while(T--)
    {
        int Q;
        cin >> Q;
        
        ll e = 0, o = 0;
        set<ll> s;
        while(Q--)
        {
            ll x;
            cin >> x;
            
            if(s.find(x) == s.end())
            {
                e = o = 0;
                vector<ll> v;
                int bits;
                for(auto it = s.begin(); it != s.end(); it++)
                {
                    ll temp = (*it^x);
                    if(s.find(temp) == s.end())
                        v.push_back(temp);
                    bits = __builtin_popcount(*it);
                    (bits&1) ? o++ : e++;
                }
                for(int i = 0; i < v.size(); i++)
                {
                    s.insert(v[i]);
                    bits = __builtin_popcount(v[i]);
                    (bits&1) ? o++ : e++;
                }
                bits = __builtin_popcount(x);
                (bits&1) ? o++ : e++;
                s.insert(x);
            }    

            cout << e << ' ' << o << endl;
        }
    }
}
