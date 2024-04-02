#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;
 
int T, N;
int dp[1010];
int arr[1010];
 
int main(void)
{
//    freopen("B10211_input.txt", "r", stdin);
    
    cin >> T;
    
    while(T--)
    {
        cin    >> N;
        
        for(int i = 1; i <= N; i++)
        {
            cin >> arr[i];
        }
        
        int Max = -99999999;
 
        for(int i = 1; i <= N; i++)
        {
            dp[i] = max(0, dp[i-1]) + arr[i];
            Max = max(Max, dp[i]);
        }
        
        cout << Max << endl;
    }
    
    return 0;
}
