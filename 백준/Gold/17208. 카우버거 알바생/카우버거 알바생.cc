#include <iostream>
#include <vector>
using namespace std;
int dp[101][301][301] = { 0, };
vector<pair<int, int>>v;
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K; cin >> N >> M >> K; 
    v.push_back(make_pair(0, 0));

    for (int i = 0; i < N; i++)
    {
        int x, y; cin >> x >> y;
        v.push_back(make_pair(x, y)); 
    }

    //dp
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
        {
            for (int k = 1; k <= K; k++)
            {
                if (v[i].first <= j && v[i].second <= k)
                {
                    dp[i][j][k] = max(dp[i - 1][j][k], dp[i - 1][j - v[i].first][k - v[i].second] + 1);
                }
                else
                {
                    dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
    }
    cout << dp[N][M][K] << "\n";
    return 0;
}
