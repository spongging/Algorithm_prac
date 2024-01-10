#include <iostream>
#include <vector>
using namespace std;
int dp[101][100001];
int main(void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, K, W, V; cin >> N >> K;
	vector<pair<int, int>>v;
	v.push_back(make_pair(0, 0));

	for (int i = 0; i < N; i++)
	{
		cin >> W >> V;
		v.push_back(make_pair(W, V));
	}
	//초기화
	for (int i = 0; i <= K; i++)
	{
		dp[0][i] = 0;
	}
	for (int i = 0; i <= N; i++)
	{
		dp[i][0] = 0;
	}
	//dp 배열 입력 시작
	for (int i = 1; i <= N ; i++)
	{
		for (int j = 1; j <= K; j++)
		{
			if (v[i].first > j)
			{
				dp[i][j] = dp[i - 1][j];
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i].first] + v[i].second); 
			}
		}
	}
	cout << dp[N][K] << "\n";

	return 0;
}