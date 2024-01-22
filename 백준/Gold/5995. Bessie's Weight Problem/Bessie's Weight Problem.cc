#include <iostream>
#include <vector>
using namespace std;
int dp[501][45001] = { 0 };
vector<int>v;
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int H, N; cin >> H >> N;
    v.push_back(0); 
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    //
    for (int i = 1; i <= N; i++)
    {
        int init = v[i];
        for (int j = 1; j <= H; j++)
        {
            if (init > j)
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
            {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - init] + init);
            }
        }
    }
    cout << dp[N][H] << "\n";
    return 0;
}
