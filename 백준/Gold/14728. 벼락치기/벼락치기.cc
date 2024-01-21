#include <iostream>
#include <vector>
using namespace std;
int dp[101][10001];
int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	vector<pair<int, int>>v;
	v.push_back(make_pair(0, 0));
	int N, T; cin >> N >> T;
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		v.push_back(make_pair(a, b));
	}
	for (int i = 0; i <= T; i++) dp[0][i] = 0; //init the dp table
	for (int i = 0; i <= N; i++) dp[i][0] = 0;
	// dp
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= T; j++)
		{
			if (v[i].first > j)
			{
				dp[i][j] = dp[i - 1][j];
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i-1][j - v[i].first] + v[i].second);
			}
		}
	}
	cout << dp[N][T] << "\n";


	return 0;
}