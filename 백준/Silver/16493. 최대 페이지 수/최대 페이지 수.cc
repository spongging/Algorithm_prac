#include <iostream>
#include <vector>
using namespace std;
int dp[21][201]; // M , N
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M; cin >> N >> M;
	vector<pair<int, int>>v; 
	v.push_back({ 0,0 });
	for (int i = 0; i < M; i++)
	{
		int a, b; cin >> a >> b;
		v.push_back(make_pair(a, b)); 
	}
	for (int i = 0; i <= N; i++) dp[0][i] = 0;
	for (int i = 0; i <= M; i++) dp[i][0] = 0;
	for (int i = 1; i <= N; i++)
	{
		int w = i; 
		for (int j = 1; j <= M; j++)
		{
			if (w < v[j].first)
			{
				dp[j][i] = dp[j - 1][i];
			}
			else
			{
				dp[j][i] = max(dp[j - 1][i], dp[j - 1][w - v[j].first] + v[j].second);
			}
		}
	}
	cout << dp[M][N] << "\n";

	return 0;
}