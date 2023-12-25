#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int dp[50001];
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    cout.tie(NULL); 
    int N; cin >> N;
    dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 3;
    for (int i = 1; i * i <= N; i++)
    {
        dp[i*i] = 1;
    }
    for (int i = 4; i <= N; i++)
    {
        if (dp[i] != 1) {
            dp[i] = INT_MAX;
        }
        for (int j = 1; j * j <= i; j++)
        {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }
    cout << dp[N] << "\n";
    return 0;
}
