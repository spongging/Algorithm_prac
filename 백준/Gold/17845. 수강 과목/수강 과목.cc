#include <iostream>
#include <vector>
using namespace std;
int dp[1001][10001] = { 0 };
vector<pair<int, int>>v; 
int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	int N, K; cin >> N >> K;
	v.push_back(make_pair(0, 0));
	for (int i = 0; i < K; i++)
	{
		int I, T; cin >> I >> T;
		v.push_back(make_pair(I, T));
	}
	//
	
	//
	for (int i = 1; i <= K ; i++)
	{
		int init = v[i].second; 
		for (int j = 1; j <= N; j++)
		{
			
			if (init > j)
			{
				dp[i][j] = dp[i - 1][j];
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i].second] + v[i].first);
			}
		}
	}
	cout << dp[K][N] << "\n";
	return 0;
}