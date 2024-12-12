#include <iostream>
using namespace std;
typedef long long ll;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int arr[101][101];
    ll dp[101][101]; 
    int N; cin >> N; 
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++) dp[i][j] = 0;
    }
    dp[0][0] = 1;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (dp[i][j] == 0 || arr[i][j]==0) continue;
            int right = j + arr[i][j]; 
            int down = i + arr[i][j]; 
            if (right<N) 
            {
                dp[i][right]+=dp[i][j];
               
            } 
            if (down<N) 
            {
                dp[down][j]+=dp[i][j]; 
               
            }
        }
    }
    cout << dp[N - 1][N - 1] << "\n";
    return 0;
}
