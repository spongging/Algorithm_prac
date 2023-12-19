#include <iostream>
using namespace std;
int dp[5001] = { 0,0,0,1,0,1 };
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int N; cin >> N;
    for (int i = 6; i <= N; i++)
    {
        if (dp[i - 3] == 0 && dp[i - 5] != 0)
        {
            dp[i] = dp[i - 5] + 1;
        }
        else if (dp[i - 3] != 0 && dp[i - 5] == 0)
        {
            dp[i] = dp[i - 3] + 1;
        }
        else if (dp[i - 3] != 0 && dp[i - 5] != 0)
        {
            dp[i] = min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
        else
        {
            dp[i] == 0;
        }
    }
    if (dp[N]==0)
    {
        cout << -1 << "\n";
    }
    else
    {
        cout << dp[N] << "\n";
    }
    return 0;
}
